/*
    时间：2016年1月11日20:00:29
    目的：哪些异常必须处理，哪些异常可不处理
          了解异常的第二种处理方式
*/
import java.io.*;//throw（抛出）需要引入io包

class A
{
    public void f() throws IOException//throw后面加异常对象（加new）或异常类(不加new)(如果加普通类，定义普通类时，就得写成 “类名”extends Exception)  
	                              // 而throws表示交给被调用者（main方法）处理
	                              // 虽然main方法也没处理，但是也没调用，所以不出错
				      // 如果main方法调用了 f()这个方法，就会出错，这时就需要  try catch 语句进行处理
				      // throws A（A可能为可处理，可不处理的异常， 也可能为必须处理的异常），所以建议调用时对所有throws抛出的异常进行处理
				      // throws A不表示f方法一定会抛出A异常，所以，若方法内部已经对A异常进行了处理，则不需要throws A
    {
    	throw new IOException();//  这个异常必须处理，不处理就编译不了
    }

    public void g()
    {
	throw new ArithmeticException();  //此异常就不必处理也能编译成功
    }
}

public class YiChang_5
{
    public static void main(String[] args)
    {
	A aa = new A();
    }
}
/*
结论：RuntimeException（系统异常）的子类就可处理可不处理。
*/
