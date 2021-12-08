package test;

import org.junit.Test;
import pojo.Job;
import pojo.Partition;
import service.InitialManager;
import service.allotManager;
import service.recycleManager;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class tester {
    private LinkedList<Job> jobQueue = new LinkedList<>();//作业请求队列
    private int MemorySum = -1;//总内存
    private LinkedList<Partition> freeTable = new LinkedList<>();//空闲表
    private LinkedList<Partition> occupyTable = new LinkedList<>();//已分配表
    @Test
    public void test1(){
        //初始化内存
        MemorySum =100;
        InitialManager.IniTotal(freeTable,100);
        System.out.println("freeTable为 "+freeTable);
        showFreeTable(freeTable);
//        System.out.println("始址    长度");
//        for (int i = 0; i < freeTable.size(); i++) {
//            System.out.println(freeTable.get(i).getStart()+"K     "+freeTable.get(i).getSize()+"K");
//        }

        if(allotManager.FirstFitAllot(freeTable,occupyTable,new Job(1,20))){
            System.out.println("分配完成");
        }else{
            System.out.println("分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);


        if(allotManager.FirstFitAllot(freeTable,occupyTable,new Job(2,30))){
            System.out.println("分配完成");
        }else{
            System.out.println("分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,1);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        if(allotManager.FirstFitAllot(freeTable,occupyTable,new Job(3,10))){
            System.out.println("分配完成");
        }else{
            System.out.println("分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,2);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,3);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);




//        //打印空闲表
//        System.out.println("始址    长度");
//        for (int i = 0; i < freeTable.size(); i++) {
//            System.out.println(freeTable.get(i).getStart()+"K    "+freeTable.get(i).getSize()+"K");
//        }

//        //打印已分配表
//        System.out.println("进程号    始址    长度");
//        for (int i = 0; i < occupyTable.size(); i++) {
//            System.out.println(occupyTable.get(i).getPid()+"        "+occupyTable.get(i).getStart()+"K      "+occupyTable.get(i).getSize()+"K");
//        }
    }
    @Test
    public void test2(){//测试排序方法
        freeTable.add(new Partition(-1,20,0));
        freeTable.add(new Partition(-1,30,40));
        freeTable.add(new Partition(-1,10,100));
        freeTable.add(new Partition(-1,35,115));
//        freeTable.add(new Partition(-1,20,0));
//        freeTable.add(new Partition(-1,20,0));
//        freeTable.add(new Partition(-1,20,0));
//        freeTable.add(new Partition(-1,20,0));
        Collections.sort(freeTable);//降序
        showFreeTable(freeTable);

        Collections.sort(freeTable,Collections.reverseOrder());
        showFreeTable(freeTable);


    }
    @Test
    public void test3(){//数组拷贝测试
        freeTable.add(new Partition(-1,20,0));
        freeTable.add(new Partition(-1,30,40));
        freeTable.add(new Partition(-1,10,100));
        freeTable.add(new Partition(-1,35,115));

        allotManager.BestFitAllot(freeTable,occupyTable,new Job(3,10));
    }
    @Test
    public void test4(){
        //初始化内存
        MemorySum =100;
        Job myJob=null;
        InitialManager.IniTotal(freeTable,100);
        System.out.println("freeTable为 "+freeTable);
        showFreeTable(freeTable);
//        System.out.println("始址    长度");
//        for (int i = 0; i < freeTable.size(); i++) {
//            System.out.println(freeTable.get(i).getStart()+"K     "+freeTable.get(i).getSize()+"K");
//        }

        myJob=new Job(1,20);
        if(allotManager.BestFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(2,30);
        if(allotManager.BestFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(4,45);
        if(allotManager.BestFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);


        recycleManager.recycleMemory(freeTable,occupyTable,1);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(3,10);
        if(allotManager.BestFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,2);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,3);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

    }
    @Test
    public void test5(){
        //初始化内存
        MemorySum =100;
        Job myJob=null;
        InitialManager.IniTotal(freeTable,100);
        System.out.println("freeTable为 "+freeTable);
        showFreeTable(freeTable);
//        System.out.println("始址    长度");
//        for (int i = 0; i < freeTable.size(); i++) {
//            System.out.println(freeTable.get(i).getStart()+"K     "+freeTable.get(i).getSize()+"K");
//        }

        myJob=new Job(1,20);
        if(allotManager.WorstFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(2,30);
        if(allotManager.WorstFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(4,25);
        if(allotManager.WorstFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);


        recycleManager.recycleMemory(freeTable,occupyTable,1);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        myJob=new Job(3,10);
        if(allotManager.WorstFitAllot(freeTable,occupyTable,myJob)){
            System.out.println(myJob+"分配完成");
        }else{
            System.out.println(myJob+"分配失败");
        }
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,2);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);

        recycleManager.recycleMemory(freeTable,occupyTable,3);
        showFreeTable(freeTable);
        showOccupyTable(occupyTable);
    }


    public void showFreeTable(LinkedList<Partition> freeTable){
        //打印空闲表
        System.out.println("//////////////////////////////////////////////////");
        System.out.println("始址    长度");
        for (int i = 0; i < freeTable.size(); i++) {
            System.out.println(freeTable.get(i).getStart()+"K    "+freeTable.get(i).getSize()+"K");
        }
    }
    public void showOccupyTable(LinkedList<Partition> occupyTable){
        //打印已分配表
        System.out.println("//////////////////////////////////////////////////");
        System.out.println("进程号    始址    长度");
        for (int i = 0; i < occupyTable.size(); i++) {
            System.out.println(occupyTable.get(i).getPid()+"        "+occupyTable.get(i).getStart()+"K      "+occupyTable.get(i).getSize()+"K");
        }
    }

}
