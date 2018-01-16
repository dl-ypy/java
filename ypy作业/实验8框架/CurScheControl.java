import java.util.Scanner;
import java.io.*;
public class CurScheControl implements Serializable
{
    public static void main (String args[]){
         CurriculumSchedule cursche=new CurriculumSchedule();
         int choose;
         Scanner sc=new Scanner(System.in);
         boolean flag=true;
         while(flag){
             System.out.println("*********************************************");
             
            System.out.println("          1、输入教学计划");
            System.out.println("          2、输出教学计划");
            System.out.println("          3、保存教学计划");
            System.out.println("          4、查询某学期的教学计划");
            System.out.println("          5、退出");

            System.out.println("*********************************************");
            choose=sc.nextInt();
            switch(choose)
            { 
               
               case 1: cursche.input();break;
               case 2: cursche.output();break; 
               case 3: cursche.save();break;  
               case 4: cursche=CurriculumSchedule.load();cursche.output();break; 
               case 5: System.out.println("程序执行结束！");flag=false;break; 
               default: System.out.println("您输入的选择不正确，请重新输入！"); 

            }
              
         } 
         

    }
}