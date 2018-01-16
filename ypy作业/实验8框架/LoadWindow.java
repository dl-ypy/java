import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoadWindow {
    JTextField userName;   //定义属性
    JPasswordField password;
    static JButton login;
    JButton register;
    public LoadWindow()
    {
        init();  
        
    }
    public void init()   
   {
     JFrame jf=new JFrame("登陆窗体");  //创建一个主窗体
     Container continer=jf.getContentPane();  //添加到容器中
     continer.setLayout(new GridLayout(3,2,3,8));  //设置网格式管理布局器
     JLabel userName0=new JLabel("用户名");
     continer.add(userName0);  //将标签添加到容器中
     userName=new JTextField();
     continer.add(userName);
     JLabel passWord0=new JLabel("密码");
     continer.add(passWord0);
     password=new JPasswordField();
     continer.add(password);
     register=new JButton("注册");
     continer.add(register);
     login=new JButton("登录");
     continer.add(login);
     login.addActionListener(new ActionListener(){   //在事件监听处理中 使用匿名类来作为这里的对象参数       
        
        public void actionPerformed(ActionEvent arg0) 
       {
         String username=userName.getText();
         String password2=password.getText();
         MainFrame mf;           	
          if (username.equals("xhl"))
             if ( password2.equals("123") )
                 mf=new MainFrame();
                else
                JOptionPane.showMessageDialog(LoadWindow.login, "密码不正确", "提示对话框", JOptionPane.WARNING_MESSAGE);
          else
                JOptionPane.showMessageDialog(LoadWindow.login, "用户名不正确", "提示对话框", JOptionPane.WARNING_MESSAGE);
       }
     });
     jf.setBounds(460,200,288,208);
     jf.setVisible(true);   
     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
   }
}

