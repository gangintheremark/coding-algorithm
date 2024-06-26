import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] memory = new int[n];
		int[] cost = new int[n];
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int total = 0;
		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
			total += cost[i];
		}

		int[][] dp = new int[n][total + 1];
		// dp[][] : i 번째 앱까지 포함했을 경우, j의 비용으로 얻을 수 있는 메모리
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int mem = memory[i];
			int c = cost[i];

			for (int j = 0; j <= total; j++) {
				if (i == 0) {
					if (j >= c)
						dp[i][j] = mem;
				} else {
					if (j >= c)
						dp[i][j] = Math.max(dp[i - 1][j - c] + mem, dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				}

				if (dp[i][j] >= m)
					result = Math.min(result, j);
			}

		}
		System.out.println(result);
	}
}