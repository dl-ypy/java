/**
 * date:2017��6��1��10:27:19
 * target:label����;��
 * @author ypy
 * conclusion:
 *     breakֻ��������ǰѭ������ʹ��label��ǩ������������ѭ����
 */
public class Label {
	public static void main(String[] args) {
		System.out.println("ֻ��breakʱ��");
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i == 2) {
					break;
				}
				System.out.println("i=" + i + "ʱ��" + j);
			}
		}
		
		System.out.println("------------------------");
		System.out.println("��label");
		label:   //�������κ�����
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i == 2) {
					break label;
				}
				System.out.println("i=" + i + "ʱ��" + j);
			}
		}
	}
}
/*
 *************** jdk1.8���н��***************
ֻ��breakʱ��
i=0ʱ��0
i=0ʱ��1
i=0ʱ��2
i=0ʱ��3
i=0ʱ��4
i=1ʱ��0
i=1ʱ��1
i=1ʱ��2
i=1ʱ��3
i=1ʱ��4
i=3ʱ��0
i=3ʱ��1
i=3ʱ��2
i=3ʱ��3
i=3ʱ��4
i=4ʱ��0
i=4ʱ��1
i=4ʱ��2
i=4ʱ��3
i=4ʱ��4
------------------------
��label
i=0ʱ��0
i=0ʱ��1
i=0ʱ��2
i=0ʱ��3
i=0ʱ��4
i=1ʱ��0
i=1ʱ��1
i=1ʱ��2
i=1ʱ��3
i=1ʱ��4
 */
