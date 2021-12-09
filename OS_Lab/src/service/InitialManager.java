package service;

import pojo.Job;
import pojo.Partition;

import java.util.Collections;
import java.util.LinkedList;

public class InitialManager {
    private static int  MemorySum=0;
    //初始化时有两个弹窗
    //首先是确定总内存大小(总内存从0K开始)
    // 其次是内存进行初始化（其实就是分配）
    // 在UI界面中应该是点击一个初始化按钮，然后弹出一个窗口，填入总内存后，点击确定后弹出第二个窗口初始化空闲表(其实就相当于也在初始化分配表)，
    // 填入已分配内存块的起始地址和长度（也可以直接×掉，相当于此时还未有内存被分配）
    //初始化空闲表时输入起始地址和长度
//    public InitialManager(){
//
//    }

    public static void IniTotal(LinkedList<Partition> freeTable,int size){//初始化总内存
        MemorySum=size;
        freeTable.add(new Partition(0,size,0));//将整块内存当做一个分区给分配表
    }


    public static boolean IniFreeTable(LinkedList<Partition> freeTable, LinkedList<Partition> occupyTable, LinkedList<Partition> prePartitions){

        //这里prePartition是初始化设置时手动设置的场景中已被占用的分区(pid,size,start自行指定，合适就行)
        //看看能不能写一个随机数随机分配一下

        boolean isInsert=false;

        Collections.sort(prePartitions,Collections.reverseOrder());//升序,从小到大
        //暂时先无脑添加
        for (int i = 0; i < prePartitions.size(); i++) {
            occupyTable.add(prePartitions.get(i));
        }


        if(freeTable.get(0).getStart()==0&&(freeTable.get(0).getSize()==MemorySum)){
            freeTable.remove(0);
        }
        for (int i = 0; i < prePartitions.size(); i++) {
            if(i==0){
                if(prePartitions.get(i).getStart()!=0){
                    freeTable.add(new Partition(-1,prePartitions.get(i).getStart(),0));
                }
                //freeTable.add(prePartitions.get(i));
                //continue;
            }else {
                freeTable.add(new Partition(-1,(prePartitions.get(i).getStart()-prePartitions.get(i-1).getStart()-prePartitions.get(i-1).getSize()),prePartitions.get(i-1).getStart()+prePartitions.get(i-1).getSize()));

            }
            if(i+1==prePartitions.size()){

                if((prePartitions.get(i).getStart()+prePartitions.get(i).getSize())!=MemorySum){
                    freeTable.add(new Partition(-1,(MemorySum-(prePartitions.get(i).getStart()+prePartitions.get(i).getSize())),(prePartitions.get(i).getStart()+prePartitions.get(i).getSize())));
                }
                isInsert=true;
            }
        }


//        if(MemorySum<prePartition.getSize()){
//            System.out.println("初始化设置失败！预先模拟分配的作业过大");
//        }else{
//            if(freeTable.get(0).getStart()==0&&(freeTable.get(0).getSize()==MemorySum)){
//                freeTable.remove(0);
//            }
//            //构造空闲表
//            for(int i=0;i<freeTable.size();i++){
//                if(freeTable.get(i).getStart()>prePartition.getStart()){
//                    freeTable.add(i,prePartition);
//                    isInsert=true;
//                    break;
//                }
//            }
//            if(isInsert==false){
//                System.out.println("预分配的已占用分区冲突！");
//            }
//        }

        return isInsert;

    }
}
