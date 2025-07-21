package Week04.문제16_하노이의탑;

import java.util.*;

public class fing9 {

	class Solution {

		public void move(List<int[]> ans, int n, int from, int middle, int to) {
			if (n == 1) {
				ans.add(new int[] { from, to });
				return;
			}
			move(ans, n - 1, from, to, middle);
			ans.add(new int[] { from, to });
			move(ans, n - 1, middle, from, to);
		}

		public int[][] solution(int n) {
			List<int[]> ans = new ArrayList<>();
			move(ans, n, 1, 2, 3);
			int[][] answer = new int[ans.size()][2];
			for (int i = 0; i < ans.size(); i++) {
				answer[i] = ans.get(i);
			}
			return answer;
		}

	}

}
