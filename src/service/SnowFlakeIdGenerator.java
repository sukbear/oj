package service;

import java.util.concurrent.*;

/***
 *@ClassName SnowFlakeIdGenerator
 *@Description
 * @author sukbear
 * @create 2019-05-21 19:48
 */
public class SnowFlakeIdGenerator {
    /**
     * 初始时间戳 2017-01-01
     */
    private static final long INITIAL_TIME_STAMP = 1483200000000L;
    /**
     * 机器所占位数
     */
    private static final long WORKER_ID_BITS = 5L;
    /**
     * 数据标识所占位数
     */
    private static final long DATACENTER_ID_BITS = 5L;
    /**
     * 支持的最大机器id，结果是31
     * 这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 支持的最大数据标识id，结果是31
     */
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
    /**
     * 序列在ID中所占的位数
     */
    private final long SEQUENCE_BITS = 12L;
    /**
     * 机器偏移量
     */
    private final long WORKERID_OFFSET = SEQUENCE_BITS;
    /**
     * 数据中心ID的偏移量(12+5)
     */
    private final long DATACENTERID_OFFSET = SEQUENCE_BITS + SEQUENCE_BITS;
    /**
     * 时间截的偏移量(5+5+12)
     */
    private final long TIMESTAMP_OFFSET = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
    /**
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    /**
     * 工作ID
     */
    private long workerID;
    /**
     * 数据中心ID
     */

    private long dataCenterID;
    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;
    /**
     * 上次生成ID的时间戳
     */
    private long lastTimeStamp = -1L;

    /**
     * 构造函数
     *
     * @param workerID     工作ID (0~31)
     * @param dataCenterID 数据中心ID (0~31)
     */
    public SnowFlakeIdGenerator(long workerID, long dataCenterID) {
        if (workerID > MAX_WORKER_ID || workerID < 0) {
            throw new IllegalArgumentException(String.format("WorkerID 不能大于 %d 或小于 0", MAX_WORKER_ID));
        }
        if (dataCenterID > MAX_DATACENTER_ID || dataCenterID < 0) {
            throw new IllegalArgumentException(String.format("DataCenterID 不能大于 %d 或小于 0", MAX_DATACENTER_ID));
        }
        this.workerID = workerID;
        this.dataCenterID = dataCenterID;
    }

    /**
     * 获取下一个ID
     *
     * @return SnowflakeID
     */
    public synchronized long nextID() {
        long timeStamp = System.currentTimeMillis();
        /**如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常*/
        if (timeStamp < lastTimeStamp) {
            throw new RuntimeException("当前记录小于上一次的时间戳");
        }
        /**如果是同一时间生成的，则进行毫秒内序列*/
        if (lastTimeStamp == timeStamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            //sequence等于0说明毫秒内序列已经增长到最大值
            if (sequence == 0) {
                timeStamp = tilNextMillis(lastTimeStamp);
            }
        } else {//时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        //上次生成ID的时间截
        lastTimeStamp = timeStamp;
        //移位并通过或运算拼到一起组成64位的ID
        return ((timeStamp - INITIAL_TIME_STAMP) << TIMESTAMP_OFFSET) | (dataCenterID << DATACENTERID_OFFSET) | (workerID << WORKERID_OFFSET) | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        final SnowFlakeIdGenerator idGenerator = new SnowFlakeIdGenerator(1, 1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                long id = idGenerator.nextID();
                System.out.println(id);
            });
        }
        executorService.shutdown();
    }
}
