import java.util.Scanner;
import java.io.*;
public class Y
{
    public static void main(String args[]){
    A a=new A();
    //a.input();
    //a.save();
    a=A.load();
    a.output();
    }
}
class A implements Serializable
{  
    String ke[];int number;Integer term;
   
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("请输入您要设置第几学期的教学计划:");
      term=sc.nextInt();
      System.out.println("请输该学期有几门课:");
      number=sc.nextInt();ke=new String[number];
      System.out.println("请依次输入该班第"+term+"学期的课程:");
      System.out.println("第"+term+"学期的课程有:");
      for(int i=0;i<number;i++){ke[i]=sc.next();}
      System.out.println("教学计划设置完毕，请进行后续步骤");
   }
    public void output()
   {
      for(int i=0;i<number;i++){System.out.println("第"+term+"学期的第"+(i+1)+"门课是:"+ke[i]);}  
   } 
    public void save()
    {
       try{
              FileOutputStream f=new FileOutputStream("abc.txt");
              ObjectOutputStream o=new ObjectOutputStream(f);
              o.writeObject(this);
              o.close();
              f.close();
           }
        catch(Exception e){e.printStackTrace();}
     }
     public static A load()
     {
         A a=new A();
         try{
              FileInputStream f=new FileInputStream("abc.txt");
              ObjectInputStream o=new ObjectInputStream(f);
              a=(A)o.readObject();
              o.close();
              f.close();
           }
        catch(Exception e){e.printStackTrace();}
        return a;
      }
      
}