import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
public class ʵ����
{  public static void main(String args[])
   {  
      Window w=new Window();
      System.out.println("??????????��ӭ�����б���ѧѧ���ɼ�����ϵͳ??????????");
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
       JFrame jm=new JFrame("��½����");
       Container con=jm.getContentPane();
       con.setLayout(new GridLayout(3,3,3,3));
       userName0=new JLabel("�û���");
       con.add(userName0);
       userName=new JTextField();
       con.add(userName);
       mima0=new JLabel("����");
       con.add(mima0);
       mima=new JPasswordField();
       con.add(mima);
       zhuce=new JButton("ע��");
       con.add(zhuce);
       denglu=new JButton("��¼");
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
                JOptionPane.showMessageDialog(Window.denglu, "���벻��ȷ", "��ʾ�Ի���", JOptionPane.WARNING_MESSAGE);          	   
           else 
             JOptionPane.showMessageDialog(Window.zhuce, "�û�������ȷ", "��ʾ�Ի���", JOptionPane.WARNING_MESSAGE);
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
        JFrame j=new JFrame("ѧ���ɼ�����ϵͳ");
        j.setLayout(new FlowLayout());
        JMenuBar menubar=new JMenuBar();
        JMenu jxjh=new JMenu("��ѧ�ƻ�����");
        JMenu bjxx=new JMenu("�༶��Ϣ����");
        menubar.add(jxjh);
        menubar.add(bjxx);
        JMenuItem jxjh1=new JMenuItem("����γ���Ϣ");
        JMenuItem jxjh2=new JMenuItem("��ѯ�γ���Ϣ");
        jxjh.add(jxjh1);
        jxjh.addSeparator();
        jxjh.add(jxjh2);
        JMenuItem bjxx1=new JMenuItem("����༶��Ϣ");
        JMenuItem bjxx2=new JMenuItem("��ѯ�༶��Ϣ");
        JMenuItem bjxx3=new JMenuItem("��ѯѧ���ɼ�");
        JMenuItem bjxx4=new JMenuItem("��ѯ�γ̳ɼ�");
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
