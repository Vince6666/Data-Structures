public interface Stack<E> {
    // 定义一个接口
    int getSize(); // 获取栈的大小
    boolean isEmpty(); // 判断是否为空栈
    void push(E e); // 入栈
    E pop(); // 出栈
    E peek(); // 查看栈顶
}
