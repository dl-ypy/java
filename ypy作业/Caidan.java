import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.*;
public class Caidan
{
   public static void main(String args[])
   {
       Window w=new Window("ѧ���ɼ�����ϵͳ",100,200,500,300);
    }
}
class Window extends JFrame{
   JMenuBar menubar;JMenu menu1,menu2,subMenu;
   JMenuItem item1,item2,item3,item4,item5,item6;
   public Window(){}
   public Window(String s,int x,int y,int w,int h){
      init(s);
      setBounds(x,y,w,h);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
   void init(String s){
      setTitle(s);
      menubar=new JMenuBar();
      menu1=new JMenu("��ѧ�ƻ���������");
      subMenu=new JMenu("��ѯѧ���ɼ�");
      item1=new JMenuItem("�����ѧ�ƻ���Ϣ",new ImageIcon("a.gif"));
      item2=new JMenuItem("�����ѧ�ƻ���Ϣ",new ImageIcon("b.gif"));
      item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
      item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_MASK));
      menu1.add(item1);
      menu1.addSeparator();
      menu1.add(item2);
      menu2=new JMenu("�༶��Ϣ��������");
      item3=new JMenuItem("����༶��Ϣ",new ImageIcon("c.gif"));
      item4=new JMenuItem("����༶��Ϣ",new ImageIcon("d.gif"));
      item5=new JMenuItem("��ƽ����",new ImageIcon("f.gif"));
      item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
      item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
      item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
      menu2.add(item3);
      menu2.addSeparator();
      menu2.add(item4);
      menu2.addSeparator();
      menu2.add(item5);
      menu2.addSeparator();
      menu2.add(subMenu);
      subMenu.add(new JMenuItem("��ѧ�Ų�ѯ",new ImageIcon("e.gif")));
      subMenu.addSeparator();
      subMenu.add(new JMenuItem("��������ѯ",new ImageIcon("g.gif")));
      menubar.add(menu1);
      menubar.add(menu2);
      setJMenuBar(menubar);
   }
}