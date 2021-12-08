package view;

import pojo.Job;
import pojo.Partition;

import java.util.LinkedList;

public class UI {
    private LinkedList<Job> jobQueue = new LinkedList<>();//作业请求队列
    private int MemorySum = -1;//总内存
    private LinkedList<Partition> freeTable = new LinkedList<>();//空闲表
    private LinkedList<Partition> occupyTable = new LinkedList<>();//已分配表

    //空闲表显示时无需显示pid
    //分配表显示时需要显示pid
    public UI(){


    }

}
