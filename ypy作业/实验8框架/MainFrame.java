import java.awt.*;  //��������ͼ���û��������õ��İ�
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
    JFrame jf=new JFrame("����ѧ���ɼ�����ϵͳ");	  //����һ������
    jf.setLayout(new FlowLayout());
    JMenuBar menubar=new JMenuBar();  //����һһ���˵���
    JMenu scheduleMenu=new JMenu("��ѧ�ƻ�����");  //����һ�����˵�
    JMenu scoreMenu=new JMenu("ѧ���ɼ�����");
    menubar.add(scheduleMenu);  //��ÿһ���˵���ӵ��˵�����
    menubar.add(scoreMenu);
    JMenu scheduleMI1=new JMenu("¼��");  //����һ���Ӳ˵�
    JMenuItem scheduleMI2=new JMenuItem("��ѯ",new ImageIcon("a.jpg"));  
    JMenuItem scheduleMI3=new JMenuItem("ɾ��");
    scheduleMenu.add(scheduleMI1);
    scheduleMenu.add(scheduleMI2);
    scheduleMenu.add(scheduleMI3);
    JMenuItem scheduleM1=new JMenuItem("¼��һ��");  //�Ӳ˵��е�Ŀ¼
    JMenuItem scheduleM2=new JMenuItem("¼����");
    scheduleMI1.add(scheduleM1);
    scheduleMI1.add(scheduleM2);
    JMenu scoreMI1=new JMenu("¼�뵥��ѧ����Ϣ");
    JMenuItem scoreMI2=new JMenuItem("���벢����༶������Ϣ");
    JMenuItem scoreMI3=new JMenuItem("����༶������Ϣ");
    JMenuItem scoreMI4=new JMenuItem("�鿴ĳ���༶����ѧ���ĳɼ�����������");
    JMenuItem scoreMI5=new JMenuItem("��ѯ����ĳͬѧ�ĳɼ�");
    JMenuItem scoreMI6=new JMenuItem("��ȡĳ��ͬѧ�ĳɼ�");
    scoreMenu.add(scoreMI1);
    scoreMenu.add(scoreMI2);
    scoreMenu.add(scoreMI3);
    scoreMenu.add(scoreMI4);
    scoreMenu.add(scoreMI5);
    scoreMenu.add(scoreMI6);
    JMenuItem scoreM1=new JMenuItem("¼��һ��");
    JMenuItem scoreM2=new JMenuItem("¼����");
    scoreMI1.add(scoreM1);
    scoreMI1.add(scoreM2);
    scheduleM1.addActionListener(new ScheduleInputListner());  //ʹ���Զ�����¼�����������¼�����  
    scheduleMI2.addActionListener(new ActionListener(){   //���¼����������� ʹ������������Ϊ����Ķ������     
        public void actionPerformed(ActionEvent arg0) 
       {
         CurriculumSchedule cursche=CurriculumSchedule.load();
         cursche.output(); 
       }
     });
    scoreMI2.addActionListener(new ActionListener(){   //���¼����������� ʹ������������Ϊ����Ķ������     
        public void actionPerformed(ActionEvent arg0) 
       {
         ClassMana classmana=new ClassMana(); 
         classmana.input(); 
         classmana.save();
       }
     });
    scoreMI3.addActionListener(new ActionListener(){   //���¼����������� ʹ������������Ϊ����Ķ������     
        public void actionPerformed(ActionEvent arg0) 
       {
         ClassMana classmana=ClassMana.load(); 
         classmana.output();          
       }
     });
    jf.setJMenuBar(menubar);
    jf.setBounds(350,150,500,400);  //���ô�������Ļ�ϣ����ϣ��������Ĵ�С
    jf.setVisible(true);   //���ô����Ƿ�ɼ�
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
}
