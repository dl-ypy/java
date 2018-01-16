/**
 * date:2017��4��20��09:40:51
 * target:�̳��е���β������
 * @author ypy
 * conclusion:
 *     �ڹ���finalize��β����ʱ��Ӧ������ִ���������β�����Ǹ������β��
 *     ���������������β���ܵ��ø�������ͬ�ķ�����Ҫ���������Ȼ���ڻ״̬��
 */
class DoBaseFinalization {
	public static boolean flag = true;
}
class Father {
	public Father() {
		System.out.println("father!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("father finalize!");
	}
}
class Childen extends Father {
	public Childen() {
		System.out.println("childen!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("childen finalize!");
		if (DoBaseFinalization.flag) {
			super.finalize();
		}
	}
}
public class JiCheng_4 {
	public static void main(String[] args) {
		new Childen();
		System.runFinalizersOnExit(true);//�����������System.gc()����ʱ����ִ�и����finalize()
	}
}
/* *************** jdk1.8���н��*************** 
father!
childen!
childen finalize!
father finalize!
 */
