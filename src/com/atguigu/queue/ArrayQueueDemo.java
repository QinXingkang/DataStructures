package com.atguigu.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

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
}