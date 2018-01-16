//Ñî»ÔÈý½Ç
public class PascalTriangle {
    public static void main(String[] args) {

		int[][] a = new int[10][10];
		int s = 0;
		for (int i=0; i<a.length; i++) {
			for (int k=0; k<a.length-i; k++) {
				System.out.print(" ");
			}
			a[i][0] = a[i][s] = 1;
			s++;
			if(s != 1) {
				for (int j=1; j<(s-1); j++) {
					a[i][j] = a[i-1][j-1] + a[i-1][j];
				}
			}
			for (int j=0; j<s; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
	}
    }
}