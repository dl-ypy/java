import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoadWindow {
    JTextField userName;   //��������
    JPasswordField password;
    static JButton login;
    JButton register;
    public LoadWindow()
    {
        init();  
        
    }
    public void init()   
   {
     JFrame jf=new JFrame("��½����");  //����һ��������
     Container continer=jf.getContentPane();  //��ӵ�������
     continer.setLayout(new GridLayout(3,2,3,8));  //��������ʽ��������
     JLabel userName0=new JLabel("�û���");
     continer.add(userName0);  //����ǩ��ӵ�������
     userName=new JTextField();
     continer.add(userName);
     JLabel passWord0=new JLabel("����");
     continer.add(passWord0);
     password=new JPasswordField();
     continer.add(password);
     register=new JButton("ע��");
     continer.add(register);
     login=new JButton("��¼");
     continer.add(login);
     login.addActionListener(new ActionListener(){   //���¼����������� ʹ������������Ϊ����Ķ������       
        
        public void actionPerformed(ActionEvent arg0) 
       {
         String username=userName.getText();
         String password2=password.getText();
         MainFrame mf;           	
          if (username.equals("xhl"))
             if ( password2.equals("123") )
                 mf=new MainFrame();
                else
                JOptionPane.showMessageDialog(LoadWindow.login, "���벻��ȷ", "��ʾ�Ի���", JOptionPane.WARNING_MESSAGE);
          else
                JOptionPane.showMessageDialog(LoadWindow.login, "�û�������ȷ", "��ʾ�Ի���", JOptionPane.WARNING_MESSAGE);
       }
     });
     jf.setBounds(460,200,288,208);
     jf.setVisible(true);   
     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
   }
}

