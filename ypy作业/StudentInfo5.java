import java.util.*;
import java.io.*;
public class StudentInfo5
{  public static void main(String args[])
   {  
      Xuanze xuan=new Xuanze();
      int n;
      Scanner sc=new Scanner(System.in);
      System.out.println("����������������������ӭ�����б���ѧѧ���ɼ�����ϵͳ��������������������");
      boolean flag=true;
      while(flag){
      System.out.println("****************************************");
      System.out.println("   ����  1������γ���Ϣ�������� ����");
      System.out.println("   ����  2������༶��Ϣ�������� ����");
      System.out.println("   ����  3���˳�                 ����");
      System.out.println("****************************************");
      System.out.println("���������");
      n=sc.nextInt();
      switch(n){
      case 1:xuan.ke();break;
      case 2:xuan.ban();break;
      case 3:System.out.println("ִ�н�����");flag=false;break;
      default:System.out.println("���������������������룡");break;
      }
   }
  }
}
class Xuanze
{
   Kecheng ke=new Kecheng();Banji ban=new Banji();
   int n;
   public void ke()
   {
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      System.out.println("        ��  1������γ���Ϣ  ��");
      System.out.println("        ��  2������γ���Ϣ  ��");
      System.out.println("        ��  3������γ���Ϣ  ��");
      System.out.println("        ��  4����ȡ�γ���Ϣ  ��");
      System.out.println("        ��  5���˳�          ��");
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      System.out.println("���������");
      n=sc.nextInt();
      switch(n){
      case 1:ke.input();break;
      case 2:ke.output();break;
      case 3:ke.save();break;
      case 4:ke=Kecheng.load();ke.output();break;
      case 5:System.out.println("�γ���Ϣ����������");flag=false;break;
      default:System.out.println("���������������������룡����");break;
      }
    }
   }
   public void ban()
   {
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
      System.out.println("        ��  1������༶��Ϣ ��");
      System.out.println("        ��  2������༶��Ϣ ��");
      System.out.println("        ��  3������༶��Ϣ ��");
      System.out.println("        ��  4����ȡ�༶��Ϣ ��");
      System.out.println("        ��  5����ѯѧ���ɼ� ��");
      System.out.println("        ��  6����ѯ�γ̳ɼ� ��");
      System.out.println("        ��  7���˳�         ��");
      System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
      System.out.println("���������");
      n=sc.nextInt();
      switch(n){
      case 1:ban.input();break;
      case 2:ban.output();break;
      case 3:ban.save();break;
      case 4:ban=Banji.load();ban.output();break;
      case 5:ban.search();break;
      case 6:ban.searchkecheng();break;
      case 7:System.out.println("�༶��Ϣ����������");flag=false;break;
      default:System.out.println("���������������������룡");break;
      }
     }
    }
}

class Kecheng implements Serializable
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
               FileOutputStream f=new FileOutputStream("Kecheng"+term.toString()+".txt");
               ObjectOutputStream o=new ObjectOutputStream(f);
               o.writeObject(this);
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
    }
   public static Kecheng load()
   {   Kecheng ke=new Kecheng();
       Scanner sc=new Scanner(System.in);
       System.out.println("��Ҫ��ȡ�ڼ�ѧ�ڵĽ�ѧ�ƻ�?�����룺");    
       Integer term=sc.nextInt();
       try{
               FileInputStream f=new FileInputStream("Kecheng"+term.toString()+".txt");
               ObjectInputStream o=new ObjectInputStream(f);
               ke=(Kecheng)o.readObject();
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
        return ke;
    }
   
}

class Student implements Serializable
{  
   int age,number,i,k=0;String name;float score[];String sex;float n=0;
   Banji ban=new Banji();Kecheng ke=new Kecheng();
   
