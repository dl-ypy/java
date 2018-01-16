import java.util.Scanner;
enum Sex{男,女}
public class StudentInfo{
public static void main(String args[]){
int age,number,n,k=0;String name;Sex x=Sex.男;float score[]=new float[5];
Scanner sc=new Scanner(System.in);
System.out.println("输入该同学的姓名，学号,年龄，5门课的成绩:");
name=sc.nextLine();number=sc.nextInt();age=sc.nextInt();
for(int i=0;i<5;i++){score[i]=sc.nextFloat();}
System.out.println("学号为"+number+"的"+age+"岁的"+x+"同学"+name+"的5门课成绩如下:");
for(int i=0;i<5;i++){System.out.println("第"+(i+1)+"门的成绩是"+score[i]+"分。");}
for(int j=1;j>0;j++){System.out.println("输入1,2,3,4,1是该同学的最高分，2是平均分，3是总分，4是退出。");
n=sc.nextInt();
switch(n){
case 1:for(int i=0;i<5;i++){if(score[i]>score[k]){k=i;}};
       System.out.println("该同学的最高分是"+score[k]);break;
case 2:System.out.println("该同学的平均分是"+((score[0]+score[1]+score[2]+score[3]+score[4])/5));break;
case 3:System.out.println("该同学的总分是"+(score[0]+score[1]+score[2]+score[3]+score[4]));break;
case 4:break;
default:System.out.println("输入错误。");}
if(n==4)break;
}
}
}