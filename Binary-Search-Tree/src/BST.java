import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {

    // 节点类是二分搜索树的一个私有内部类，
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    // 构造函数
    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    // 判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加元素e
//    public void add(E e){
//
//        if(root == null){
//            root = new Node(e);
//            size++;
//        }
//        else
//            add(root,e);
//    }

    // 向以 node 为根节点的二分搜索树添加新元素e
//    private void add(Node node, E e){
//
//        if(e.equals(node.e))
//            return;
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else
//            add(node.right,e);
//    }

    // inproved
    // 向二分搜索树中添加元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以 node 为根节点的二分搜索树添加新元素e， 递归算法，
    // 并返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else
            node.right = add(node.right, e);

        return node;
    }


    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    // 看以 node 为根的二分搜索树是否包含元素e
    private boolean contains(Node node, E e){

        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }


    // 前序遍历
    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    // 前序遍历以 node 为根的二分搜索树，递归算法
    private void preOrderTraverse(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    // 中序遍历
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    // 中序遍历以 node 根的二分搜索树，递归算法
    private void inOrderTraverse(Node node) {
        if(node == null) {
            return;
        }

        inOrderTraverse(node.left);
        System.out.println(node.e);
        inOrderTraverse(node.right);
    }


    // 后序遍历
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    // 后序遍历以 node 为根的二分搜索树，递归算法
    private void postOrderTraverse(Node node) {
        if(node == null) {
            return;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.println(node.e);
    }


    // 前序遍历，非递归算法（使用到：栈）
    public void preOrderNR() {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

    }


    // 层次遍历（使用到：队列，链表）
    public void levelOrderTraverse() {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();   // java 的 Queue 只是一个接口，需要其他类来实现
        queue.add(root);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    // 获取二分搜索树中 最小元素
    public E minimum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    // 返回以 node 为根的二分搜索树的最小结点
    private Node minimum(Node node) {
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }


    // 获取二分搜索树中 最大元素
    public E maximum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    // 返回以 node 为根的二分搜索树的最小结点
    private Node maximum(Node node) {
        if(node.right == null)
            return node;

        return maximum(node.right);
    }


    // 从二分搜索树中删除最小值的结点，返回最小值
    public E removeMin() {
        E ret = minimum();  // 需在删除之前保存该值
        root = removeMin(root);
        return ret;
    }

    // 删除以 node 为根的二分搜索树中的最小结点， 返回删除结点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;  // 返回本次的根
    }


    // 从二分搜索树中删除最大值的结点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除以 node 为根的二分搜索树中的最小结点， 返回删除结点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    // 从二分搜索树中删除指定元素的结点
    public void remove(E e) {
        root = remove(root, e);

    }
    // 删除以 node 为根的二分搜索树中值为 e 的结点，返回删除结点后新的二分搜索树的根（递归算法）
    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }

        // 目标结点小于当前结点的值，进入左子树
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        // 目标结点大于当前结点的值，进入右子树
        else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        // 找到目标结点
        else {
            // 待删除结点只有左结点
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除结点只有右结点
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除结点有左右结点, 找到待删除结点的右子树中最小的结点，取代删除的结点

        /*  断开待删除的结点之前的左右子树，再重新连接 */
        /*    Node replaceNode = minimum(node.right);    // 保存代替的结点
            replaceNode.right = removeMin(node.right); // 删除它，并将原来的右子树连接到代替的结点上
            replaceNode.left = node.left;              // 将原来的左子树连接到代替的结点上
            node.left = node.right = null;             // 断开原来的左右子树连接

            return replaceNode;  // 返回代替的结点
        */
            // 或者： 不需要断开左右子树，直接找到代替的结点，将其值赋给待删除的结点，再删除代替的结点
            Node replaceNode = minimum(node.right);
            node.e = replaceNode.e;
            node.right = removeMin(node.right);

            return node;

        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以 node 为根，深度为 depth 的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            res.append("---");
        }
        return res.toString();
    }
}
