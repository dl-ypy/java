import java.util.Scanner;
import java.io.*;
public class ClassManaControl implements Serializable
{
    public static void main (String args[]){
         ClassMana classmana=new ClassMana();  ;
         int choose;
         Scanner sc=new Scanner(System.in);
         boolean flag=true;
         while(flag){
             System.out.println("*********************************************");
             
            System.out.println("          1、输入班级基本信息");
            System.out.println("          2、输出班级基本信息");
            System.out.println("          3、查询班中某同学的成绩");
            System.out.println("          4、保存输出班级基本信息");
            System.out.println("          5、读取某班同学的成绩");
            System.out.println("          6、退出");

            System.out.println("*********************************************");
            choose=sc.nextInt();
            switch(choose)
            { 
               
               case 1: classmana.input();break;
               case 2: classmana.output();break; 
               case 3: classmana.search();break; 
               case 4: classmana.save();break; 
               case 5: classmana=ClassMana.load();classmana.output();break; 
               case 6: System.out.println("程序执行结束！");flag=false;break; 
               default: System.out.println("您输入的选择不正确，请重新输入！"); 

            }
              
         } 
         

    }
}