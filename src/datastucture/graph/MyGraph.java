package datastucture.graph;

import java.util.*;

/**
 * @author sukbear
 * @create 2019-02-19 16:26
 */
public class MyGraph {
    Map<String, List<String>> graph = new HashMap<>(16);
    public void initData(){
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "8", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5", "6"));
        graph.put("9", Arrays.asList("6", "7"));
        /*graph.put("10",Arrays.asList("11"));
        graph.put("11",Arrays.asList("10"));*/
    }

    Queue<String> queue = new LinkedList<>();
    Map<String,Boolean> status = new HashMap<>();
    public void BFS(String startPoint){
        queue.add(startPoint);
        status.put(startPoint,false);
        bfsloop();
    }
    private void bfsloop(){
        /*访问对头元素并更新状态*/
        String currentElement = queue.poll();
        status.put(currentElement,true);
        System.out.println(currentElement);
        /*找出与此邻接点且尚未访问的点，进行标记，入队*/
        List<String> neghiborPoints = graph.get(currentElement);
        for (String point : neghiborPoints){
            if(!status.getOrDefault(point,false)){
                if(queue.contains(point)){
                    continue;
                }
                queue.add(point);
                status.put(point,false);
            }
        }
        if(!queue.isEmpty()){
            bfsloop();
        }
    }

    public static void main(String[] args) {
        MyGraph mg = new MyGraph();
        mg.initData();
        mg.BFS("1");
    }
}
