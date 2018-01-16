interface Mianji{
   public String getTuxing();
   public float getTiji();  
}
class Tuxingku{
   public void show(Mianji tu){
      System.out.println(tu.getTuxing()+"�������"+tu.getTiji());
    }
}
class Yuanzhu implements Mianji{
   float r=1.1f;
   float h=5.2f;
   public String getTuxing(){
      return "Բ��";
    }
   public float getTiji(){
      return r*r*3.14f*h;
    }
}
class Yuanzhui implements Mianji{
   float r=1.1f;
   float h=5.2f;
   public String getTuxing(){
      return "Բ׶";
    }
   public float getTiji(){
      return 1/3f*r*r*3.14f*h;
    }
}
class Changfangti implements Mianji{
   float a=1.1f;
   float b=5.2f;
   float c=0.1f;
   public String getTuxing(){
      return "������";
    }
   public float getTiji(){
      return a*b*c;
    }
}
public class Tiji{
   public static void main(String args[]){
      Tuxingku ku=new Tuxingku();
      ku.show(new Yuanzhu());
      ku.show(new Yuanzhui());
      ku.show(new Changfangti());
    }
}
   