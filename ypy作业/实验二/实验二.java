import java.util.Scanner;
enum Sex{��,Ů}
public class ʵ���
{  public static void main(String args[])
   {  Student stu=new Student();
      int n;
      Scanner sc=new Scanner(System.in);
      boolean flag=true;
      while(flag){
      System.out.println("****************************************");
      System.out.println("          1������ѧ��������Ϣ");
      System.out.println("          2�����ѧ��������Ϣ");
      System.out.println("          3�����ѧ����ƽ���ɼ�");
      System.out.println("          4�����ͬѧ����߳ɼ�");
      System.out.println("          5�����ͬѧ���ܳɼ�");
      System.out.println("          6���˳�");
      System.out.println("****************************************");
      System.out.println("���������");
      n=sc.nextInt();
      switch(n){
      case 1:stu.input();break;
      case 2:stu.output();break;
      case 3:stu.getAverage();break;
      case 4:stu.getZuigao();break;
      case 5:stu.getZong();break;
      case 6:System.out.println("ִ�н�����");flag=false;break;
      default:System.out.println("���������������������룡");break;
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
    System.out.println("�����ͬѧ������,ѧ��,�Ա�(����1��2�ֱ�����к�Ů),����,5�ſεĳɼ�:");
    name=sc.nextLine();number=sc.nextInt();m=sc.nextInt();age=sc.nextInt();
    for(int i=0;i<5;i++){score[i]=sc.nextFloat();}
   }
   public void output()
   {
    if(m==1){x=Sex.��;}
    if(m==2){x=Sex.Ů;}
    System.out.println("ѧ��Ϊ"+number+"��"+age+"���"+x+"ͬѧ"+name+"��5�ſγɼ�����:");
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