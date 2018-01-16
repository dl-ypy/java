import java.util.*; 
import java.io.*;
/*enum Sex{
  男,女
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
         System.out.println("姓名 性别 、年龄");
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
         System.out.println("该学生的姓名按照UTF形式存取输出是："+namestr);
         System.out.println(f.getFilePointer());
         for(int i=0;i<8;i++)
         {
           namenew[i]=f.readChar();       
         } 
         namestr=new String(namenew,0,8); 
         System.out.println("该学生的姓名按照字符数组形式存取，并用Arrays转换输出是："+Arrays.toString(namenew));      
         System.out.println("该学生的姓名将字符数组形式输出转换为字符串是："+namestr);      
         System.out.println("该学生的性别是："+f.readChar());
   
         System.out.println("该学生的年龄是："+f.readInt());
         for(int i=0;i<5;i++)
         {
               System.out.println("该学生第"+(i+1)+"门课的成绩是："+f.readFloat());
              
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
       
         System.out.println("该学生的姓名是："+Arrays.toString(name));      
         System.out.println("该学生的姓名是："+namestr);      
         System.out.println("该学生的性别是："+sex);
   
         System.out.println("该学生的年龄是："+age);
         for(int i=0;i<score.length;i++)
         {
               System.out.println("该学生第"+(i+1)+"门课的成绩是："+score[i]);
              
          }       
      

   }  


}