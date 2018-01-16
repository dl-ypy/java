import java.util.Scanner;
public class 实验四
{  
   public static void main(String args[])
   {  
      Ball ball=new Ball();
      Cuboid cuboid=new Cuboid();
      Bottle bottle=new Bottle(ball,cuboid);
      bottle.setVolume1();
      System.out.println("该球的体积是:"+bottle.getVolume1());
      bottle.setVolume2();
      System.out.println("该长方体的体积是:"+bottle.getVolume2());
    }
}	
class Ball
{  float radius;
   void setVolume()
   {  Scanner sc=new Scanner(System.in);
      System.out.println("请输入球的半径:");
      radius=sc.nextFloat();
    }
   float getVolume()
   {return (4/3)*3.14f*radius*radius*radius;}
}
class Cuboid
{
   float width,height,length;
   void setVolume()
   {  Scanner sc=new Scanner(System.in);
      System.out.println("请输入长方体的长，宽，高:");
      length=sc.nextFloat();width=sc.nextFloat();height=sc.nextFloat();
    }
   float getVolume()
   {return width*height*length;}
}
class Bottle
{
   Ball ball;
   Cuboid cuboid;
   Bottle(Ball ball,Cuboid cuboid)
   {
      this.ball=ball;this.cuboid=cuboid;
   }
   void setVolume1()
   {ball.setVolume();}
   float getVolume1()
   {return ball.getVolume();}
   void setVolume2()
   {cuboid.setVolume();}
   float getVolume2()
   {return cuboid.getVolume();}
}
