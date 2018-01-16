import java.awt.*;  //导入制作图形用户界面所用到的包
import javax.swing.*;    
import java.awt.event.*;
public class MainFrame extends JFrame
{
   public MainFrame()
   {
    init();    
   }
  public void init()
  {
    JFrame jf=new JFrame("简易学生成绩管理系统");	  //创建一个窗口
    jf.setLayout(new FlowLayout());
    JMenuBar menubar=new JMenuBar();  //创建一一个菜单栏
    JMenu scheduleMenu=new JMenu("教学计划管理");  //创建一个主菜单
    JMenu scoreMenu=new JMenu("学生成绩管理");
    menubar.add(scheduleMenu);  //将每一个菜单添加到菜单栏中
    menubar.add(scoreMenu);
    JMenu scheduleMI1=new JMenu("录入");  //创建一个子菜单
    JMenuItem scheduleMI2=new JMenuItem("查询",new ImageIcon("a.jpg"));  
    JMenuItem scheduleMI3=new JMenuItem("删除");
    scheduleMenu.add(scheduleMI1);
    scheduleMenu.add(scheduleMI2);
    scheduleMenu.add(scheduleMI3);
    JMenuItem scheduleM1=new JMenuItem("录入一个");  //子菜单中的目录
    JMenuItem scheduleM2=new JMenuItem("录入多个");
    scheduleMI1.add(scheduleM1);
    scheduleMI1.add(scheduleM2);
    JMenu scoreMI1=new JMenu("录入单个学生信息");
    JMenuItem scoreMI2=new JMenuItem("输入并保存班级基本信息");
    JMenuItem scoreMI3=new JMenuItem("输出班级基本信息");
    JMenuItem scoreMI4=new JMenuItem("查看某个班级所有学生的成绩（有排名）");
    JMenuItem scoreMI5=new JMenuItem("查询班中某同学的成绩");
    JMenuItem scoreMI6=new JMenuItem("读取某班同学的成绩");
    scoreMenu.add(scoreMI1);
    scoreMenu.add(scoreMI2);
    scoreMenu.add(scoreMI3);
    scoreMenu.add(scoreMI4);
    scoreMenu.add(scoreMI5);
    scoreMenu.add(scoreMI6);
    JMenuItem scoreM1=new JMenuItem("录入一个");
    JMenuItem scoreM2=new JMenuItem("录入多个");
    scoreMI1.add(scoreM1);
    scoreMI1.add(scoreM2);
    scheduleM1.addActionListener(new ScheduleInputListner());  //使用自定义的事件监听类完成事件处理  
    scheduleMI2.addActionListener(new ActionListener(){   //在事件监听处理中 使用匿名类来作为这里的对象参数     
        public void actionPerformed(ActionEvent arg0) 
       {
         CurriculumSchedule cursche=CurriculumSchedule.load();
         cursche.output(); 
       }
     });
    scoreMI2.addActionListener(new ActionListener(){   //在事件监听处理中 使用匿名类来作为这里的对象参数     
        public void actionPerformed(ActionEvent arg0) 
       {
         ClassMana classmana=new ClassMana(); 
         classmana.input(); 
         classmana.save();
       }
     });
    scoreMI3.addActionListener(new ActionListener(){   //在事件监听处理中 使用匿名类来作为这里的对象参数     
        public void actionPerformed(ActionEvent arg0) 
       {
         ClassMana classmana=ClassMana.load(); 
         classmana.output();          
       }
     });
    jf.setJMenuBar(menubar);
    jf.setBounds(350,150,500,400);  //设置窗口在屏幕上（左，上，长，宽）的大小
    jf.setVisible(true);   //设置窗口是否可见
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
}
