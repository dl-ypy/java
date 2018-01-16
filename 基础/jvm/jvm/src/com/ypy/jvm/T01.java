package com.ypy.jvm;
/**
 * date:2017��12��3�� 20��21��
 * target:��֤ջ�Ϸ����Լ��̱߳��ط���ĵ���
 * @author ypy
 * ����ʱ����jvm������-XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -XX:+PrintGC
 * 			  �ر����ݷ���                                  �رձ����滻                                         �ر��̱߳����ڴ�    ��ӡGC��Ϣ
 */
public class T01 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i=0; i<10000000; i++) {
			new Object();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
/**
 * JDK1.8���н����
 * ��ʹ��ջ�Ϸ�����̱߳��ط���ʱ��
 *     [GC (Allocation Failure)  16383K->640K(62976K), 0.0343237 secs]
 *     [GC (Allocation Failure)  17024K->608K(79360K), 0.0016772 secs]
 *     [GC (Allocation Failure)  33376K->592K(79360K), 0.0018239 secs]
 *     [GC (Allocation Failure)  33360K->680K(112128K), 0.0014285 secs]
 *     391
 * ʹ���̱߳��ط���ʱ��
 *     [GC (Allocation Failure)  16384K->640K(62976K), 0.0014544 secs]
 *     [GC (Allocation Failure)  17024K->664K(62976K), 0.0011713 secs]
 *     [GC (Allocation Failure)  17048K->624K(62976K), 0.0012304 secs]
 *     [GC (Allocation Failure)  17008K->648K(79360K), 0.0012395 secs]
 *     [GC (Allocation Failure)  33416K->648K(79360K), 0.0012099 secs]
 *     [GC (Allocation Failure)  33416K->632K(110592K), 0.0012298 secs]
 *     71
 * ʹ��ջ�Ϸ�����̱߳��ط���ʱ��
 *     7
 */
