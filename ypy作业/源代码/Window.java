import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Window
{
   JTextField 用户名;JPasswordField 密码;
   static JButton 登录;
   public Window()
   {
      init();
    }
   void init()
   {
      JFrame jm=new JFrame("用户登录界面");
      Container con=jm.getContentPane();
      con.setLayout(new GridLayout(3,3));
      JLabel userName=new JLabel("用户名");
      con.add(userName);
      用户名=new JTextField();
      con.add(用户名);
      JLabel mima=new JLabel("密码");
      con.add(mima);
      密码=new JPasswordField();
      con.add(密码);
      登录=new JButton("登录");
      con.add(登录);
      登录.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0)
         {
            String 用户名0=用户名.getText();
            String 密码0=密码.getText();
            菜单 cd;
            if(用户名0.equals("杨佩钰"))
               if(密码0.equals("12345678900"))
                  cd=new 菜单();
               else
                  JOptionPane.showMessageDialog(Window.登录,"密码不正确","提示对话框",JOptionPane.WARNING_MESSAGE);
            else
               JOptionPane.showMessageDialog(Window.登录,"用户名不正确","提示对话框",JOptionPane.WARNING_MESSAGE);    
          }
         });
         jm.setBounds(300,200,300,200);
         jm.setVisible(true);
         jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}