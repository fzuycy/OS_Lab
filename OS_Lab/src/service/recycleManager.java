package service;

import pojo.Partition;

import java.util.LinkedList;

public class recycleManager {
//    public recycleManager(){
//
//    }

    public static void recycleMemory(LinkedList<Partition> freeTable, LinkedList<Partition>occupyTable,int pid){//回收并合并内存
            //根据作业进程号进行分区资源的回收和合并
        Partition targetPartition=null;
        for (int i = 0; i < occupyTable.size(); i++) {
            if(occupyTable.get(i).getPid()==pid){
                targetPartition=occupyTable.get(i);
                occupyTable.remove(i);
                break;
            }
        }
        boolean isRecycle=false;
        //int pos=-1;
        for (int i = 0; i < freeTable.size(); i++) {
//            if(freeTable.get(i).getStart()> targetPartition.getStart()){//可以执行插入了
                if(i<freeTable.size()
                        &&((freeTable.get(i).getStart()+freeTable.get(i).getSize())==targetPartition.getStart())
                        &&(freeTable.get(i+1).getStart()==(targetPartition.getStart()+ targetPartition.getSize()))){
                    //上下邻区都要合并
                    //当前检索的是非最后一个元素
                    //上下都要合并
                    freeTable.get(i).setSize(freeTable.get(i).getSize()+targetPartition.getSize()+freeTable.get(i+1).getSize());
                    freeTable.remove(i+1);
                    isRecycle=true;
                    break;
                }
                if((freeTable.get(i).getStart()+freeTable.get(i).getSize())==targetPartition.getStart()){
                    //当前检索到的节点是回收节点的上邻空闲区
                    freeTable.get(i).setSize(freeTable.get(i).getSize()+targetPartition.getSize());
                    isRecycle=true;
                    break;
                }else if(freeTable.get(i).getStart()==(targetPartition.getStart()+ targetPartition.getSize())){
                    //当前检索到的节点是回收节点的下邻空闲区
                    freeTable.get(i).setStart(targetPartition.getStart());
                    freeTable.get(i).setSize(freeTable.get(i).getSize()+targetPartition.getSize());
                    isRecycle=true;
                    break;
                }
                if(targetPartition.getStart()<freeTable.get(i).getStart()){
                    //pos=i;
                    freeTable.add(i,targetPartition);
                    isRecycle=true;
                    break;
                }
//            }
        }
        if(isRecycle==false){
            freeTable.add(targetPartition);
            isRecycle=true;
        }

        System.out.println("回收合并完成！");
    }
}
