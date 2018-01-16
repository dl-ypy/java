import java.util.*;
import java.io.*;
public class StudentInfo21
{  public static void main(String args[])
   {  
      Student stu=new Student();
      //Student stu2;
      //stu.input();
      //stu.save();
      stu=Student.load();
      stu.output();
      System.out.println(""+stu.number);
     
  }
}
class Student
{  int age,number,n,m,k=0;String name;float score[];String sex;
   Scanner sc=new Scanner(System.in);
   public Student()
   {
   score=new float[5]; 
   }
   public void input()
   {
    System.out.println("�����ͬѧ������,ѧ��,�Ա�,����,5�ſεĳɼ�:");
    name=sc.nextLine();number=sc.nextInt();sex=sc.next();age=sc.nextInt();
    for(int i=0;i<5;i++){score[i]=sc.nextFloat();}
   }
   public void save()
   {
      
      try{
            RandomAccessFile rd=new RandomAccessFile("Student.txt","rw");
            rd.writeUTF(name); 
            rd.writeInt(number);
            rd.writeUTF(sex);
            rd.writeInt(age);
            for(int i=0;i<5;i++)
            {rd.writeFloat(score[i]);}
            rd.close(); 
          }
      catch(IOException e){}
    }
   public static Student load()
   {
      Student stu=new Student();
      try{
            
            RandomAccessFile rd=new RandomAccessFile("Student.txt","r");
            stu.name=rd.readUTF(); 
            stu.number=rd.readInt();
            stu.sex=rd.readUTF();
            stu.age=rd.readInt();
            for(int i=0;i<5;i++)
            {stu.score[i]=rd.readFloat();}
            rd.close(); 
          }
      catch(IOException e){}
      return stu;
    } 
   public void output()
   {
    
    System.out.println("ѧ��Ϊ"+number+"��"+age+"���"+sex+"ͬѧ"+name+"��5�ſγɼ�����:");
    for(int i=0;i<5;i++){System.out.println("��"+(i+1)+"�ŵĳɼ���"+score[i]+"�֡�");}
   }
   public void getAverage()
   {
    System.out.println("��ͬѧ��ƽ������"+((score[0]+score[1]+score[2]+score[3]+score[4])/5));
   }
   public void getZuigao()
   {
    for(int i=0;i<5;i++){if(score[i]>score[k]){k=i;}};
    System.out.println("��ͬѧ����߷���"+score[k]);
   }
   public void getZong()
   {
    System.out.println("��ͬѧ���ܷ���"+(score[0]+score[1]+score[2]+score[3]+score[4]));
   }
}