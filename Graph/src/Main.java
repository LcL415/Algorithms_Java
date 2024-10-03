import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class vertex{
        String name;
        List<Edge> edges;
        boolean visited;

        public vertex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static class Edge{
        vertex linked;
        int weight;
        public Edge(vertex linked){this(linked,1);}
        public Edge(vertex linked,int weight){
            this.linked=linked;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
 /*       vertex v1=new vertex("v1");
        vertex v2=new vertex("v2");
        vertex v3=new vertex("v3");
        vertex v4=new vertex("v4");
        vertex v5=new vertex("v5");
        vertex v6=new vertex("v6");
        v1.edges=List.of(new Edge(v3,9),new Edge(v2,7),new Edge(v6,14));
        v2.edges=List.of(new Edge(v4,15));
        v3.edges=List.of(new Edge(v4,11),new Edge(v6,2));
        v4.edges=List.of(new Edge(v5,6));
        v5.edges=List.of();
        v6.edges=List.of(new Edge(v5,9));
        bfs(v1);*/
       /* vertex v1=new vertex("v1");
        vertex v2=new vertex("v2");
        vertex v3=new vertex("v3");
        vertex v4=new vertex("v4");
        v1.edges=List.of(new Edge(v3,-2));
        v2.edges=List.of(new Edge(v3,3),new Edge(v1,4));
        v3.edges=List.of(new Edge(v4,2));
        v4.edges=List.of(new Edge(v2,-1));
        List<vertex>graph=List.of(v1,v2,v3,v4);
        floydWarshall(graph);*/
        

    }
//弗洛伊德算法 多边找最短路径
    private static void floydWarshall(List<vertex> graph) {
        int size=graph.size();
        //用表格记录顶点到顶点的最短路径
        int[][]dist=new int[size][size];
        vertex[][]prev=new vertex[size][size];
        //1. 初始化
        for (int i = 0; i < size; i++) {
            vertex v=graph.get(i);
            Map<vertex, Integer> map = v.edges.stream().collect(Collectors.toMap(e -> e.linked, e -> e.weight));
            for(int j=0;j<size;j++){
                vertex u=graph.get(j);
                if (v == u) {
                    dist[i][j]=0;
                }else {
                   dist[i][j]= map.getOrDefault(u,Integer.MAX_VALUE);
                   prev[i][j]=map.get(u)!=null?v:null;
                }
            }
        }

        //2. 看能否用借路来到达其他顶点
        for(int k=0;k<size;k++){
            for (int i = 0; i < size; i++) {
                for(int j=0;j<size;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE&&
                            dist[k][j]!=Integer.MAX_VALUE&&
                            dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                        prev[i][j]=prev[k][j];
                    }
                }
            }
            print(dist);
        }
    }
    public static void print(int[][]dist){
        System.out.println("----------");
        for (int[] row : dist) {
            System.out.println(Arrays.stream(row).boxed()
                    .map(x->x==Integer.MAX_VALUE?"&&":String.valueOf(x))
                    .map(s->String.format("%2s",s))
                    .collect(Collectors.joining(",", "[", "]")));
        }
    }
    public static void path(vertex[][] prev, List<vertex> graph, int i, int j){
        LinkedList<String>stack=new LinkedList<>();
        System.out.println("["+graph.get(i).name+"," +graph.get(j).name+"]");
        stack.push(graph.get(j).name);
        while (i != j) {
            vertex p=prev[i][j];
            stack.push(p.name);
            j=graph.indexOf(p);
        }
        System.out.println(stack);
    }

    // DFS: Deep First Search 深度优先遍历
    //递归实现
    private static void dfs(vertex v1) {
        v1.visited=true;
        System.out.println(v1.name);
        for (Edge edge : v1.edges) {
            if(!edge.linked.visited){
                dfs(edge.linked);
            }
        }
    }
    //非递归实现-用栈
    private static void dfs2(vertex v){
        LinkedList<vertex>stack=new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            vertex pop=stack.pop();
            pop.visited=true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if(!edge.linked.visited){
                    stack.push(edge.linked);
            }
            }
        }
    }

//DFS：Breadth first search: 广度优先遍历 队列实现
    private static void bfs(vertex v){
        LinkedList<vertex>queue=new LinkedList<>();
        queue.offer(v);
        v.visited=true;
        while (!queue.isEmpty()) {
            vertex poll=queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited=true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
// 拓扑排序

}