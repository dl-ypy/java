import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
public class StudentInfo6
{  public static void main(String args[])
   {  
      Window w=new Window();
      System.out.println("··········欢迎进入中北大学学生成绩管理系统··········");
  }
}
class Window
{
   JTextField userName;JPasswordField mima;static JButton denglu,zhuce;
   public Window()
   {
       init();
    }
   void init()
   {
       JFrame jm=new JFrame("登陆界面");
       Container con=jm.getContentPane();
       con.setLayout(new GridLayout(3,3,3,3));
       JLabel userName0=new JLabel("用户名");
       con.add(userName0);
       userName=new JTextField();
       con.add(userName);
       JLabel mima0=new JLabel("密码");
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
        jxjh1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           { 
               Kecheng ke=new Kecheng();  
               ke.input();
               ke.save();
            }
        });
        jxjh2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           {  
              Kecheng ke=Kecheng.load();ke.output();
            }
        }); 
        bjxx1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           {
               Banji ban=new Banji();
               ban.input();ban.save();
            }
         });
        bjxx2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           {
               Banji ban=Banji.load();ban.output();
            }
         });
        bjxx3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           {
               Banji ban=Banji.load();
               ban.search();
            }
         });
        bjxx4.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0)
           {
               Banji ban=Banji.load();
               ban.searchkecheng();
            }
         });
        j.setJMenuBar(menubar);
        j.setBounds(200,300,500,300);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
