import java.util.Arrays;
import java.util.Scanner;

public class yogurtSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {

				arr[j] = in.nextInt();

			}

			System.out.println("Case #" + i + ": " + yogurt(arr, k));
		}
	}

	private static int yogurt(int[] arr, int k) {

		int n = arr.length;
		if (k == 0 || n == 0) {
			return 0;
		} else if (n < k) {
			return n;
		}

		Arrays.sort(arr);
		int i = 0;
		int day = 0;
		int rem = 0;
		while (i < n) {

			if (arr[i] > day && (i + k) < n) {
				day++;
				i += k;
			} else if (i + k >= n && arr[i] > day) {
				i++;
				rem++;
			} else if (arr[i] <= day) {
				i++;
			}
		}
		int cups = (day * k) + rem;
		return cups;
	}

}
