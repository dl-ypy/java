import java.util.HashMap;
import java.util.Hashtable;

/**
 * date:2017��6��14��09:28:02
 * target:Hashtable��HashMap������
 * @author ypy
 * conclusion��
 *     һ.��ʷԭ��:Hashtable �ǻ��ڳ¾ɵ� Dictionary��ģ�HashMap �� Java 1.2������ Map�ӿڵ�һ��ʵ�֡�
 *     ��.ͬ����:Hashtable ���̰߳�ȫ�ģ�Ҳ����˵��ͬ���ģ��� HashMap ���߳��򲻰�ȫ�ģ�����ͬ���ġ�
 *     ��.ֵ��ֻ�� HashMap�������㽫��ֵ��Ϊһ�������Ŀ�� key �� value
 */
public class Container_12Hashtable_HashMap {
	public static void main(String[] args) {
		Hashtable<String, String> t = new Hashtable<>();
		HashMap<String, String> m = new HashMap<>();
		//t.put(null, null);   //���������null
		m.put(null, null);
		System.out.println(m);
	}
}
/*
 *************** jdk1.8���н��***************
 *{null=null}
 */
