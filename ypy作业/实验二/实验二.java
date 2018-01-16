import java.util.Scanner;
enum Sex{男,女}
public class 实验二
{  public static void main(String args[])
   {  Student stu=new Student();
      int n;
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("****************************************");
      System.out.println("          1、输入学生基本信息");
      System.out.println("          2、输出学生基本信息");
      System.out.println("          3、求该学生的平均成绩");
      System.out.println("          4、求该同学的最高成绩");
      System.out.println("          5、求该同学的总成绩");
      System.out.println("          6、退出");
      System.out.println("****************************************");
      System.out.println("请输入序号");
      n=sc.nextInt();
      switch(n){
      case 1:stu.input();break;
      case 2:stu.output();break;
      case 3:stu.getAverage();break;
      case 4:stu.getZuigao();break;
      case 5:stu.getZong();break;
      case 6:System.out.println("执行结束！");flag=false;break;
      default:System.out.println("您的输入有误，请重新输入！");break;
      }
   }
  }
}
class Student
{  int age,number,n,m,k=0;String name;float score[];Sex x;
   Scanner sc=new Scanner(System.in);
   public Student()
   {
   score=new float[5]; 
   }
   public void input()
   {
    System.out.println("输入该同学的姓名,学号,性别(输入1或2分别代表男和女),年龄,5门课的成绩:");
    name=sc.nextLine();number=sc.nextInt();m=sc.nextInt();age=sc.nextInt();
    for(int i=0;i<5;i++){score[i]=sc.nextFloat();}
   }
   public void output()
   {
    if(m==1){x=Sex.男;}
    if(m==2){x=Sex.女;}
    System.out.println("学号为"+number+"的"+age+"岁的"+x+"同学"+name+"的5门课成绩如下:");
    for(int i=0;i<5;i++){System.out.println("第"+(i+1)+"门的成绩是"+score[i]+"分。");}
   }
   public void getAverage()
   {
    System.out.println("该同学的平均分是"+((score[0]+score[1]+score[2]+score[3]+score[4])/5));
   }
   public void getZuigao()
   {
    for(int i=0;i<5;i++){if(score[i]>score[k]){k=i;}};
    System.out.println("该同学的最高分是"+score[k]);
   }
   public void getZong()
   {
    System.out.println("该同学的总分是"+(score[0]+score[1]+score[2]+score[3]+score[4]));
   }
}