import java.io.File;
import java.io.FilenameFilter;

/**
 * date:2017��5��14��09:58:51
 * target:ͨ��File���ҵ�ǰĿ¼�µ��ļ���ʵ��Ŀ¼�б�
 * @author ypy         
 */
public class Liu7_File2 {
	public static void main(String[] args) {
		File path = new File(".");//��ʾ��ǰ·��
		String[] list, list2;
		list = path.list();//list�������ص���һ������
		System.out.println("��Ŀ¼������Ŀ¼���ļ���");
		for (int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
		
		System.out.println("-------------------");
		
		System.out.println("��Ŀ¼��ָ��Ŀ¼���ļ�����");
		list2 = path.list(new DirFilter(".txt"));
		for (int i=0; i<list2.length; i++) {
			System.out.println(list2[i]);
		}
	}
}

class DirFilter implements FilenameFilter {
	String afn;
	public DirFilter(String afn) {
		this.afn = afn;
	}
	@Override
	public boolean accept(File dir, String name) {//list���ϻ�ΪĿ¼��ÿ���ļ����ô˷���
		String f = new File(name).getName();//ȷ���õ������ļ���
		return f.indexOf(afn) != -1;//�ж��Ƿ�����ļ�afn,�������򷵻ظ��ļ��������������û�У��򷵻�-1
	}




/*ʹ�������ڲ���ʵ��
public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		
		list = path.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String f = new File(name).getName();
				return f.indexOf(".txt") != -1;
			}
		});
		
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
*/
	
}
/*
 * *************** jdk1.8���н��*************** 
 * ��Ŀ¼������Ŀ¼���ļ���
 * Liu1_zijie_zifu1.java
 * Liu1_zijie_zifu2.java
 * Liu2_Buffer1.java
 * Liu2_Buffer2.java
 * Liu3_Data.java
 * Liu4_print1.java
 * Liu4_print2.java
 * Liu5_zhuanhuan.java
 * Liu6_Object.java
 * Buffer.txt
 * Buffer2.txt
 * data.txt
 * Error.txt
 * object_output.txt
 * Out.txt
 * print.txt
 * zijie_zifu.txt
 * Liu7_File1.java
 * Liu7_File1.class
 * DirFilter.class
 * -------------------
 * ��Ŀ¼��ָ��Ŀ¼���ļ�����
 * Buffer.txt
 * Buffer2.txt
 * data.txt
 * Error.txt
 * object_output.txt
 * Out.txt
 * print.txt
 * zijie_zifu.txt
 */
