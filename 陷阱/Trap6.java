package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * data:2018��3��28��20��23��
 * @author joker
 * Java��������֮��java���ƴ�javac����
 */
public class Trap6{
	public static void main(String[] args) throws IOException, InterruptedException{
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("javac");
		InputStream stderr = proc.getErrorStream();
		InputStreamReader isr = new InputStreamReader(stderr);
		BufferedReader bfr = new BufferedReader(isr);
		String line = null;
		System.out.println("<ERROR>");
		while ((line=bfr.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("</ERROR>");
		int exitVal = proc.waitFor();
		System.out.println("Process exitValue:" + exitVal);
	}
}

/**
 * JDK1.8���н��
 <ERROR>
�÷�: javac <options> <source files>
����, ���ܵ�ѡ�����:
  -g                         �������е�����Ϣ
  -g:none                    �������κε�����Ϣ
  -g:{lines,vars,source}     ֻ����ĳЩ������Ϣ
  -nowarn                    �������κξ���
  -verbose                   ����йر���������ִ�еĲ�������Ϣ
  -deprecation               ���ʹ���ѹ�ʱ�� API ��Դλ��
  -classpath <·��>            ָ�������û����ļ���ע�ʹ�������λ��
  -cp <·��>                   ָ�������û����ļ���ע�ʹ�������λ��
  -sourcepath <·��>           ָ����������Դ�ļ���λ��
  -bootclasspath <·��>        �����������ļ���λ��
  -extdirs <Ŀ¼>              ��������װ��չ��λ��
  -endorseddirs <Ŀ¼>         ����ǩ���ı�׼·����λ��
  -proc:{none,only}          �����Ƿ�ִ��ע�ʹ����/����롣
  -processor <class1>[,<class2>,<class3>...] Ҫ���е�ע�ʹ�����������; �ƹ�Ĭ�ϵ���������
  -processorpath <·��>        ָ������ע�ʹ�������λ��
  -parameters                ����Ԫ���������ڷ��������ķ���
  -d <Ŀ¼>                    ָ���������ɵ����ļ���λ��
  -s <Ŀ¼>                    ָ���������ɵ�Դ�ļ���λ��
  -h <Ŀ¼>                    ָ���������ɵı�����ͷ�ļ���λ��
  -implicit:{none,class}     ָ���Ƿ�Ϊ��ʽ�����ļ��������ļ�
  -encoding <����>             ָ��Դ�ļ�ʹ�õ��ַ�����
  -source <���а�>              �ṩ��ָ�����а��Դ������
  -target <���а�>              �����ض� VM �汾�����ļ�
  -profile <�����ļ�>            ��ȷ��ʹ�õ� API ��ָ���������ļ��п���
  -version                   �汾��Ϣ
  -help                      �����׼ѡ�����Ҫ
  -A�ؼ���[=ֵ]                  ���ݸ�ע�ʹ�������ѡ��
  -X                         ����Ǳ�׼ѡ�����Ҫ
  -J<���>                     ֱ�ӽ� <���> ���ݸ�����ʱϵͳ
  -Werror                    ���־���ʱ��ֹ����
  @<�ļ���>                     ���ļ���ȡѡ����ļ���

</ERROR>
Process exitValue:2

*/