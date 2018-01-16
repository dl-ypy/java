/*
    时间：2016年11月17日08:44:14
    目的：线程的控制之Priority。
*/
public class XianCheng_7{
	public static void main(String[] args){
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.setPriority(Thread.NORM_PRIORITY + 3);//设置t1的优先级高，t1就会优先执行的次数多
		t1.start();
		t2.start();
	}
}

class T1 implements Runnable{
	public void run(){
		for (int i=0; i<50; i++){
			System.out.println("T1:" + i);
		}
	}
}

class T2 implements Runnable{
	public void run(){
		for (int i=0; i<50; i++){
			System.out.println("-----T2:" + i);
		}
	}
}
/*
***************JDK1.8运行结果***************
T1:0
T1:1
T1:2
T1:3
T1:4
T1:5
T1:6
T1:7
T1:8
T1:9
T1:10
T1:11
T1:12
T1:13
T1:14
T1:15
T1:16
T1:17
T1:18
T1:19
T1:20
T1:21
T1:22
T1:23
T1:24
T1:25
-----T2:0
T1:26
-----T2:1
T1:27
T1:28
T1:29
T1:30
T1:31
T1:32
T1:33
T1:34
T1:35
T1:36
T1:37
T1:38
T1:39
T1:40
T1:41
T1:42
T1:43
T1:44
T1:45
T1:46
T1:47
T1:48
T1:49
-----T2:2
-----T2:3
-----T2:4
-----T2:5
-----T2:6
-----T2:7
-----T2:8
-----T2:9
-----T2:10
-----T2:11
-----T2:12
-----T2:13
-----T2:14
-----T2:15
-----T2:16
-----T2:17
-----T2:18
-----T2:19
-----T2:20
-----T2:21
-----T2:22
-----T2:23
-----T2:24
-----T2:25
-----T2:26
-----T2:27
-----T2:28
-----T2:29
-----T2:30
-----T2:31
-----T2:32
-----T2:33
-----T2:34
-----T2:35
-----T2:36
-----T2:37
-----T2:38
-----T2:39
-----T2:40
-----T2:41
-----T2:42
-----T2:43
-----T2:44
-----T2:45
-----T2:46
-----T2:47
-----T2:48
-----T2:49
*/