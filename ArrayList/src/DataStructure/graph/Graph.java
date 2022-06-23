package DataStructure.graph;

import com.sun.source.tree.IfTree;

import java.util.*;

public class Graph {
    private ArrayList<Node> graph;
    private int numberOfNodes;

    public Graph() {
        this.graph = new ArrayList<>();
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public Node get(int data) {
        if (!graph.contains(new Node(data))) return null;
        return graph.get(graph.indexOf(new Node(data)));
    }

    public void addEdge(int u, int v) {
        Node node1 = new Node(u);
        Node node2 = new Node(v);

        if (!graph.contains(node1)) {
            node1.getNeighbors().add(v);
            graph.add(node1);
            numberOfNodes++;
        } else {
            if (graph.get(graph.indexOf(node1)).getNeighbors().contains(v)) return;
            graph.get(graph.indexOf(node1)).getNeighbors().add(v);
        }

        if (!graph.contains(node2)) {
            node2.getNeighbors().add(u);
            graph.add(node2);
            numberOfNodes++;
        } else {
            if (graph.get(graph.indexOf(node2)).getNeighbors().contains(u)) return;
            graph.get(graph.indexOf(node2)).getNeighbors().add(u);
        }
    }

    public void renewNodes() {
        for (Node node : graph) {
            node.setVisited(false);
        }
    }

    public ArrayList<Integer> DFS(int firstData) {
        ArrayList<Integer> traverse = new ArrayList<>();
        if (!graph.contains(new Node(firstData)))
            throw new NullPointerException("There are not node data =" + firstData);
        Node firstNode = graph.get(graph.indexOf(new Node(firstData)));
        firstNode.setVisited(true);
        traverse.add(firstNode.getData());

        for (int nodeData : firstNode.getNeighbors()) {
            Node currentNode = graph.get(graph.indexOf(new Node(nodeData)));

            if (currentNode.isVisited()) continue;
            traverse.addAll(DFS(nodeData));
        }
        return traverse;
    }

    public ArrayList<Integer> BFS(int firstData) {
        if (!graph.contains(new Node(firstData)))
            throw new NullPointerException("There are not node data =" + firstData);

        ArrayList<Integer> traverse = new ArrayList<>();
        Queue<Node> traversQueue = new LinkedList<>();

        Node firstNode = graph.get(graph.indexOf(new Node(firstData)));
        traversQueue.add(firstNode);

        while (!traversQueue.isEmpty()) {
            Node currentNode = traversQueue.poll();

            if (!currentNode.isVisited()) {
                currentNode.setVisited(true);
                traverse.add(currentNode.getData());
                for (int data : currentNode.getNeighbors()) {
                    traversQueue.add(graph.get(graph.indexOf(new Node(data))));
                }
            }
        }
        return traverse;
    }

    public ArrayList<Integer> findPathByBFS(int firstData, int lastData) {
        if (!graph.contains(new Node(firstData)) || !graph.contains(new Node(lastData)))
            throw new NullPointerException("There are not node data =" + firstData + " or " + lastData);

        Hashtable<Integer, Integer> prev = new Hashtable<>(numberOfNodes);
        Queue<Node> traversQueue = new LinkedList<>();

        Node firstNode = graph.get(graph.indexOf(new Node(firstData)));
        traversQueue.add(firstNode);
        prev.put(firstData, 0);

        //neu queue da handle het hoac da tim thay LastNode can tim
        while (!traversQueue.isEmpty() || prev.contains(lastData)) {
            Node currentNode = traversQueue.poll();
            if (!currentNode.isVisited()){
            currentNode.setVisited(true);

            for (int data : currentNode.getNeighbors()) {
                //Add tat ca neighbor cua node hien tai vao queue
                if (!prev.containsKey(data)) {
                    traversQueue.add(graph.get(graph.indexOf(new Node(data))));
                    //Nhap vao hashtable key = data cua neighbor va value = data hien tai(nghia la prev cua neighbor)
                    prev.put(data, currentNode.getData());
                }
            }
        }}
        Stack<Integer> reversePath = new Stack<>();
        reversePath.add(lastData);
        int currentState = lastData;
        while (prev.get(currentState) != 0){
            reversePath.add(prev.get(currentState));
            currentState = prev.get(currentState);
        }

        ArrayList<Integer> path = new ArrayList<>();
        while (!reversePath.isEmpty()){
            path.add(reversePath.pop());
        }
        return path;
    }


    public void print() {
        for (Node node : graph) {
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.addEdge(1, 3);
        g1.addEdge(1, 8);
        g1.addEdge(3, 5);
        g1.addEdge(3, 9);
        g1.addEdge(5, 6);
        g1.addEdge(6, 9);
        g1.addEdge(6, 7);
        g1.addEdge(8, 2);
        g1.addEdge(8, 4);
        g1.addEdge(2, 4);

//        g1.print();
//        for (int data : g1.DFS(1)) {
//            System.out.print("-");
//            System.out.print(data);
//        }
//        System.out.println("");
//        g1.renewNodes();
//
//        for (int data : g1.BFS(1)) {
//            System.out.print("-");
//            System.out.print(data);
//        }
//    }

        for (int i:g1.findPathByBFS(1, 7)) {
            System.out.print(" - ");
            System.out.print(i);
        }
    }

}
