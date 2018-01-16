import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
public class 实验七
{  public static void main(String args[])
   {  
      Window w=new Window();
      System.out.println("??????????欢迎进入中北大学学生成绩管理系统??????????");
  }
}
class Window
{
   JTextField userName;
JPasswordField mima;
JLabel userName0, mima0;
static JButton denglu,zhuce;
   public Window()
   {
       init();
    }
   void init()
   {
       JFrame jm=new JFrame("登陆界面");
       Container con=jm.getContentPane();
       con.setLayout(new GridLayout(3,3,3,3));
       userName0=new JLabel("用户名");
       con.add(userName0);
       userName=new JTextField();
       con.add(userName);
       mima0=new JLabel("密码");
       con.add(mima0);
       mima=new JPasswordField();
       con.add(mima);
       zhuce=new JButton("注册");
       con.add(zhuce);
       denglu=new JButton("登录");
       con.add(denglu);
       denglu.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0) 
         {
           String username=userName.getText();
           String mima1=mima.getText(); 
           Jiemian j;
           if(username.equals("ypy"))
              if(mima1.equals("214")) 
                j=new Jiemian();
              else
                JOptionPane.showMessageDialog(Window.denglu, "密码不正确", "提示对话框", JOptionPane.WARNING_MESSAGE);          	   
           else 
             JOptionPane.showMessageDialog(Window.zhuce, "用户名不正确", "提示对话框", JOptionPane.WARNING_MESSAGE);
          }
         });
       jm.setBounds(100,200,500,300);
       jm.setVisible(true);
       jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Jiemian extends JFrame
{
   public Jiemian()
   {
       init();
    }
    public void init()
    {
        JFrame j=new JFrame("学生成绩管理系统");
        j.setLayout(new FlowLayout());
        JMenuBar menubar=new JMenuBar();
        JMenu jxjh=new JMenu("教学计划管理");
        JMenu bjxx=new JMenu("班级信息管理");
        menubar.add(jxjh);
        menubar.add(bjxx);
        JMenuItem jxjh1=new JMenuItem("输入课程信息");
        JMenuItem jxjh2=new JMenuItem("查询课程信息");
        jxjh.add(jxjh1);
        jxjh.addSeparator();
        jxjh.add(jxjh2);
        JMenuItem bjxx1=new JMenuItem("输入班级信息");
        JMenuItem bjxx2=new JMenuItem("查询班级信息");
        JMenuItem bjxx3=new JMenuItem("查询学生成绩");
        JMenuItem bjxx4=new JMenuItem("查询课程成绩");
        bjxx.add(bjxx1);
        bjxx.addSeparator();
        bjxx.add(bjxx2);
        bjxx.addSeparator();
        bjxx.add(bjxx3);
        bjxx.addSeparator();
        bjxx.add(bjxx4);
        j.setJMenuBar(menubar);
        j.setBounds(200,300,500,300);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
