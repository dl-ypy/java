import java.io.File;
import java.io.IOException;

/**
 * date:2017��7��7��09:28:19
 * target:������ɾ���ļ���Ŀ¼��
 * @author ypy
 */
public class Liu7_File4 {
	public static void main(String[] args) {
		createDir("G:\\a\\");
		createFiles(new String[]{"G:\\a\\1.txt","G:\\a\\2.txt","G:\\a\\3.txt"});
		deleteFileByName("G:\\a\\1.txt");
		deleteFilesByName("G:\\a\\");
		deleteDir("G:\\a\\");
	}
	
	//�����ļ���
	public static void createDir(String path) {
		File f = new File(path);
		if (f.exists()) {
			f.delete();
		}
		//ע��������isDirectory()�жϲ����ڵ�Ŀ¼�Ƿ���Ŀ¼������
		f.mkdirs(); //�����ļ���ֻ�����
	}
	
	//������������ļ�
	public static void createFiles(String[] filesName) {
		for (String name : filesName) {
			File file = new File(name);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//�����ļ���ɾ���ļ�
	public static void deleteFileByName(String name) {
		File f = new File(name);
		if (f.exists() && f.isFile()) {
			f.delete();
		}
	}
	
	//����ɾ��һ��Ŀ¼�µĶ���ļ�
	public static void deleteFilesByName(String path) {
		File f = new File(path);
		if (f.exists() && f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				file.delete();
			}
		}
	}
	
	
	//ɾ��һ���ļ��м������ļ�    ֻ���õݹ�ɾ��,��Ϊdelete����ֻ��ɾ�����ļ��У����ļ�����Ŀ¼��
	public static void deleteDir(String pathName) {
		File file = new File(pathName);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					deleteDir(f.getAbsolutePath());
				}
				file.delete();
			} else {
				file.delete();
			}
		}
	}
}

/*
***************JDK1.8���н��****************
*/
