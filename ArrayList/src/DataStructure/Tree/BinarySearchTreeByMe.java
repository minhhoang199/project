package DataStructure.Tree;

import DataStructure.Queue.LinkedListBaseQueue;
import Stack.LinkedListBaseStack;
import Stack.StackADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class BinarySearchTreeByMe<T extends Comparable<T>> implements TreeADT {
    private TreeNode<T> root;
    private int nodeCount = 0;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return heightOfNode(root);
    }

    @Override
    public boolean contain(Object element) {
        return contain(root, (T) element);
    }

    @Override
    public boolean add(Object element) {
        if (contain(element)) return false;
        root = add(root, (T) element);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        if (!contain(element)) return false;
        root = remove(root, (T) element);
        nodeCount--;
        return true;
    }

    @Override
    public void traverse(TreeTraverse type) {
        switch (type) {
            case IN_ORDER: {
                inOrderTraverse(root);
                break;
            }
            case PRE_ORDER: {
                preOrderTraverse(root);
                break;
            }
            case POST_ORDER: {
                postOrderTraverse(root);
                break;
            }
            case LEVEL_ORDER: {
                levelOrderTraverse(root);
                break;
            }
            default: {
                System.out.println("Invalid traverse type");
                break;
            }
        }

    }


    //Private
    private int heightOfNode(TreeNode<T> node) {
        if (node == null) return 0;
        else
            return 1 + Math.max(heightOfNode(node.getLeft()), heightOfNode(node.getRight()));
    }

    private boolean contain(TreeNode<T> node, T element) {
        if (node == null) return false;
        int result = element.compareTo(node.getData());
        if (result < 0) return contain(node.getLeft(), element);
        else if (result > 0) return contain(node.getRight(), element);
        else return true;
    }

    private TreeNode<T> add(TreeNode<T> node, T element) {
        if (node == null) {
            node = new TreeNode<T>(element, null, null);
        } else {
            if (element.compareTo(node.getData()) < 0) {
                node.setLeft(add(node.getLeft(), element));
            } else if (element.compareTo(node.getData()) > 0) {
                node.setRight(add(node.getRight(), element));
            }
        }
        return node;
    }

    private TreeNode<T> remove(TreeNode<T> node, T element) {
        int result = element.compareTo(node.getData());
        if (result < 0) {
            node.setLeft(remove(node.getLeft(), element));
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), element));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                node.setData(null);
                node = null;
                return null;
            }
            if (node.getLeft() == null) {
                TreeNode<T> rightNode = node.getRight();
                node.setData(null);
                node = null;

                return rightNode;
            } else if (node.getRight() == null) {
                TreeNode<T> leftNode = node.getLeft();
                node.setData(null);
                node = null;

                return leftNode;
            } else {
                T temp = findLowestNode(node.getRight()).getData();
                node.setData(temp);
                node.setRight(remove(node.getRight(), temp));
            }
        }
        return node;
    }

    private TreeNode<T> findLowestNode(TreeNode<T> node) {
        if (node.getLeft() == null) return node;
        else return findLowestNode(node.getLeft());
    }

    //private Iterator<T> levelOrderTraverse(){}

    private void preOrderTraverse(TreeNode<T> currentNode) {
        if (currentNode == null) return;
        System.out.print(currentNode.getData() + " ");
        preOrderTraverse(currentNode.getLeft());
        preOrderTraverse(currentNode.getRight());
    }

    private void inOrderTraverse(TreeNode<T> currentNode) {
        if (currentNode == null) return;
//        if (currentNode.getLeft() == null) {
//            System.out.print(currentNode.getData() + " ");
//            inOrderTraverse(currentNode.getRight());
            inOrderTraverse(currentNode.getLeft());
            System.out.print(currentNode.getData() + " ");
            inOrderTraverse(currentNode.getRight());
        }


    private void postOrderTraverse(TreeNode<T> currentNode) {
        if (currentNode == null) return;
//        if (currentNode.getLeft() == null) {
//            postOrderTraverse(currentNode.getRight());
//            System.out.print(currentNode.getData() + " ");

            postOrderTraverse(currentNode.getLeft());
            postOrderTraverse(currentNode.getRight());
            System.out.print(currentNode.getData() + " ");
        }


    private void levelOrderTraverse(TreeNode<T> node){
        if (node == null) return;
        LinkedListBaseQueue<TreeNode<T>> queue = new LinkedListBaseQueue<>();
        queue.enQueue(node);

        while (!queue.isEmpty()){
            TreeNode<T> currentNode = (TreeNode<T>)queue.first();
            System.out.print(currentNode.getData() + " ");
            if(currentNode.getLeft() != null){
                queue.enQueue(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                queue.enQueue(currentNode.getRight());
            }
            queue.deQueue();
        }
    }


}
