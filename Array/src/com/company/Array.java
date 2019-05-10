package com.company;

public class Array<T> {   // 使用泛型
    private T[] data; // 数组，在java中未赋值的数组元素的默认值为0
    private int size; // 数组元素个数, 等于第一个为空的元素的索引

    // 构造函数，传入数据的容量来构造Array
    public Array(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    // 无参数构造函数，默认数组的容量为10
    public Array(){
        this(10);   // 里面的capacity： 并不是语法的一部分，而是编辑器给的提示，表示传进来10是capacity
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组的大小
    public int getSize() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组的末尾添加元素
    public void addLast(T e){
        // 数组容量满抛出报错
        /*if(size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        data[size] = e;
        size ++;
         */
        add(size, e);
    }

    // 在数组开头添加一个元素
    public void addFirst(T e){
        add(0, e);
    }

    // 获取索引为index的数组元素
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        return data[index];
    }

    // 设置索引为index的数组元素
    public T set(int index, T e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        return data[index] = e;
    }

    // 在任意索引 index 出添加一个新元素
    public void add(int index, T e){

        if(index < 0 || index > size) // 判断索引是否合法
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    // 查找数组中是否包含元素 e
    public boolean contains(T e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    // 查找数组中元素 e 的索引，如果不存在则返回 -1
    public int find(T e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除索引为 index 的元素，并返回该元素
    public T remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        T ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // 缩减数组空间
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    // 删除数组首个元素，并返回
    public T removeFirst(){
        return remove(0);
    }

    // 删除数组最后一个元素，并返回
    public T removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素 e
    public void removeElement(T e){
        int index = find(e); // 找出要删除元素的索引
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if( i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    // 数组扩容
    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
