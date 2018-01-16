interface 收费{
   public void 收取费用();
}
interface 调节温度{
   public void controlTemperature();
}
class 公共汽车 implements 收费{
   public void 收取费用(){
      System.out.println("公共汽车:1元/张，不计算公里数");
    }
}
class 出租车 implements 收费,调节温度{
   public void 收取费用(){
      System.out.println("出租车:3.20元/公里，起价3公里");
    }
   public void controlTemperature(){
      System.out.println("安装了Hair空调");
    }
}
public class Example5_15{
   public static void main(String args[]){
       公共汽车 七路=new 公共汽车();//不能为“7”路。
       出租车 天宇=new 出租车();
       七路.收取费用();
       天宇.收取费用();
       天宇.controlTemperature();
    }
}