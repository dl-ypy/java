interface ShowMessage{
   void 显示商标(String s);
}
class TV implements ShowMessage{
   public void 显示商标(String s){
      System.out.println(s);
    }
}
public class Example5_16{
   public static void main(String args[]){
      ShowMessage sm;
      sm=new TV();
      sm.显示商标("长城牌电视机");
    }
}