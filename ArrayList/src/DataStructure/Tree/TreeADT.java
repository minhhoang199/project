package DataStructure.Tree;

import java.util.Iterator;

public interface TreeADT<T> {
    boolean isEmpty();
    int size();
    int height();
    boolean contain(T element);
    boolean add(T element);
    boolean remove(T element);
    void traverse(TreeTraverse type);
}
