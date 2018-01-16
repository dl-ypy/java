/*
    时间：2016年1月22日08:23:25
    目的：equals方法的使用。
*/
class A
{
    public int i;

    public A(int i)
    {
	this.i = i;
    }
}

public class Equals_1
{
    public static void main(String[] args)
    {
	A aa1 = new A(2);
	A aa2 = new A(2);
	//new 出的是两块空间，共4快空间
	
	System.out.println(aa1.equals(aa2));//equals方法返回boolean类型
	                                     //==比较的是两个引用是不是指向同一个内存地址,
	                                     //equals比较的是两个对象的实际内容是不是相同（equals()的默认行为是比较引用，而java内部类已经对其进行了修改，改为比较的是两个对象的实际内容）
	                                     //对于java内部的类  如String  new String().equals(new String()) 就是true
	                                     //自己定义的类要想new出来的值equals为true，必须重写hashCode()
    }
}
/*
***************结果**************
false
*/
