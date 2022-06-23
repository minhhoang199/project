package DataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node {
    private int data;
    private List<Integer> neighbors;
    private boolean isVisited;

    public Node(int data) {
        this.data = data;
        this.neighbors = new LinkedList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }



    public void setNeighBouts(ArrayList<Integer> neighBouts) {
        this.neighbors = neighBouts;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        return this.data == ((Node) o).getData();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNeighbors(), isVisited());
    }

    public List<Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Integer> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", neighBouts=" + neighbors +
                ", isVisited=" + isVisited +
                '}';
    }
}
