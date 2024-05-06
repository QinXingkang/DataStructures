package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("测试数组模拟环形队列的案例");
        //创建一个队列
        CircleArray arrayQueue = new CircleArray(4);// 实际大小为4-1
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //打印一个菜单
        while (loop) {
            System.out.println("s(show):显式队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据是：" + res);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

class CircleArray {
    private int maxSize; // 数组最大容量

    //front变量的含义做一个调整，front就指向队列的第一个元素，
    // 也就是说arr[front]就是队列的第一个元素，front的初始值=0
    private int front;

    //rear变量的含义做一个调整，rear指向队列的最后一个元素的后一个位置，
    // 因为希望空出一个空间做为约定，rear的初始值=0
    private int rear;
    private int[] arr; // 该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        //直接将数据加入
        arr[rear] = data;
        //将rear后移，这里必须取模
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据，数据出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("Queue is empty");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移,需要考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显式队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        //思考：从front开始遍历，遍历多少个元素
        for(int i = front; i < front + size() ; i++){
            System.out.println(arr[i % maxSize] + " ");
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显式队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];

    }
}