   public Student()
   {
      score=new float[ke.number];
   }
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      name=sc.nextLine();number=sc.nextInt();sex=sc.next();age=sc.nextInt();
      
   }
    public void output()
    {
       System.out.println("��ͬѧ������Ϊ:"+name);
       System.out.println("��ͬѧ��ѧ��Ϊ:"+number);
       System.out.println("��ͬѧ���Ա�Ϊ:"+sex);
       System.out.println("��ͬѧ������Ϊ:"+age);
     }
}
class Banji implements Serializable
{
   String ban;int ren;
   Kecheng ke;Student[] student;
   public Banji()
   {
      ke=new Kecheng(); 
   }
   public void input()
   {
      Scanner sc=new Scanner(System.in);
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
                     case 0:ke=Kecheng.load();break;
                     default:System.out.println("����������������������:");}
                 flag=false;break;}
           default:System.out.println("����������������������:");
           }
       }
       System.out.println("���������༶��Ϣ:");
       System.out.println("������༶������Լ��ð�����:");
       ban=sc.next();ren=sc.nextInt();
       student=new Student[ren];
       flag=true;
       while(flag)
       {
          System.out.println("�����������Ƿ���¼��ѧ����Ϣ(��/��(Y/N))?(�������ɼ�)");
          str=sc.next();
          switch(str)
          {
           case "Y":flag=false;break;
           case "N":{System.out.println("������ѧ����Ϣ������");
                    for(int i=0;i<ren;i++){student[i]=new Student();System.out.println("�������"+(i+1)+"λͬѧ�����֣�ѧ�ţ��Ա�,����:");student[i].input();}flag=false;break;}
           default:System.out.println("����������������������:");
          } 
       } 
       for(int i=0;i<ren;i++){
       student[i].score=new float[ke.number];
       for(int j=0;j<ke.number;j++){
          System.out.println("�������"+(i+1)+"λͬѧ�ĵ�"+(j+1)+"�ſγ�:"+ke.ke[j]+"�ĳɼ�:");
          student[i].score[j]=sc.nextFloat();
          }
        }
   }
   public void output()
   {
       System.out.println(ban+"��һ����"+ren+"��");
       for(int i=0;i<ren;i++){
       System.out.println("********************"+ban+"���"+(i+1)+"λͬѧ����Ϣ����********************");
       student[i].output();
       for(int j=0;j<ke.number;j++){
          System.out.println(ban+"���"+(i+1)+"λͬѧ"+student[i].name+"�ĵ�"+(j+1)+"�ſγ�"+ke.ke[j]+"�ĳɼ�Ϊ:"+student[i].score[j]);}
       }
    }
    public void search()
    {
       Banji ban=Banji.load();
       Scanner sc=new Scanner(System.in);
       int k=0;
       System.out.println("��������Ҫ��ѯ��ѧ��ѧ��:"); 
       int number=sc.nextInt();
       for(int i=0;i<ban.ren;i++)
       {
         
            if(student[i].number==number)   
             {
                    k=i;  break;
             }
        }    
        student[k].output();
        for(int j=0;j<ke.number;j++){System.out.println("��ͬѧ�ġ���"+ke.ke[j]+"�����ɼ�Ϊ:"+student[k].score[j]);}
        float x=0;for(int j=0;j<ke.number;j++){x=x+student[k].score[j];}
        System.out.println("��ͬѧ���ܷ�Ϊ"+x+"�֡�");
        System.out.println("��ͬѧ��ƽ����Ϊ"+(x/ke.number)+"�֡�");
        int z=0,p=0;
        for(int j=0;j<ke.number;j++)
        {
            if(student[k].score[j]>student[k].score[z])
            {
                z=j;
             }
         }
        System.out.println("��ͬѧ����߷��ǡ���"+ke.ke[z]+"�����ɼ�"+student[k].score[z]+"�֡�");
        for(int j=0;j<ke.number;j++)
        {
            if(student[k].score[j]<student[k].score[p])
            {
                p=j;
             }
         }
        System.out.println("��ͬѧ����ͷ��ǡ���"+ke.ke[p]+"�����ɼ�"+student[k].score[p]+"�֡�");
   }
   public void searchkecheng()
   {
       Banji ban=Banji.load();
       Scanner sc=new Scanner(System.in);
       String kename;int q=0;
       System.out.println("������Ҫ��ѯ�Ŀ�Ŀ����");
       kename=sc.next();
       for(int j=0;j<ke.number;j++)
       {
           if((ke.ke[j]).equals(kename))          //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           {q=j;break;}
        }
       float c=0;for(int i=0;i<ren;i++)
       {
           c=c+student[i].score[q];
        }
       System.out.println("�ð࡭��"+ke.ke[q]+"������ƽ����Ϊ"+(c/ren)+"�֡�");
       int n=0;
       for(int i=0;i<ren;i++)
       {
           if(student[i].score[q]>student[n].score[q])
           {n=i;}
        }
       System.out.println(ke.ke[q]+"�ɼ�����߷�Ϊ"+student[n].name+"ͬѧ��"+student[n].score[q]+"�֡�");
       int m=0;
       for(int i=0;i<ren;i++)
       {
           if(student[i].score[q]<student[n].score[q])
           {m=i;}
        }
        System.out.println(ke.ke[q]+"�ɼ�����ͷ�Ϊ"+student[m].name+"ͬѧ��"+student[m].score[q]+"�֡�"); 
       
    }
   public void save()
   {
       try{
               FileOutputStream f=new FileOutputStream("Banji.txt");
               ObjectOutputStream o=new ObjectOutputStream(f);
               o.writeObject(this);
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
    }
    public static Banji load()
    {   Banji ban=new Banji();
        try{
               FileInputStream f=new FileInputStream("Banji.txt");
               ObjectInputStream o=new ObjectInputStream(f);
               ban=(Banji)o.readObject();
               o.close();
               f.close();
            }
        catch(Exception e){e.printStackTrace();}
        return ban;
     }
}


