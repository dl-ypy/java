/*
    时间：2015年12月26日14:41:07
    目的：继承的应用。
	  进行类的扩展，如何选择用合成（在类中创建另一个类的对象）还是继承？
	  “包含”关系就用合成，“属于”关系就用继承，继承很少用，只有必须用“上溯造型”时才用继承。
	  为什么多用组合，少用继承？
	  第一、子类对父类的继承是全部的公有和受保护的继承，这使得子类可能继承了对子类无用甚至有害的父类的方法。换句话说，子类只希望继承父类的一部分方法，怎么办？ 
	  第二、实际的对象千变万化，如果每一类的对象都有他们自己的类，尽管这些类都继承了他们的父类，但有些时候还是会造成类的无限膨胀。 
	  第三、 继承的子类，实际上需要编译期确定下来，这满足不了需要在运行内才能确定对象的情况。而组合却可以比继承灵活得多，可以在运行期才决定某个对象。 
*/
class Human
{
	  public String name = "张三";
	  public int age = 21;
}

class Student extends Human
{
	  public double score = 66.6;
}

class Graduate extends Student
{
	  public String daoshi = "小三";
}

public class Jicheng_1
{
	  public static void main(String[] args)
	  {
	  	  Graduate gd = new Graduate();
	  	  System.out.printf("%s %f\n", gd.name, gd.score);
	  }
}
/*
***************结果***************
张三 66.600000
*/