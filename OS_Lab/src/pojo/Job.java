package pojo;

public class Job {
    private  int pid;
    private int size;
    public Job(){

    }

    public Job(int pid, int size) {
        this.pid = pid;
        this.size = size;
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

    @Override
    public String toString() {
        return "Job{" +
                "pid=" + pid +
                ", size=" + size +
                '}';
    }
}
