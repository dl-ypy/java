import java.io.File;

/**
 * date:2017��5��18��17:04:54
 * target:ͨ��File���ҵ�ǰĿ¼�µ������ļ���
 * @author ypy 
 */
public class Liu7_File3 {
	public static void openAll(File f, String s) {// �ݹ��ʵ��
        File[] arr = f.listFiles();// ���г���ǰ�ļ����µ��ļ���Ŀ¼
        for (File ff : arr) {
            if (ff.isDirectory()) {// �г��Ķ�����Ŀ¼��
                System.out.println(s + ff.getName());
                openAll(ff, s+"--->");// �Ǿͼ���������ļ��У�ִ�в���
            } else {
                // ���ǾͰ��ļ������
                System.out.println(s + ff.getName());
            }
        }
    }
    public static void main(String[] args) {
        File file = new File(".");// ��ǰĿ¼
        openAll(file, "");// ��Ŀ¼�µ������ļ����ļ���
    }
}
/*
 *************** jdk1.8���н��*************** 
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
