interface ShowMessage{
   void ��ʾ�̱�(String s);
}
class TV implements ShowMessage{
   public void ��ʾ�̱�(String s){
      System.out.println(s);
    }
}
public class Example5_16{
   public static void main(String args[]){
      ShowMessage sm;
      sm=new TV();
      sm.��ʾ�̱�("�����Ƶ��ӻ�");
    }
}