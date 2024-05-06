package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.printQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.removeQueue();
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

//使用素组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 数组最大容量
    private int front;
    private int rear;
    private int[] arr; // 该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部，指向队列头的前一个位置（不包含数据）
        rear = -1; // 指向队列尾部，指向队列尾的数据（包含数据）
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++; //让rear 后移
        arr[rear] = data;
    }

    //获取队列的数据，数据出队列
    public int removeQueue(){
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("Queue is empty");
        }
        front++;
        return arr[front];
    }

    //显式队列的所有数据
    public void printQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

    //显式队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return arr[front + 1];

    }
}