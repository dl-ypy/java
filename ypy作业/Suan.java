import java.util.Scanner;
public class Suan{
  public static void main(String arg[]){
  Jinjia jin=new Jinjia();
  jin.setJinjia();
  System.out.println("本次进货总价为:"+jin.getJinjia());
  Shoujia shou=new Shoujia();
  shou.setShoujia();
  System.out.println("本次售货总价为:"+shou.getShoujia());
  Lirun li=new Lirun(jin,shou);
  System.out.println("利润为:"+li.getLirun());
  Ss s=new Ss(jin,li);
  s.setLirun();
  s.speak("");
}
}
class Jinjia{
  float jin[]=new float[10];String shi[]=new String[10];float n=0;
  void setJinjia(){
  Scanner sc=new Scanner(System.in);
  System.out.println("输入食物种类:");
  for(int i=0;i<10;i++){shi[i]=sc.nextLine();}
  for(int i=0;i<10;i++){System.out.println("第"+(i+1)+"种食物是:"+shi[i]);}
  System.out.println("输入各食物进价（总价,并与上面种类一一对应）:");
  for(int i=0;i<10;i++){jin[i]=sc.nextFloat();}
  for(int i=0;i<10;i++){System.out.println(shi[i]+"的进价为"+jin[i]+"元.");}
  }
  float getJinjia(){
  for(int i=0;i<10;i++){n=n+jin[i];}
  return n;}
  
}
class Shoujia{
  float shou[]=new float[10];int shu[]=new int[10];float m=0;
  void setShoujia(){
  Scanner sc=new Scanner(System.in);
  System.out.println("输入每种食物的售价(单价)及数量");
  for(int i=0;i<10;i++){shou[i]=sc.nextFloat();shu[i]=sc.nextInt();}
  for(int i=0;i<10;i++){System.out.println("第"+(i+1)+"种食物的售价是"+(shou[i]*shu[i])+"元");}
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
  System.out.println("请输入利润比例（214|613）:");
  Scanner sc=new Scanner(System.in);
  p=sc.nextInt();q=sc.nextInt();}
  void speak (String s){
  System.out.println("平均每个宿舍的本钱为"+(jin.getJinjia()/2));
  System.out.println("214,613宿舍的利润分别为:"+(li.getLirun()/10*p)+"和"+(li.getLirun()/10*q));
  System.out.println(s);}
  
}