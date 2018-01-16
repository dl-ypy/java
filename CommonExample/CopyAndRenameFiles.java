import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * date:2017��6��17��21:31:04
 * target:��дһ�����򣬽� d:\javaĿ¼�µ�����.java�ļ����Ƶ� d:\jad Ŀ¼�£�����ԭ���ļ�����չ���� ��ԭ���ļ�����չ����.java  ��Ϊ.jad ��
 * @author ypy
 */
public class CopyAndRenameFiles {
	public static void main(String[] args) throws Exception {
		File srcDir = new File("java");    //���ȴ���һ��javaĿ¼������ż���java�ļ�
		if (!(srcDir.exists() && srcDir.isDirectory())) {   //�ж��Ƿ�������Ƿ���Ŀ¼
			throw new Exception("Ŀ¼�����ڣ�");
		}
		
		//����һ������·�������飬��ʾ�ɴ˳���·������ʾ������ָ����������Ŀ¼�е��ļ���Ŀ¼��
		//�õ�һ���ļ����飬��������".java"��β���ļ���
		File[] files = srcDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
		System.out.println("����" + files.length + "��java�ļ���");
		
		//�½����.jad�ļ���Ŀ¼
		File destDir = new File("jad");
		if (!destDir.exists())
			destDir.mkdirs();
		
		for (File f : files) {
			FileInputStream fis = new FileInputStream(f);
			String destFileName = f.getName().replaceAll("\\.java$", ".jad");//�õ�ÿ���ļ���������.java�滻Ϊ.jad
			FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
			copy(fis, fos);
			fis.close();
			fos.close();
		}
	}
	
	//��ips�е�����д�뵽ops��
	public static void copy(InputStream ips, OutputStream ops) throws IOException {
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len=ips.read(buf)) != -1) {
			//��buf�е�0��ʼ��дlen���ֽڵ��������
			ops.write(buf, 0, len);
		}
	}
}
/*
 *************** jdk1.8���н��***************
 ����2��java�ļ���
 */
