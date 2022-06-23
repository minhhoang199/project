package DataStructure.Tree;

public class testTree {
    public static void main(String[] args) {
        BinarySearchTreeByMe<Integer> tree1 = new BinarySearchTreeByMe<>();
        tree1.add(10);
        tree1.add(6);
        tree1.add(7);
        tree1.add(4);
        tree1.add(5);
        tree1.add(14);
        tree1.add(13);
        tree1.add(16);
        tree1.add(2);

        tree1.traverse(TreeTraverse.PRE_ORDER);
        System.out.println("");
        tree1.traverse(TreeTraverse.IN_ORDER);
        System.out.println("");
        tree1.traverse(TreeTraverse.POST_ORDER);
        System.out.println("");
        tree1.traverse(TreeTraverse.LEVEL_ORDER);
        System.out.println("");
        System.out.println(tree1.contain(11));
        System.out.println(tree1.contain(13));
        System.out.println(tree1.isEmpty());
        System.out.println(tree1.size());
        System.out.println(tree1.height());
    }
}
