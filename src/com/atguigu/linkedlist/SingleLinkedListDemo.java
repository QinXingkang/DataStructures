package com.atguigu.linkedlist;

import org.w3c.dom.Node;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建结点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        //显式一把
        singleLinkedList.list();
    }
}
//定义SingleLinkedList管理英雄结点
class SingleLinkedList {
    //先初始化一个头结点
    private HeroNode head = new HeroNode(0, null, null);

    //添加节点到单向链表
    //思路，当不考虑编号的顺序时
    //1.找到当前链表的最后结点
    //2.将最后这个结点的next指向新的结点即可
    public void add(HeroNode heroNode) {
        //因为head结点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后结点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //显式链表
    public void list(){
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("list empty");
            return;
        }
        //因为头结点不能动，所以需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp== null) {
                break;
            }
            //将temp后移
            System.out.println(temp);
            temp = temp.next;
        }


    }
}

//定义HeroNode，每个HeroNode对象就是一个结点
class HeroNode{
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;

    //构造器
    public HeroNode(int hNo, String hName, String hNikeName) {
        this.no = hNo;
        this.name = hName;
        this.nikeName = hNikeName;
    }

    //重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}