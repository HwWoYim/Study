package class03;

public class Test07 {
	public static void main(String[] args) {
		int num = 1;


		while(num <= 1000) {
			int i = 0;
			int total = 0;
			while(i < num-1) {
				i++;
				if(num%i == 0) {
					total += i;
				}
			}
			if(total==num) {
				System.out.print(num + " ");
			}
			num++;
		}








	}
}
