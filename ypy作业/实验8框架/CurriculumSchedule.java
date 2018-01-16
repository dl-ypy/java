import java.util.Scanner;
import java.io.*;
public class CurriculumSchedule implements Serializable
{
    Integer term;
    int currinumber;
    String curriname[];
   
    /*public CurriculumSchedule()
    {
     
    }*/
    public void input()
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("您要录入第几学期的教学计划?请输入：");
       term=sc.nextInt();
       System.out.println("您要为该学期设置几门课?请输入：");
       currinumber=sc.nextInt();
       System.out.println("您要为该学期设置的课程名称分别是：");
       curriname=new String[currinumber];
       for(int i=0;i<currinumber;i++)
       {
          System.out.println("您要为该学期设置的第"+(i+1)+"门课程名称：");
          curriname[i]=sc.next();
       }
       System.out.println("您已经完成该学期教学计划的设置，请继续后续工作。");       
    }

   public void output()
   {
   	 System.out.println("第"+term+"学期的教学计划如下：");
   	 System.out.println("*********************************");
   	 for(int i=0;i<currinumber;i++)
       {          
          System.out.println("\t"+curriname[i]);         
          
       }
     System.out.println("*********************************");
   }
  public void save()
  {
  	try{
          FileOutputStream out=new FileOutputStream("curriculumschedule"+term.toString()+".txt");
          ObjectOutputStream ob=new ObjectOutputStream(out);          
          ob.writeObject(this);
          ob.close();
          out.close();
       }
      catch(Exception e){e.printStackTrace();}
  }
   public static CurriculumSchedule load()
   {
   	   CurriculumSchedule cursche=new CurriculumSchedule();
       System.out.println("您要读取第几学期的教学计划?请输入：");    
       Scanner sc=new Scanner(System.in);
       Integer term=sc.nextInt();
        try{
           
          FileInputStream in=new FileInputStream("curriculumschedule"+term.toString()+".txt");
          ObjectInputStream ob=new ObjectInputStream(in);
          cursche=(CurriculumSchedule)ob.readObject();
          ob.close();
          in.close();
       }
      catch(Exception e){e.printStackTrace();}  
      return cursche;     

   }


  
} 