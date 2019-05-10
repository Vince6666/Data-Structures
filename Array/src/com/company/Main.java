package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    /*    int[] arr = new int[10]; // 使用new 开辟空间，须指定空间大小，
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        int[] scores = new int[]{100, 90, 30}; // 指定初始值，空间大小自动为3
        for(int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }

        for(int score: scores){ // 也是遍历数组的一种方法，每一项为score
            System.out.println(score);
        }

        scores[0] = 98;
        for(int score: scores){
            System.out.println(score);
        }

     */

        Array<Integer> arr = new Array<>();

        for(int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addLast(12);
        System.out.println(arr);

        arr.add(2,20);
        System.out.println(arr);


/*
        arr.set(1, 11);
        arr.addFirst(-1);
        System.out.println(arr.get(1));
        System.out.println(arr);
*/

        arr.remove(1);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
//        System.out.println(las);

        arr.removeElement(20);
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();

        arr.removeLast();
        arr.removeLast();
        arr.removeLast();

        System.out.println(arr);

    }
}
