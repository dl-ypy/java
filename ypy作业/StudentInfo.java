import java.util.Scanner;
enum Sex{��,Ů}
public class StudentInfo{
public static void main(String args[]){
int age,number,n,k=0;String name;Sex x=Sex.��;float score[]=new float[5];
Scanner sc=new Scanner(System.in);
System.out.println("�����ͬѧ��������ѧ��,���䣬5�ſεĳɼ�:");
name=sc.nextLine();number=sc.nextInt();age=sc.nextInt();
for(int i=0;i<5;i++){score[i]=sc.nextFloat();}
System.out.println("ѧ��Ϊ"+number+"��"+age+"���"+x+"ͬѧ"+name+"��5�ſγɼ�����:");
for(int i=0;i<5;i++){System.out.println("��"+(i+1)+"�ŵĳɼ���"+score[i]+"�֡�");}
for(int j=1;j>0;j++){System.out.println("����1,2,3,4,1�Ǹ�ͬѧ����߷֣�2��ƽ���֣�3���ܷ֣�4���˳���");
n=sc.nextInt();
switch(n){
case 1:for(int i=0;i<5;i++){if(score[i]>score[k]){k=i;}};
       System.out.println("��ͬѧ����߷���"+score[k]);break;
case 2:System.out.println("��ͬѧ��ƽ������"+((score[0]+score[1]+score[2]+score[3]+score[4])/5));break;
case 3:System.out.println("��ͬѧ���ܷ���"+(score[0]+score[1]+score[2]+score[3]+score[4]));break;
case 4:break;
default:System.out.println("�������");}
if(n==4)break;
}
}
}