import java.io.File;
import java.io.IOException;

/**
 * date:2017��5��14��11:12:09
 * target:File������
 * @author ypy 
 * conclusion:
 *     (1)�������ļ�����Ŀ¼��ʹ��File�����;
 *     (2)File��ֻ�ṩ�����ļ���Ŀ¼�ķ����������ܷ����ļ������ݣ����������������ļ����������;
 *     (3)���Ҫ�����ļ������õ��������Ժ�Ҫѧϰ��IO��.  
 */
public class Liu7_File1 {
	//�ļ�����
	private static void fileData(File f) {
		System.out.println("------------------" + 
		"\n ����·��: " + f.getAbsolutePath() +
		"\n �ɶ���: " + f.canRead() +
		"\n ��д��: " + f.canWrite() +
		"\n ��ִ�У�: " + f.canExecute() +
		"\n �ļ�/Ŀ¼��: " + f.getName() +
		"\n ��Ŀ¼: " + f.getParent() +
		"\n ���·��: " + f.getPath() +
		"\n length: " + f.length() +
		"\n ����޸ĵ�ʱ��: " + f.lastModified() + //����ʱ��㣨1970 �� 1 �� 1 �գ�00:00:00 GMT��֮��ĺ�������ʾ
		"\n------------------");
		//�ж���Ŀ¼�����ļ�
		if(f.isFile())
			System.out.println("it's a file");
		else if(f.isDirectory())
			System.out.println("it's a directory");
		}
	
	public static void main(String[] args) {
		File directory = new File("java\\ypy");//Ŀ¼   ����ֻ�Ǵ�����Ŀ¼���󣬲�û�����������ļ���Ŀ¼
		File file = new File("java\\ypy\\A.java");// �ļ�
		fileData(directory);
		fileData(file);
		//�ж�Ŀ¼�Ƿ����
		if (directory.exists()) {
			System.out.println(directory + " �Ѿ����ڣ�");
			//�ж��ļ��Ƿ����
			if (file.exists()) {
				System.out.println(file + " �Ѿ����ڣ�");
				//System.out.println("����ɾ��..." + file);
				//file.delete();
			} else {
				try {
					file.createNewFile();  //�����ļ�
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			//����
			System.out.println("����... " + directory);
			directory.mkdirs();   //����Ŀ¼
			System.out.println("����... " + file);
			try {
				file.createNewFile();  //�����ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileData(directory);
			fileData(file);
			//System.out.println("����...");
			//old.renameTo(new File("update"));
		}
	}
}
/*
 *************** jdk1.8���н��*************** 
------------------
 ����·��: G:\java\����\IO\java\ypy
 �ɶ���: false
 ��д��: false
 ��ִ�У�: false
 �ļ�/Ŀ¼��: ypy
 ��Ŀ¼: java
 ���·��: java\ypy
 length: 0
 ����޸ĵ�ʱ��: 0
------------------
------------------
 ����·��: G:\java\����\IO\java\ypy\A.ja
 �ɶ���: false
 ��д��: false
 ��ִ�У�: false
 �ļ�/Ŀ¼��: A.java
 ��Ŀ¼: java\ypy
 ���·��: java\ypy\A.java
 length: 0
 ����޸ĵ�ʱ��: 0
------------------
����... java\ypy
����... java\ypy\A.java
------------------
 ����·��: G:\java\����\IO\java\ypy
 �ɶ���: true
 ��д��: true
 ��ִ�У�: true
 �ļ�/Ŀ¼��: ypy
 ��Ŀ¼: java
 ���·��: java\ypy
 length: 0
 ����޸ĵ�ʱ��: 1495097810000
------------------
it's a directory
------------------
 ����·��: G:\java\����\IO\java\ypy\A.java
 �ɶ���: true
 ��д��: true
 ��ִ�У�: true
 �ļ�/Ŀ¼��: A.java
 ��Ŀ¼: java\ypy
 ���·��: java\ypy\A.java
 length: 0
 ����޸ĵ�ʱ��: 1495097810000
------------------
it's a file
 */
