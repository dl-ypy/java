import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
public class 菜单 extends JFrame
{
   public 菜单()
   {
      init();
    }
   public void init()
   {
      JFrame jiemian=new JFrame("NBA百科");
      jiemian.setLayout(new FlowLayout());
      JMenuBar menubar=new JMenuBar();
      JMenu lishi=new JMenu("NBA历史");
      JMenu guize=new JMenu("NBA规则");
      JMenu renwu=new JMenu("NBA人物志");
      JMenu paiming=new JMenu("NBA各类排名");
      menubar.add(guize);
      menubar.add(lishi);
      menubar.add(renwu);
      menubar.add(paiming);
      JMenuItem guize0=new JMenuItem("NBA规则");
      guize.add(guize0);
      JMenuItem lishi1=new JMenuItem("NBA发展史");
      JMenuItem lishi2=new JMenuItem("NBA历年总冠军及其他各类奖项");
      JMenuItem lishi3=new JMenuItem("NBA各球队的前世今身");
      JMenuItem lishi4=new JMenuItem("NBA三大王朝");
      JMenuItem lishi5=new JMenuItem("NBA50大巨星");
      JMenuItem lishi6=new JMenuItem("NBA历史神迹");
      lishi.add(lishi1);
      lishi.addSeparator();
      lishi.add(lishi2);
      lishi.addSeparator();
      lishi.add(lishi3);
      lishi.addSeparator();
      lishi.add(lishi4);
      lishi.addSeparator();
      lishi.add(lishi5);
      lishi.addSeparator();
      lishi.add(lishi6);
      JMenuItem renwu1=new JMenuItem("60年代以前");
      JMenuItem renwu2=new JMenuItem("60-70年代");
      JMenuItem renwu3=new JMenuItem("70-80年代");
      JMenuItem renwu4=new JMenuItem("80-90年代");
      JMenuItem renwu5=new JMenuItem("90年代");
      JMenuItem renwu6=new JMenuItem("新世纪");
      renwu.add(renwu1);
      renwu.addSeparator();
      renwu.add(renwu2);
      renwu.addSeparator();
      renwu.add(renwu3);
      renwu.addSeparator();
      renwu.add(renwu4);
      renwu.addSeparator();
      renwu.add(renwu5);
      renwu.addSeparator();
      renwu.add(renwu6);
      JMenuItem paiming1=new JMenuItem("历史地位前十");
      JMenuItem paiming2=new JMenuItem("十大控球后卫");
      JMenuItem paiming3=new JMenuItem("十大得分后卫");
      JMenuItem paiming4=new JMenuItem("十大小前锋");
      JMenuItem paiming5=new JMenuItem("十大大前锋");
      JMenuItem paiming6=new JMenuItem("十大中锋");
      JMenuItem paiming7=new JMenuItem("得分榜前十");
      JMenuItem paiming8=new JMenuItem("助攻榜前十");
      JMenuItem paiming9=new JMenuItem("抢断榜前十");
      JMenuItem paiming10=new JMenuItem("篮板榜前十");
      JMenuItem paiming11=new JMenuItem("盖帽榜前十");
      paiming.add(paiming1);
      paiming.addSeparator();
      paiming.add(paiming2);
      paiming.addSeparator();
      paiming.add(paiming3);
      paiming.addSeparator();
      paiming.add(paiming4);
      paiming.addSeparator();
      paiming.add(paiming5);
      paiming.addSeparator();
      paiming.add(paiming6);
      paiming.addSeparator();
      paiming.add(paiming7);
      paiming.addSeparator();
      paiming.add(paiming8);
      paiming.addSeparator();
      paiming.add(paiming9);
      paiming.addSeparator();
      paiming.add(paiming10);
      paiming.addSeparator();
      paiming.add(paiming11);
      guize0.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0)
         {
             规则 gui=new 规则();
             gui.search();
          }
      });
      lishi1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0)
         {
             历史 li=new 历史();
             li.发展();
          }
      });
      jiemian.setJMenuBar(menubar);
      jiemian.setBounds(200,300,500,300);
      jiemian.setVisible(true);
      jiemian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }  
}