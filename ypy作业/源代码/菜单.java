import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.*;
public class �˵� extends JFrame
{
   public �˵�()
   {
      init();
    }
   public void init()
   {
      JFrame jiemian=new JFrame("NBA�ٿ�");
      jiemian.setLayout(new FlowLayout());
      JMenuBar menubar=new JMenuBar();
      JMenu lishi=new JMenu("NBA��ʷ");
      JMenu guize=new JMenu("NBA����");
      JMenu renwu=new JMenu("NBA����־");
      JMenu paiming=new JMenu("NBA��������");
      menubar.add(guize);
      menubar.add(lishi);
      menubar.add(renwu);
      menubar.add(paiming);
      JMenuItem guize0=new JMenuItem("NBA����");
      guize.add(guize0);
      JMenuItem lishi1=new JMenuItem("NBA��չʷ");
      JMenuItem lishi2=new JMenuItem("NBA�����ܹھ����������ཱ��");
      JMenuItem lishi3=new JMenuItem("NBA����ӵ�ǰ������");
      JMenuItem lishi4=new JMenuItem("NBA��������");
      JMenuItem lishi5=new JMenuItem("NBA50�����");
      JMenuItem lishi6=new JMenuItem("NBA��ʷ��");
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
      JMenuItem renwu1=new JMenuItem("60�����ǰ");
      JMenuItem renwu2=new JMenuItem("60-70���");
      JMenuItem renwu3=new JMenuItem("70-80���");
      JMenuItem renwu4=new JMenuItem("80-90���");
      JMenuItem renwu5=new JMenuItem("90���");
      JMenuItem renwu6=new JMenuItem("������");
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
      JMenuItem paiming1=new JMenuItem("��ʷ��λǰʮ");
      JMenuItem paiming2=new JMenuItem("ʮ��������");
      JMenuItem paiming3=new JMenuItem("ʮ��÷ֺ���");
      JMenuItem paiming4=new JMenuItem("ʮ��Сǰ��");
      JMenuItem paiming5=new JMenuItem("ʮ���ǰ��");
      JMenuItem paiming6=new JMenuItem("ʮ���з�");
      JMenuItem paiming7=new JMenuItem("�÷ְ�ǰʮ");
      JMenuItem paiming8=new JMenuItem("������ǰʮ");
      JMenuItem paiming9=new JMenuItem("���ϰ�ǰʮ");
      JMenuItem paiming10=new JMenuItem("�����ǰʮ");
      JMenuItem paiming11=new JMenuItem("��ñ��ǰʮ");
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
             ���� gui=new ����();
             gui.search();
          }
      });
      lishi1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0)
         {
             ��ʷ li=new ��ʷ();
             li.��չ();
          }
      });
      jiemian.setJMenuBar(menubar);
      jiemian.setBounds(200,300,500,300);
      jiemian.setVisible(true);
      jiemian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }  
}