package se.java8.paralleStream;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 框架是 Java7 提供了的一个用于并行执行任务的框架，
 *  是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。
 * 工作窃取（work-stealing）算法
 * 是指某个线程从其他队列里窃取任务来执行(先执行完任务的从其他线程的双端任务队列尾部 开始继续工作)。
 *
 * Fork/Join 框架的实现原理 ForkJoinPool 由 ForkJoinTask数组和 ForkJoinWorkerThread 数组组成，
 * ForkJoinTask 数组负责存放程序提交给 ForkJoinPool 的任务，
 * 而 ForkJoinWorkerThread 数组负责执行这些任务。
 *
 *
 * ForkJoinTask 的 fork 方法实现原理。
 * 当我们调用 ForkJoinTask 的 fork 方法时，
 * 程序会调用 ForkJoinWorkerThread 的 pushTask 方法异步的执行这个任务，
 * 然后立即返回结果。
 *
 * pushTask 方法把当前任务存放在 ForkJoinTask 数组 queue 里。
 * 然后再调用 ForkJoinPool 的 signalWork() 方法唤醒或创建一个工作线程来执行任务。
 *
 * ForkJoinTask 的 join 方法实现原理。Join 方法的主要作用是阻塞当前线程并等待获取结果。
 *
 * 首先，它调用了 doJoin() 方法，通过 doJoin() 方法得到当前任务的状态来判断返回什么结果，任务状态有四种：已完成（NORMAL），被取消（CANCELLED），信号（SIGNAL）和出现异常（EXCEPTIONAL）。

 如果任务状态是已完成，则直接返回任务结果。
 如果任务状态是被取消，则直接抛出 CancellationException。
 如果任务状态是抛出异常，则直接抛出对应的异常。
 */
public class Fork_Join_Frame extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;// 阈值
	private int start;
	private int end;

	public Fork_Join_Frame(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 任务大于阈值 就分割
			int middle = (start + end) / 2;
			Fork_Join_Frame leftTask = new Fork_Join_Frame(start, middle);
			Fork_Join_Frame rightTask = new Fork_Join_Frame(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待执行完毕

			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;

		}
		return sum;
	}

	public static void main(String[] args) {
		// 工作线程初始化
		ForkJoinPool fPool = new ForkJoinPool();
		// 任务初始化
		Fork_Join_Frame task = new Fork_Join_Frame(1, 4);

		Future<Integer> result = fPool.submit(task);
		if (task.isCompletedAbnormally()) {
			System.out.println(task.getException());
		}

		try {
			System.out.println(result.get().toString());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}