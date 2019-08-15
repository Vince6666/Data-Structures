public class Main {

    public static void main(String[] args) {
	    // write your code here
        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
        int[] nums = {11, 7, 15, 5, 9, 13, 20, 3, 6, 8, 10, 12, 14, 18, 25};

        for(int num: nums)
            bst.add(num);

//        Boolean bool = bst.contains(6);
//        System.out.println(bool);

//        System.out.println(bst.toString());

//        bst.preOrderTraverse();
//        bst.inOrderTraverse();
//        bst.postOrderTraverse();
//        bst.preOrderNR();
//        bst.levelOrderTraverse();

//        int min = bst.minimum();
//        System.out.println(min);
//
//        int max = bst.maximum();
//        System.out.println(max);

//        int rmMin = bst.removeMin();
//        System.out.println(rmMin);
//        System.out.println(bst.toString());

//        int rmMax = bst.removeMax();
//        System.out.println(rmMax);
//        System.out.println(bst.toString());
//        System.out.println(bst);
        bst.remove(15);

        System.out.println(bst);

    }
}
