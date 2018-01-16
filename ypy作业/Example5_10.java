class 动物{
   void cry(){
   }
}
class 狗 extends 动物{
   void cry(){
      System.out.println("这是狗的叫声：汪汪···汪汪");
    }
}
public class Example5_10{
   public static void main(String args[]){
      动物 animal=new 狗();//animal是狗的上转型对象
      animal.cry();
    }
}