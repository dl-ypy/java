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
             
            System.out.println("          1������༶������Ϣ");
            System.out.println("          2������༶������Ϣ");
            System.out.println("          3����ѯ����ĳͬѧ�ĳɼ�");
            System.out.println("          4����������༶������Ϣ");
            System.out.println("          5����ȡĳ��ͬѧ�ĳɼ�");
            System.out.println("          6���˳�");

            System.out.println("*********************************************");
            choose=sc.nextInt();
            switch(choose)
            { 
               
               case 1: classmana.input();break;
               case 2: classmana.output();break; 
               case 3: classmana.search();break; 
               case 4: classmana.save();break; 
               case 5: classmana=ClassMana.load();classmana.output();break; 
               case 6: System.out.println("����ִ�н�����");flag=false;break; 
               default: System.out.println("�������ѡ����ȷ�����������룡"); 

            }
              
         } 
         

    }
}