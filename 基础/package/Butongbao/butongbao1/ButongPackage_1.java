/*
    时间：2015年12月31日10:13:07
    目的：不同包之间的相互访问。
*/
package Butongbao.butongbao1;

public class ButongPackage_1//  必须写public
{
    public void f()//  必须写public
    {
	System.out.printf("调用另一包中的方法成功。");
    }
}
