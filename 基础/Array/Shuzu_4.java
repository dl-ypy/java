import java.util.Random;

/**
 * date:2017年4月15日22:14:18
 * target:通过new扩充数组。
 * @author ypy
 */
 public class Shuzu_4{
	 static Random rand = new Random();
	 static int pRand(int mod) {//随机扩充20以内的数
		 return Math.abs(rand.nextInt())%mod + 1;
	 }
	 public static void main(String[] args) {
		 //扩充基本数据类型int
		 int[] a;
		 a = new int[pRand(20)];
		 System.out.println("length:" + a.length);
		 for (int i=0; i<a.length; i++) {
			 System.out.println("a[" + i + "]:" + a[i]);
		 }
		 
		//扩充基本数据类型char
		 char[] c;
		 c = new char[pRand(20)];
		 System.out.println("length:" + c.length);
		 for (int i=0; i<c.length; i++) {
			 System.out.println("c[" + i + "]:" + c[i]);
		 }
		 
		//扩充基本数据类型boolean
		 boolean[] b;
		 b = new boolean[pRand(20)];
		 System.out.println("length:" + b.length);
		 for (int i=0; i<b.length; i++) {
			 System.out.println("b[" + i + "]:" + b[i]);
		 }
		 
		//扩充非基本数据类型（类）Integer
		 Integer[] n;
		 n = new Integer[pRand(20)];
		 System.out.println("length:" + n.length);
		 for (int i=0; i<n.length; i++) {
			 System.out.println("n[" + i + "]:" + n[i]);
		 }
	 }
}
/*
 ***************jdk1.8运行结果*************** 
length:16
a[0]:0
a[1]:0
a[2]:0
a[3]:0
a[4]:0
a[5]:0
a[6]:0
a[7]:0
a[8]:0
a[9]:0
a[10]:0
a[11]:0
a[12]:0
a[13]:0
a[14]:0
a[15]:0
length:9
c[0]:
c[1]:
c[2]:
c[3]:
c[4]:
length:3
b[0]:false
b[1]:false
b[2]:false
length:4
n[0]:null
n[1]:null
n[2]:null
n[3]:null
 */
