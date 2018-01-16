import java.util.*;
enum Sex{男,女}
public class 实验三
{  public static void main(String args[])
   {  
      Kecheng ke=new Kecheng();Banji ban=new Banji();Student stu=new Student();
      int n;
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("****************************************");
      System.out.println("          1、输入课程信息");
      System.out.println("          2、输入班级信息");
      System.out.println("          3. 输出课程信息");
      System.out.println("          4、输出班级信息");
      System.out.println("          5、平均分");
      System.out.println("          8、退出");
      System.out.println("****************************************");
      System.out.println("请输入序号");
      n=sc.nextInt();
      switch(n){
      case 1:ke.input();break;
      case 2:ban.input();break;
      case 3:ke.output();break;
      case 4:ban.output();break;
      case 5:ban.Average();break;
      case 8:System.out.println("执行结束！");flag=false;break;
      default:System.out.println("您的输入有误，请重新输入！");break;
      }
   }
  }
}
class Kecheng
{
   String ke[];int i,j,number,term;Scanner sc=new Scanner(System.in);
   
   public void input()
   {
      System.out.println("请输入您要设置第几学期的教学计划:");
      term=sc.nextInt();
      System.out.println("请输该学期有几门课:");
      number=sc.nextInt();ke=new String[number];
      System.out.println("请依次输入该班第"+term+"学期的课程:");
      System.out.println("第"+term+"学期的课程有:");
      for(i=0;i<number;i++){ke[i]=sc.next();}
      System.out.println("教学计划设置完毕，请进行后续步骤");
   }
   public void output()
   {
      for(i=0;i<number;i++){System.out.println("第"+term+"学期的第"+(i+1)+"门课是:"+ke[i]);}  
   }
   public Kecheng load()
   {
      Kecheng ke=new Kecheng();
      System.out.println("您要读取第几学期的教学计划?请输入：");    
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
      if(m==1){x=Sex.男;}
      if(m==2){x=Sex.女;}
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
          System.out.println("本环节中您是否已录入教学计划信息(是/否(Y/N))");
          str=sc.next();
          switch(str)
          {
           case "Y":flag=false;break;
           case "N":{
                     System.out.println("您要手动输入还是读取文件？(1/0)");
                     int a=sc.nextInt();
                     switch(a)
                     {
                     case 1:ke.input();break;
                     case 0:ke.load();break;
                     default:System.out.println("您的输入有误，请重新输入:");}
                 flag=false;break;}
           default:System.out.println("您的输入有误，请重新输入:");
           }
       }
       System.out.println("请继续输入班级信息:");
       System.out.println("请输入班级的序号以及该班人数:");
       ban=sc.next();ren=sc.nextInt();
       student=new Student[ren];
       for(int i=0;i<ren;i++){student[i]=new Student();
       System.out.println("请输入第"+(i+1)+"位同学的名字，学号，性别（1/2（男/女））,年龄:");
       student[i].input();
       student[i].score=new float[ke.number];
       for(int j=0;j<ke.number;j++){
          System.out.println("请输入第"+(i+1)+"位同学"+student[i].name+"的第"+(j+1)+"门课程"+ke.ke[j]+"的成绩:");
          student[i].score[j]=sc.nextFloat();
          }
        }
   }
   public void output()
   {
       System.out.println(ban+"班一共有"+ren+"人");
       for(int i=0;i<ren;i++){
       System.out.println("第"+(i+1)+"位同学"+student[i].name+"为"+student[i].x+"同学，年龄为"+student[i].age+"岁，学号为"+student[i].number);
       for(int j=0;j<ke.number;j++){
          System.out.println("第"+(i+1)+"位同学"+student[i].name+"的第"+(j+1)+"门课程"+ke.ke[j]+"的成绩为:"+student[i].score[j]);}
       }
    }
   public void Average()
   {
      
      for(int i=0;i<ren;i++){float x=0;for(int j=0;j<ke.number;j++){x=x+student[i].score[j];}
      System.out.println("第"+(i+1)+"位同学"+student[i].name+"的平均分为"+(x/ke.number)+"分。");}
    }
}
