import java.util.Random;

public class Main {

    public static void main(String[] args) {

     // write your code here
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//
//        for(int i = 0; i < 10; i++){
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }

/*
        Array<Integer> arr = new Array<>();

        for(int i = 0; i < 10; i++){
            arr.addLast(i);
            System.out.println(arr);
        }
        arr.removeFirst();
        System.out.println(arr);
*/

//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//
//        for(int i = 0; i < 5; i++){
//            loopQueue.enqueue(i);
//            System.out.println(loopQueue);
//
//            if(i % 3 == 2){
//                loopQueue.dequeue();
//                System.out.println(loopQueue);
//            }
//        }

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, Time: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, Time: " + time2 + "s");

    }


    // 测试数组队列和循环队列的性能差异
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime(); // 纳秒

        Random random = new Random();
        for(int i = 0; i < opCount; i++){   // 全部入队
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); // 生成 0 ~ MAX_VALUE 之间的随机数
        }
        for(int i = 0; i < opCount; i++){   // 全部出队
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0; // 转换为以秒作单位

    }
}
