import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Window
{
   JTextField �û���;JPasswordField ����;
   static JButton ��¼;
   public Window()
   {
      init();
    }
   void init()
   {
      JFrame jm=new JFrame("�û���¼����");
      Container con=jm.getContentPane();
      con.setLayout(new GridLayout(3,3));
      JLabel userName=new JLabel("�û���");
      con.add(userName);
      �û���=new JTextField();
      con.add(�û���);
      JLabel mima=new JLabel("����");
      con.add(mima);
      ����=new JPasswordField();
      con.add(����);
      ��¼=new JButton("��¼");
      con.add(��¼);
      ��¼.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0)
         {
            String �û���0=�û���.getText();
            String ����0=����.getText();
            �˵� cd;
            if(�û���0.equals("������"))
               if(����0.equals("12345678900"))
                  cd=new �˵�();
               else
                  JOptionPane.showMessageDialog(Window.��¼,"���벻��ȷ","��ʾ�Ի���",JOptionPane.WARNING_MESSAGE);
            else
               JOptionPane.showMessageDialog(Window.��¼,"�û�������ȷ","��ʾ�Ի���",JOptionPane.WARNING_MESSAGE);    
          }
         });
         jm.setBounds(300,200,300,200);
         jm.setVisible(true);
         jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}