/*
    时间：2015年12月31日10:17:09
    目的：不同包之间的相互访问。
*/
package Butongbao.butongbao2;
import Butongbao.butongbao1.ButongPackage_1;//   导入另一个包。 import包名.文件名

class ButongPackage_2//   一个主类前面只能加public或不加修饰，内部类可以加其他修饰。
{
    public static void main(String[] args)
    {
	ButongPackage_1 a = new ButongPackage_1();
	a.f();
    }
}
/*
***************结果***************
F:\java\基础\package>javac -d . ButongPackage_1.java ButongPackage_2.java
F:\java\基础\package>java Butongbao.butongbao2.ButongPackage_2
调用另一包中的方法成功。
*/
