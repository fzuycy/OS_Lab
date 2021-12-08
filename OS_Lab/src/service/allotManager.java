package service;


import pojo.Job;
import pojo.Partition;

import java.util.Collections;
import java.util.LinkedList;

//UI一个，选项卡格式(放左边？)，主要按钮初始化，新增作业，回收作业，查看分区情况（写两个界面？)
public class allotManager {//分配
//    public allotManager(){
//
//    }
    public static boolean FirstFitAllot(LinkedList<Partition>freeTable, LinkedList<Partition>occupyTable, Job job){//最先适应法

        //先拷贝一份freeTable进行排序后，对比作业找个第一个满足的分区，按照分区的始址对原数组进行查找，找到之后，进行删除或修改(刚好，直接移除该元素，分区大小较大，修改分区大小)，
        // 同时将新分配的分区加入occupyTable
        //最先适应法，freeTable正常情况下，就按地址始址顺序从小到大往下排
        boolean isAllotted=false;
        for (int i = 0; i < freeTable.size(); i++) {
            if(freeTable.get(i).getSize()>=job.getSize()){//找到第一个满足要求的分区大小大于作业大小，需要分割
                //已分配表新增了表项
                Partition targetPartion =new Partition(job.getPid(), job.getSize(),freeTable.get(i).getStart());
                occupyTable.add(targetPartion);
                //空闲表进行了删改
                if(freeTable.get(i).getSize()!=job.getSize()){
                    freeTable.get(i).setStart(freeTable.get(i).getStart()+job.getSize());//修改始址(把分区的前部割出去)
                    freeTable.get(i).setSize(freeTable.get(i).getSize()-job.getSize());//修改大小
                }
                else{//找到的分区大小与作业大小相同，直接把该分区从空闲表里移除
                    freeTable.remove(i);
                }
                isAllotted=true;
                break;
            }
        }
        return isAllotted;
    }
    public static boolean BestFitAllot(LinkedList<Partition>freeTable, LinkedList<Partition>occupyTable, Job job){//最佳适应法

        boolean isAllotted=false;
        LinkedList<Partition> freeTableCopy = (LinkedList<Partition>) freeTable.clone();
//        freeTableCopy.add(new Partition(44,4,10));
//
//        System.out.println("freeTable "+freeTable);
//
//        System.out.println("freeTableCopy "+freeTableCopy);
        Collections.sort(freeTableCopy,Collections.reverseOrder());//升序,从小到大
        int keyStart=-1;
        for (int i = 0; i < freeTableCopy.size(); i++) {
            if(freeTableCopy.get(i).getSize()>=job.getSize()){
                keyStart=freeTableCopy.get(i).getStart();
                break;
            }
        }
        for (int i = 0; i < freeTable.size(); i++) {
            if(freeTable.get(i).getStart()==keyStart){//找到第一个满足要求的分区
                //已分配表新增了表项
                Partition targetPartion =new Partition(job.getPid(), job.getSize(),freeTable.get(i).getStart());
                occupyTable.add(targetPartion);
                //空闲表进行了删改
                if(freeTable.get(i).getSize()!=job.getSize()){
                    freeTable.get(i).setStart(freeTable.get(i).getStart()+job.getSize());//修改始址(把分区的前部割出去)
                    freeTable.get(i).setSize(freeTable.get(i).getSize()-job.getSize());//修改大小
                }
                else{//找到的分区大小与作业大小相同，直接把该分区从空闲表里移除
                    freeTable.remove(i);
                }
                isAllotted=true;
                break;
            }
        }

        return isAllotted;
    }

    public static boolean WorstFitAllot(LinkedList<Partition>freeTable, LinkedList<Partition>occupyTable, Job job){//最坏适应法

        boolean isAllotted=false;
        LinkedList<Partition> freeTableCopy = (LinkedList<Partition>) freeTable.clone();
        Collections.sort(freeTableCopy);//降序,从大到小
        int keyStart=-1;
        for (int i = 0; i < freeTableCopy.size(); i++) {
            if(freeTableCopy.get(i).getSize()>=job.getSize()){
                keyStart=freeTableCopy.get(i).getStart();
                break;
            }
        }
        for (int i = 0; i < freeTable.size(); i++) {
            if(freeTable.get(i).getStart()==keyStart){//找到第一个满足要求的分区
                //已分配表新增了表项
                Partition targetPartion =new Partition(job.getPid(), job.getSize(),freeTable.get(i).getStart());
                occupyTable.add(targetPartion);
                //空闲表进行了删改
                if(freeTable.get(i).getSize()!=job.getSize()){
                    freeTable.get(i).setStart(freeTable.get(i).getStart()+job.getSize());//修改始址(把分区的前部割出去)
                    freeTable.get(i).setSize(freeTable.get(i).getSize()-job.getSize());//修改大小
                }
                else{//找到的分区大小与作业大小相同，直接把该分区从空闲表里移除
                    freeTable.remove(i);
                }
                isAllotted=true;
                break;
            }
        }

        return isAllotted;
    }


}
