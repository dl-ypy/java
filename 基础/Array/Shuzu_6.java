import java.util.Random;

/**
 * date:2017��4��16��09:04:24
 * target:��ά���顣
 * @author ypy
 */
 public class Test{
	static Random rand = new Random();
	static int pRand(int mod) {
		return Math.abs(rand.nextInt())%mod + 1;
	}
	 
	public static void main(String[] args) {
		//�����������ͳ�ʼ����ά����
		int[][] a1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		for (int i=0; i<a1.length; i++) {
			for (int j=0; j<a1[i].length; j++) {
				System.out.println("a1[" + i + "][" + j + "]:" + a1[i][j]);
			}
		}
		
		//��������������new����������ά����
		boolean[][][] a2 = new boolean[2][3][4];
		for (int i=0; i<a2.length; i++) {
			for (int j=0; j<a2[i].length; j++) {
				for (int k=0; k<a2[i][j].length; k++){
					System.out.println("a2[" + i + "][" + j + "][" + k + "]:" + a2[i][j][k]);
				}
			}
		}
		
		//�����������Ͷ�ά���������ÿ��ʸ�������������ⳤ��
		double[][][] a3 = new double[pRand(5)][][];
		for (int i=0; i<a3.length; i++) {
			a3[i] = new double[pRand(5)][];
			for (int j=0; j<a3[i].length; j++) {
				a3[i][j] = new double[pRand(5)];
				for (int k=0; k<a3[i][j].length; k++){
					System.out.println("a3[" + i + "][" + j + "][" + k + "]:" + a3[i][j][k]);
				}
			}
		}
		
		//�ǻ����������Ͷ�ά����ĳ�ʼ��
		//java�ڲ���װ��������������������һ��ʹ�ã���Integer������int��������һ������
		//���Լ�д�������new
		Integer[][] a4 = {
				{new Integer(1), new Integer(2)},
				{new Integer(3), new Integer(4)},
				{new Integer(5), new Integer(6)},
		};
		for (int i=0; i<a4.length; i++) {
			for (int j=0; j<a4[i].length; j++) {
				System.out.println("a4[" + i + "][" + j + "]:" + a4[i][j]);
			}
		}
		
		//�ǻ����������Ͷ�ά���������ÿ��ʸ��Ҳ�����������ⳤ��
		Integer[][] a5;
		a5 = new Integer[3][];
		for (int i=0; i<a5.length; i++) {
			a5[i] = new Integer[4];
			for (int j=0; j<a5[i].length; j++) {
				a5[i][j] = new Integer(i*j);
				System.out.println("a5[" + i + "][" + j + "]:" + a5[i][j]);
			}
		}
	}
}
/*
 ***************jdk1.8���н��*************** 
a1[0][0]:1
a1[0][1]:2
a1[0][2]:3
a1[1][0]:4
a1[1][1]:5
a1[1][2]:6
a2[0][0][0]:false
a2[0][0][1]:false
a2[0][0][2]:false
a2[0][0][3]:false
a2[0][1][0]:false
a2[0][1][1]:false
a2[0][1][2]:false
a2[0][1][3]:false
a2[0][2][0]:false
a2[0][2][1]:false
a2[0][2][2]:false
a2[0][2][3]:false
a2[1][0][0]:false
a2[1][0][1]:false
a2[1][0][2]:false
a2[1][0][3]:false
a2[1][1][0]:false
a2[1][1][1]:false
a2[1][1][2]:false
a2[1][1][3]:false
a2[1][2][0]:false
a2[1][2][1]:false
a2[1][2][2]:false
a2[1][2][3]:false
a3[0][0][0]:0.0
a3[0][0][1]:0.0
a3[0][0][2]:0.0
a3[0][0][3]:0.0
a3[0][1][0]:0.0
a3[0][1][1]:0.0
a3[0][1][2]:0.0
a3[1][0][0]:0.0
a3[1][0][1]:0.0
a3[1][0][2]:0.0
a3[1][0][3]:0.0
a3[1][1][0]:0.0
a3[1][1][1]:0.0
a3[1][1][2]:0.0
a3[1][1][3]:0.0
a3[1][2][0]:0.0
a3[1][2][1]:0.0
a3[1][2][2]:0.0
a3[1][3][0]:0.0
a3[1][3][1]:0.0
a3[1][3][2]:0.0
a3[2][0][0]:0.0
a3[2][0][1]:0.0
a3[2][0][2]:0.0
a3[2][0][3]:0.0
a3[2][1][0]:0.0
a3[2][2][0]:0.0
a3[2][2][1]:0.0
a3[2][2][2]:0.0
a3[2][3][0]:0.0
a3[3][0][0]:0.0
a3[3][0][1]:0.0
a3[3][0][2]:0.0
a3[3][0][3]:0.0
a4[0][0]:1
a4[0][1]:2
a4[1][0]:3
a4[1][1]:4
a4[2][0]:5
a4[2][1]:6
a5[0][0]:0
a5[0][1]:0
a5[0][2]:0
a5[0][3]:0
a5[1][0]:0
a5[1][1]:1
a5[1][2]:2
a5[1][3]:3
a5[2][0]:0
a5[2][1]:2
a5[2][2]:4
a5[2][3]:6
 */
