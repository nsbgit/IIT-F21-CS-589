package assignment;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a = 26;
//		int b = 0;
//		int c = 26;
//		int d = -14;
//		int rt = problem1.F(a, b, c, d);
//		System.out.println(rt);
		
		int[] a = new int[] {1, 2, 3, 4, 5};
		int n = a.length;
		int rt = F(a, n);
		System.out.println(rt);
	}
	
	public static int F (int[] a, int n) {
		int i, sum;
		i = n;
		sum = 0;
		
		while(i > 0) {
			if (a[i-1] > 0) {
				sum = sum + a[i-1];
			}
			else {
				sum = sum - a[i-1];
			}
			i = i - 1;
		}
		
		
		return sum;
	}

}
