import java.util.*;
enum Sex{��,Ů}
public class ʵ����
{  public static void main(String args[])
   {  
      Kecheng ke=new Kecheng();Banji ban=new Banji();Student stu=new Student();
      int n;
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("****************************************");
      System.out.println("          1������γ���Ϣ");
      System.out.println("          2������༶��Ϣ");
      System.out.println("          3. ����γ���Ϣ");
      System.out.println("          4������༶��Ϣ");
      System.out.println("          5��ƽ����");
      System.out.println("          8���˳�");
      System.out.println("****************************************");
      System.out.println("���������");
      n=sc.nextInt();
      switch(n){
      case 1:ke.input();break;
      case 2:ban.input();break;
      case 3:ke.output();break;
      case 4:ban.output();break;
      case 5:ban.Average();break;
      case 8:System.out.println("ִ�н�����");flag=false;break;
      default:System.out.println("���������������������룡");break;
      }
   }
  }
}
class Kecheng
{
   String ke[];int i,j,number,term;Scanner sc=new Scanner(System.in);
   
   public void input()
   {
      System.out.println("��������Ҫ���õڼ�ѧ�ڵĽ�ѧ�ƻ�:");
      term=sc.nextInt();
      System.out.println("�����ѧ���м��ſ�:");
      number=sc.nextInt();ke=new String[number];
      System.out.println("����������ð��"+term+"ѧ�ڵĿγ�:");
      System.out.println("��"+term+"ѧ�ڵĿγ���:");
      for(i=0;i<number;i++){ke[i]=sc.next();}
      System.out.println("��ѧ�ƻ�������ϣ�����к�������");
   }
   public void output()
   {
      for(i=0;i<number;i++){System.out.println("��"+term+"ѧ�ڵĵ�"+(i+1)+"�ſ���:"+ke[i]);}  
   }
   public Kecheng load()
   {
      Kecheng ke=new Kecheng();
      System.out.println("��Ҫ��ȡ�ڼ�ѧ�ڵĽ�ѧ�ƻ�?�����룺");    
      Scanner sc=new Scanner(System.in);
      term=sc.nextInt();
       
       return ke;
    }
}
class Student
{  
   int age,number,m,i,k=0;String name;float score[];Sex x;float n=0;
   Banji ban=new Banji();Kecheng ke=new Kecheng();
   Scanner sc=new Scanner(System.in);
   public Student()
   {
      score=new float[ke.number];
   }
   public void input()
   {
      name=sc.nextLine();number=sc.nextInt();m=sc.nextInt();age=sc.nextInt();
      if(m==1){x=Sex.��;}
      if(m==2){x=Sex.Ů;}
   }
}
class Banji{
   String ban;int ren,j;
   Scanner sc=new Scanner(System.in);
   Kecheng ke;Student[] student;
   public Banji()
   {
      ke=new Kecheng(); 
   }
   public void input()
   {
      String str;
      boolean flag=true;
      while(flag)
      {
          System.out.println("�����������Ƿ���¼���ѧ�ƻ���Ϣ(��/��(Y/N))");
          str=sc.next();
          switch(str)
          {
           case "Y":flag=false;break;
           case "N":{
                     System.out.println("��Ҫ�ֶ����뻹�Ƕ�ȡ�ļ���(1/0)");
                     int a=sc.nextInt();
                     switch(a)
                     {
                     case 1:ke.input();break;
                     case 0:ke.load();break;
                     default:System.out.println("����������������������:");}
                 flag=false;break;}
           default:System.out.println("����������������������:");
           }
       }
       System.out.println("���������༶��Ϣ:");
       System.out.println("������༶������Լ��ð�����:");
       ban=sc.next();ren=sc.nextInt();
       student=new Student[ren];
       for(int i=0;i<ren;i++){student[i]=new Student();
       System.out.println("�������"+(i+1)+"λͬѧ�����֣�ѧ�ţ��Ա�1/2����/Ů����,����:");
       student[i].input();
       student[i].score=new float[ke.number];
       for(int j=0;j<ke.number;j++){
          System.out.println("�������"+(i+1)+"λͬѧ"+student[i].name+"�ĵ�"+(j+1)+"�ſγ�"+ke.ke[j]+"�ĳɼ�:");
          student[i].score[j]=sc.nextFloat();
          }
        }
   }
   public void output()
   {
       System.out.println(ban+"��һ����"+ren+"��");
       for(int i=0;i<ren;i++){
       System.out.println("��"+(i+1)+"λͬѧ"+student[i].name+"Ϊ"+student[i].x+"ͬѧ������Ϊ"+student[i].age+"�꣬ѧ��Ϊ"+student[i].number);
       for(int j=0;j<ke.number;j++){
          System.out.println("��"+(i+1)+"λͬѧ"+student[i].name+"�ĵ�"+(j+1)+"�ſγ�"+ke.ke[j]+"�ĳɼ�Ϊ:"+student[i].score[j]);}
       }
    }
   public void Average()
   {
      
      for(int i=0;i<ren;i++){float x=0;for(int j=0;j<ke.number;j++){x=x+student[i].score[j];}
      System.out.println("��"+(i+1)+"λͬѧ"+student[i].name+"��ƽ����Ϊ"+(x/ke.number)+"�֡�");}
    }
}
