import java.util.Scanner;
public class Suan{
  public static void main(String arg[]){
  Jinjia jin=new Jinjia();
  jin.setJinjia();
  System.out.println("���ν����ܼ�Ϊ:"+jin.getJinjia());
  Shoujia shou=new Shoujia();
  shou.setShoujia();
  System.out.println("�����ۻ��ܼ�Ϊ:"+shou.getShoujia());
  Lirun li=new Lirun(jin,shou);
  System.out.println("����Ϊ:"+li.getLirun());
  Ss s=new Ss(jin,li);
  s.setLirun();
  s.speak("");
}
}
class Jinjia{
  float jin[]=new float[10];String shi[]=new String[10];float n=0;
  void setJinjia(){
  Scanner sc=new Scanner(System.in);
  System.out.println("����ʳ������:");
  for(int i=0;i<10;i++){shi[i]=sc.nextLine();}
  for(int i=0;i<10;i++){System.out.println("��"+(i+1)+"��ʳ����:"+shi[i]);}
  System.out.println("�����ʳ����ۣ��ܼ�,������������һһ��Ӧ��:");
  for(int i=0;i<10;i++){jin[i]=sc.nextFloat();}
  for(int i=0;i<10;i++){System.out.println(shi[i]+"�Ľ���Ϊ"+jin[i]+"Ԫ.");}
  }
  float getJinjia(){
  for(int i=0;i<10;i++){n=n+jin[i];}
  return n;}
  
}
class Shoujia{
  float shou[]=new float[10];int shu[]=new int[10];float m=0;
  void setShoujia(){
  Scanner sc=new Scanner(System.in);
  System.out.println("����ÿ��ʳ����ۼ�(����)������");
  for(int i=0;i<10;i++){shou[i]=sc.nextFloat();shu[i]=sc.nextInt();}
  for(int i=0;i<10;i++){System.out.println("��"+(i+1)+"��ʳ����ۼ���"+(shou[i]*shu[i])+"Ԫ");}
  }
  float getShoujia(){for(int i=0;i<10;i++){m=m+(shou[i]*shu[i]);}return m;}
}
class Lirun{
  Jinjia jin;Shoujia shou;
  Lirun(Jinjia jin,Shoujia shou){
  this.jin=jin;this.shou=shou;}
  float getLirun(){
  float a=shou.getShoujia();float b=jin.getJinjia();return 0.5f*(a-b);}
}
class Ss{
  Jinjia jin;Lirun li;
  Ss(Jinjia jin,Lirun li){
  this.jin=jin;this.li=li;}
  int p,q;
  void setLirun(){
  System.out.println("���������������214|613��:");
  Scanner sc=new Scanner(System.in);
  p=sc.nextInt();q=sc.nextInt();}
  void speak (String s){
  System.out.println("ƽ��ÿ������ı�ǮΪ"+(jin.getJinjia()/2));
  System.out.println("214,613���������ֱ�Ϊ:"+(li.getLirun()/10*p)+"��"+(li.getLirun()/10*q));
  System.out.println(s);}
  
}