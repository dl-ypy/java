import java.io.File;

/**
 * date:2017年5月18日17:04:54
 * target:通过File查找当前目录下的所有文件。
 * @author ypy 
 */
public class Liu7_File3 {
	public static void openAll(File f, String s) {// 递归的实现
        File[] arr = f.listFiles();// 先列出当前文件夹下的文件及目录
        for (File ff : arr) {
            if (ff.isDirectory()) {// 列出的东西是目录吗
                System.out.println(s + ff.getName());
                openAll(ff, s+"--->");// 是就继续获得子文件夹，执行操作
            } else {
                // 不是就把文件名输出
                System.out.println(s + ff.getName());
            }
        }
    }
    public static void main(String[] args) {
        File file = new File(".");// 当前目录
        openAll(file, "");// 打开目录下的所有文件及文件夹
    }
}
/*
 *************** jdk1.8运行结果*************** 
Liu1_zijie_zifu1.java
Liu1_zijie_zifu2.java
Liu2_Buffer1.java
Liu2_Buffer2.java
Liu3_Data.java
Liu4_print1.java
Liu4_print2.java
Liu5_zhuanhuan.java
Liu6_Object.java
Buffer.txt
Buffer2.txt
data.txt
Error.txt
object_output.txt
Out.txt
print.txt
zijie_zifu.txt
Liu7_File2.java
Liu7_File1.java
Liu7_File1.class
java
--->ypy
--->--->A.java
Liu7_File3.java
Liu7_File3.class
 */
