package view;

import pojo.Job;
import pojo.Partition;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.LinkedList;

public class RootUI extends JFrame {
    private LinkedList<Job> jobQueue = new LinkedList<>();//作业请求队列
    private int MemorySum = -1;//总内存
    private LinkedList<Partition> freeTable = new LinkedList<>();//空闲表
    private LinkedList<Partition> occupyTable = new LinkedList<>();//已分配表

    //空闲表显示时无需显示pid
    //分配表显示时需要显示pid
    public RootUI(){


        super("动态分区管理");
        init();

    }

    private void init(){//界面初始化写在这里


        URL resource = RootUI.class.getClassLoader().getResource("m_pm.png");
        Image image = new ImageIcon(resource).getImage();
//        jFrame.setIconImage(image);
        setIconImage(image);

        setSize(600,400);
        //居中（方式1)
//        jFrame.setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        //关闭退出程序
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);//设置不可改变大小
//        jFrame.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//设置不可改变大小
        setVisible(true);

    }


}
