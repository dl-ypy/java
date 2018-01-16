interface Advertisement{
   public void showAdvertisement();
   public String getCorpName();
}
class AdvertisementBoard{
   public void show(Advertisement adver){
      System.out.println("广告牌显示"+adver.getCorpName()+"公司的广告词");
      adver.showAdvertisement();
   }
}
class LenovoCorp implements Advertisement{
   public void showAdvertisement(){
      System.out.println("**********************");
      System.out.println("    让世界变得很小    ");
      System.out.println("**********************");
    }
   public String getCorpName(){
      return "联想集团";
    }
}
public class Example5_17{
   public static void main(String args[]){
      AdvertisementBoard board=new AdvertisementBoard();
      board.show(new LenovoCorp());
    }
}
