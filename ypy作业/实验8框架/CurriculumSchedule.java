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
       System.out.println("��Ҫ¼��ڼ�ѧ�ڵĽ�ѧ�ƻ�?�����룺");
       term=sc.nextInt();
       System.out.println("��ҪΪ��ѧ�����ü��ſ�?�����룺");
       currinumber=sc.nextInt();
       System.out.println("��ҪΪ��ѧ�����õĿγ����Ʒֱ��ǣ�");
       curriname=new String[currinumber];
       for(int i=0;i<currinumber;i++)
       {
          System.out.println("��ҪΪ��ѧ�����õĵ�"+(i+1)+"�ſγ����ƣ�");
          curriname[i]=sc.next();
       }
       System.out.println("���Ѿ���ɸ�ѧ�ڽ�ѧ�ƻ������ã����������������");       
    }

   public void output()
   {
   	 System.out.println("��"+term+"ѧ�ڵĽ�ѧ�ƻ����£�");
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
       System.out.println("��Ҫ��ȡ�ڼ�ѧ�ڵĽ�ѧ�ƻ�?�����룺");    
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