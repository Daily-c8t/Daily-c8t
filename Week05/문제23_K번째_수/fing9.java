package Week05.문제23_K번째_수;

import java.util.ArrayList;
import java.util.List;

public class fing9 {

	class Solution {

		public int[] subAnsSort(int[] array, int s, int e) {
			List<Integer> list = new ArrayList<>();
			for (int i = s - 1; i < e; i++) {
				list.add(array[i]);
			}
			return list.stream()
					.sorted()
					.mapToInt(Integer::intValue)
					.toArray();
		}

		public int[] solution(int[] array, int[][] commands) {
			List<Integer> answer = new ArrayList<>();

			for (int i = 0; i < commands.length; i++) {
				int s = commands[i][0];
				int e = commands[i][1];
				int k = commands[i][2];
				answer.add(subAnsSort(array, s, e)[k - 1]);
			}

			return answer.stream()
					.mapToInt(Integer::intValue)
					.toArray();
		}

	}

}