class Kecheng implements Serializable
{
   String ke[];int number;Integer term;
   
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("请输入您要设置第几学期的教学计划:");
      term=sc.nextInt();
      System.out.println("请输该学期有几门课:");
      number=sc.nextInt();ke=new String[number];
      System.out.println("请依次输入该班第"+term+"学期的课程:");
      System.out.println("第"+term+"学期的课程有:");
      for(int i=0;i<number;i++){ke[i]=sc.next();}
      System.out.println("教学计划设置完毕，请进行后续步骤");
   }
    public void output()
   {
      for(int i=0;i<number;i++){System.out.println("第"+term+"学期的第"+(i+1)+"门课是:"+ke[i]);}  
   } 
    public void save()
   {
        try{
               FileOutputStream f=new FileOutputStream("Kecheng"+term.toString()+".txt");
               ObjectOutputStream o=new ObjectOutputStream(f);
               o.writeObject(this);
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
    }
   public static Kecheng load()
   {   Kecheng ke=new Kecheng();
       Scanner sc=new Scanner(System.in);
       System.out.println("您要读取第几学期的教学计划?请输入：");    
       Integer term=sc.nextInt();
       try{
               FileInputStream f=new FileInputStream("Kecheng"+term.toString()+".txt");
               ObjectInputStream o=new ObjectInputStream(f);
               ke=(Kecheng)o.readObject();
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
        return ke;
    }
   
}

class Student implements Serializable
{  
   int age,number,i,k=0;String name;float score[];String sex;float n=0;
   Banji ban=new Banji();Kecheng ke=new Kecheng();
   
   public Student()
   {
      score=new float[ke.number];
   }
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      name=sc.nextLine();number=sc.nextInt();sex=sc.next();age=sc.nextInt();
      
   }
    public void output()
    {
       System.out.println("该同学的姓名为:"+name);
       System.out.println("该同学的学号为:"+number);
       System.out.println("该同学的性别为:"+sex);
       System.out.println("该同学的年龄为:"+age);
     }
}
class Banji implements Serializable
{
   String ban;int ren;
   Kecheng ke;Student[] student;
   public Banji()
   {
      ke=new Kecheng(); 
   }
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      String str;
      boolean flag=true;
      while(flag)
      {
          System.out.println("本环节中您是否已录入教学计划信息(是/否(Y/N))");
          str=sc.next();
          switch(str)
          {
           case "Y":flag=false;break;
           case "N":{
                     System.out.println("您要手动输入还是读取文件？(1/0)");
                     int a=sc.nextInt();
                     switch(a)
                     {
                     case 1:ke.input();break;
                     case 0:ke=Kecheng.load();break;
                     default:System.out.println("您的输入有误，请重新输入:");}
                 flag=false;break;}
           default:System.out.println("您的输入有误，请重新输入:");
           }
       }
       System.out.println("请继续输入班级信息:");
       System.out.println("请输入班级的序号以及该班人数:");
       ban=sc.next();ren=sc.nextInt();
       student=new Student[ren];
       flag=true;
       while(flag)
       {
          System.out.println("本环节中您是否已录入学生信息(是/否(Y/N))?(不包括成绩)");
          str=sc.next();
          switch(str)
          {
           case "Y":flag=false;break;
           case "N":{System.out.println("请输入学生信息！！！");
                    for(int i=0;i<ren;i++){student[i]=new Student();System.out.println("请输入第"+(i+1)+"位同学的名字，学号，性别,年龄:");student[i].input();}flag=false;break;}
           default:System.out.println("您的输入有误，请重新输入:");
          } 
       } 
       for(int i=0;i<ren;i++){
       student[i].score=new float[ke.number];
       for(int j=0;j<ke.number;j++){
          System.out.println("请输入第"+(i+1)+"位同学的第"+(j+1)+"门课程:"+ke.ke[j]+"的成绩:");
          student[i].score[j]=sc.nextFloat();
          }
        }
       System.out.println("班级信息设置完毕，请进行后续步骤");
   }
   public void output()
   {
       System.out.println("………………………………………………………………………………………………………");
       System.out.println(ban+"班一共有"+ren+"人");
       for(int i=0;i<ren;i++){
       System.out.println("********************"+ban+"班第"+(i+1)+"位同学的信息如下********************");
       student[i].output();
       for(int j=0;j<ke.number;j++){
          System.out.println(ban+"班第"+(i+1)+"位同学"+student[i].name+"的第"+(j+1)+"门课程"+ke.ke[j]+"的成绩为:"+student[i].score[j]);}
       }
       System.out.println("………………………………………………………………………………………………………");
    }
    public void search()
    {
       Banji ban=Banji.load();
       Scanner sc=new Scanner(System.in);
       int k=0;
       System.out.println("………………………………………………………………………………………………………");
       System.out.println("请输入您要查询的学生学号:"); 
       int number=sc.nextInt();
       for(int i=0;i<ban.ren;i++)
       {
         
            if(student[i].number==number)   
             {
                    k=i;  break;
             }
        }    
        student[k].output();
        for(int j=0;j<ke.number;j++){System.out.println("该同学的……"+ke.ke[j]+"……成绩为:"+student[k].score[j]);}
        float x=0;for(int j=0;j<ke.number;j++){x=x+student[k].score[j];}
        System.out.println("该同学的总分为"+x+"分。");
        System.out.println("该同学的平均分为"+(x/ke.number)+"分。");
        int z=0,p=0;
        for(int j=0;j<ke.number;j++)
        {
            if(student[k].score[j]>student[k].score[z])
            {
                z=j;
             }
         }
        System.out.println("该同学的最高分是……"+ke.ke[z]+"……成绩"+student[k].score[z]+"分。");
        for(int j=0;j<ke.number;j++)
        {
            if(student[k].score[j]<student[k].score[p])
            {
                p=j;
             }
         }
        System.out.println("该同学的最底分是……"+ke.ke[p]+"……成绩"+student[k].score[p]+"分。");
        System.out.println("………………………………………………………………………………………………………");
   }
   public void searchkecheng()
   {
       Banji ban=Banji.load();
       Scanner sc=new Scanner(System.in);
       String kename;int q=0;
       System.out.println("………………………………………………………………………………………………………");
       System.out.println("输入您要查询的科目名称");
       kename=sc.next();
       for(int j=0;j<ke.number;j++)
       {
           if((ke.ke[j]).equals(kename))          //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           {q=j;break;}
        }
       float c=0;for(int i=0;i<ren;i++)
       {
           c=c+student[i].score[q];
        }
       System.out.println("该班……"+ke.ke[q]+"……的平均分为"+(c/ren)+"分。");
       int n=0;
       for(int i=0;i<ren;i++)
       {
           if(student[i].score[q]>student[n].score[q])
           {n=i;}
        }
       System.out.println(ke.ke[q]+"成绩的最高分为"+student[n].name+"同学的"+student[n].score[q]+"分。");
       int m=0;
       for(int i=0;i<ren;i++)
       {
           if(student[i].score[q]<student[n].score[q])
           {m=i;}
        }
        System.out.println(ke.ke[q]+"成绩的最底分为"+student[m].name+"同学的"+student[m].score[q]+"分。");
        System.out.println("………………………………………………………………………………………………………"); 
       
    }
   public void save()
   {
       try{
               FileOutputStream f=new FileOutputStream("Banji.txt");
               ObjectOutputStream o=new ObjectOutputStream(f);
               o.writeObject(this);
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
    }
    public static Banji load()
    {   Banji ban=new Banji();
        try{
               FileInputStream f=new FileInputStream("Banji.txt");
               ObjectInputStream o=new ObjectInputStream(f);
               ban=(Banji)o.readObject();
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
        return ban;
     }
}


