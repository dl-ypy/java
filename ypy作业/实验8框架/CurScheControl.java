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
             
            System.out.println("          1�������ѧ�ƻ�");
            System.out.println("          2�������ѧ�ƻ�");
            System.out.println("          3�������ѧ�ƻ�");
            System.out.println("          4����ѯĳѧ�ڵĽ�ѧ�ƻ�");
            System.out.println("          5���˳�");

            System.out.println("*********************************************");
            choose=sc.nextInt();
            switch(choose)
            { 
               
               case 1: cursche.input();break;
               case 2: cursche.output();break; 
               case 3: cursche.save();break;  
               case 4: cursche=CurriculumSchedule.load();cursche.output();break; 
               case 5: System.out.println("����ִ�н�����");flag=false;break; 
               default: System.out.println("�������ѡ����ȷ�����������룡"); 

            }
              
         } 
         

    }
}