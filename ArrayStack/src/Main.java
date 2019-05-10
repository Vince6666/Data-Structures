public class Main {

    public static void main(String[] args) {
	    // write your code here
        ArrayStack<Integer> stack = new ArrayStack<>(10);

        for(int i = 0; i < 5; i++){
            stack.push(i); // 入栈 0 - 4
            System.out.println(stack);
        }

        stack.pop(); // 出栈
        System.out.println(stack); // stack:[0, 1, 2, 3] top
        System.out.println(stack.peek()); // 查看栈顶 3
        System.out.println(stack.getCapacity()); // 10
        System.out.println(stack.getSize()); // 4

    }
}
