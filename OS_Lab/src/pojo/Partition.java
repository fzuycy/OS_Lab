package pojo;

public class Partition implements Comparable<Partition>{//分区

    private int pid;//该分区当前是属于哪个作业的
    private int size;
    private int start;
    public Partition(){

    }

    public Partition(int pid, int size, int start) {
        this.pid = pid;
        this.size = size;
        this.start = start;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "pid=" + pid +
                ", size=" + size +
                ", start=" + start +
                '}';
    }

    @Override
    public int compareTo(Partition partition) {
        if(this.size<partition.getSize()){
            return 1;
        }else if(this.size>partition.getSize()){
            return -1;
        }else{
            return 0;
        }

    }
}
