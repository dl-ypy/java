/*
    时间：2016年1月2日16:50:15
    目的：了解异常。
*/
public class YiChang_2
{
    public static void main(String[] args)
    {
        //int m; 这里不赋值，把赋值语句放在try里面，系统就会认为这个赋值语句不生效，所以就会导致下面语句出错。
	int m = 2;

	try
	{
            m = 1;
	}
	catch(Exception e)
	{
	    
	}
	System.out.printf("%d\n", m);
    }

}
/*
***************结果***************
1

*/
