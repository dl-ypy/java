import java.util.*; 
import java.io.*;
/*enum Sex{
  ��,Ů
}*/
public class Student implements Serializable
{
      
     char name[]=new char[8];
     char namenew[]=new char[8];
     int number;     
     int age;
     char sex;
     float score[];
     String namestr;
     public Student()
     {
       // score=new float[5];
        
     }
     
     public void input()
     { 
              
         Scanner sc=new Scanner(System.in);
         System.out.println("���� �Ա� ������");
         namestr=sc.next();
       
         for(int i=0;i<namestr.length();i++)
         {
            name[i]=namestr.charAt(i); 
            
         }     
        
         sex=sc.next().charAt(0);
        
         age=sc.nextInt();
         
       /*  for(int i=0;i<5;i++)
         {
              score[i]=sc.nextFloat();
             
          }*/         
     }
     public void save()
    {
      try{
        RandomAccessFile f=new RandomAccessFile("ne.txt","rw");
      
       
         f.writeUTF(namestr);
         
         for(int i=0;i<8;i++)
         {
            f.writeChar(name[i]);
         }         
         
         f.writeChar(sex);
       
         f.writeInt(age);
         for(int i=0;i<5;i++)
         {              
              f.writeFloat(score[i]);
          }
         f.close();
       }
        catch(Exception e){e.printStackTrace();}
    }

    public void read()
    {
       try{
        RandomAccessFile f=new RandomAccessFile("ne.txt","r");
      
         namestr=f.readUTF();
         System.out.println("��ѧ������������UTF��ʽ��ȡ����ǣ�"+namestr);
         System.out.println(f.getFilePointer());
         for(int i=0;i<8;i++)
         {
           namenew[i]=f.readChar();       
         } 
         namestr=new String(namenew,0,8); 
         System.out.println("��ѧ�������������ַ�������ʽ��ȡ������Arraysת������ǣ�"+Arrays.toString(namenew));      
         System.out.println("��ѧ�����������ַ�������ʽ���ת��Ϊ�ַ����ǣ�"+namestr);      
         System.out.println("��ѧ�����Ա��ǣ�"+f.readChar());
   
         System.out.println("��ѧ���������ǣ�"+f.readInt());
         for(int i=0;i<5;i++)
         {
               System.out.println("��ѧ����"+(i+1)+"�ſεĳɼ��ǣ�"+f.readFloat());
              
          }
        
         System.out.println(f.getFilePointer());
          f.close();
       }
        catch(Exception e){e.printStackTrace();}

   }  

   public static Student load()
    {
       Student stu=new Student();       
       try{
         RandomAccessFile f=new RandomAccessFile("ne.txt","r");
      
         stu.namestr=f.readUTF();          
         for(int i=0;i<8;i++)
         {
           stu.name[i]=f.readChar();     
         }           
         stu.sex=f.readChar();   
         stu.age=f.readInt();
         for(int i=0;i<5;i++)
         {
             stu.score[i]=f.readFloat();
              
          }        
         f.close();
       }
        catch(Exception e){e.printStackTrace();}
      return stu;

   }
   public void output()
    {
       
         System.out.println("��ѧ���������ǣ�"+Arrays.toString(name));      
         System.out.println("��ѧ���������ǣ�"+namestr);      
         System.out.println("��ѧ�����Ա��ǣ�"+sex);
   
         System.out.println("��ѧ���������ǣ�"+age);
         for(int i=0;i<score.length;i++)
         {
               System.out.println("��ѧ����"+(i+1)+"�ſεĳɼ��ǣ�"+score[i]);
              
          }       
      

   }  


}