import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
	//������ǿ��Զ�̬���أ��ô����������ļ��п���ֻд������־���
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//String str = "T";//��֪�������ֵ�ǰ���£�ֻ����������־��ܼ�����
		Properties p = new Properties();//���Լ��������ļ��е���
    	        p.load(Liu.class.getResourceAsStream("/test.properties"));
    		String str = p.getProperty("class");
		Class c = Class.forName(str);//��̬������
		Object o = c.newInstance();//��̬new����
		Method[] methods = c.getMethods();//�õ����з���������
		
		System.out.println("---------------------------");
		for (Method m:methods){
			System.out.println(m.getName());//�õ��෽��������
		}
		System.out.println("---------------------------");
		
		for (Method m:methods){
			if (m.getName().equals("mm")){
				m.invoke(o);//invoke������ķ�������һ���������������󣬵ڶ�������Ϊ�÷����Ĳ���������÷���û�в��������Բ���
			}
			if (m.getName().equals("m1")){
				m.invoke(o, 1, 2);//������ķ����в���������Ҫ������
				for (Class paramType : m.getParameterTypes()){//�õ���������������
					System.out.println(paramType.getName());
				}
			}
			if (m.getName().equals("getS")){
				Class returnType = m.getReturnType();//�õ���������ֵ������
				System.out.println(returnType.getName());
			}
		}
	}

}

class T{
	private int i;
	
	static{
		System.out.println("T loaded!");
	}
	
	public T(){
		System.out.println("T constructed!");
	}
	
	public void mm(){
		System.out.println("mm loaded");
	}
	
	public void m1(int i, int j){
		this.i = i+j;
		System.out.println(this.i);
	}
	
	public String getS(){
		String s = null;
		return s;
	}
}
/*
***************JDK1.8���н��***************
T loaded!
T constructed!
---------------------------
mm
m1
getS
wait
wait
wait
equals
toString
hashCode
getClass
notify
notifyAll
---------------------------
mm loaded
3
int
int
java.lang.String
*/















