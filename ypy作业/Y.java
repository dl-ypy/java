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
      System.out.println("��������Ҫ���õڼ�ѧ�ڵĽ�ѧ�ƻ�:");
      term=sc.nextInt();
      System.out.println("�����ѧ���м��ſ�:");
      number=sc.nextInt();ke=new String[number];
      System.out.println("����������ð��"+term+"ѧ�ڵĿγ�:");
      System.out.println("��"+term+"ѧ�ڵĿγ���:");
      for(int i=0;i<number;i++){ke[i]=sc.next();}
      System.out.println("��ѧ�ƻ�������ϣ�����к�������");
   }
    public void output()
   {
      for(int i=0;i<number;i++){System.out.println("��"+term+"ѧ�ڵĵ�"+(i+1)+"�ſ���:"+ke[i]);}  
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