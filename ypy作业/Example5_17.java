interface Advertisement{
   public void showAdvertisement();
   public String getCorpName();
}
class AdvertisementBoard{
   public void show(Advertisement adver){
      System.out.println("�������ʾ"+adver.getCorpName()+"��˾�Ĺ���");
      adver.showAdvertisement();
   }
}
class LenovoCorp implements Advertisement{
   public void showAdvertisement(){
      System.out.println("**********************");
      System.out.println("    �������ú�С    ");
      System.out.println("**********************");
    }
   public String getCorpName(){
      return "���뼯��";
    }
}
public class Example5_17{
   public static void main(String args[]){
      AdvertisementBoard board=new AdvertisementBoard();
      board.show(new LenovoCorp());
    }
}
