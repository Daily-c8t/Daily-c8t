package Week05.문제24_두_개_뽑아서_더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class fing9 {

	class Solution {

		public List<Integer> solve(List<Integer> numbers) {
			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < numbers.size(); i++) {
				for (int j = 0; j < numbers.size(); j++) {
					if (i != j) {
						ans.add(numbers.get(i) + numbers.get(j));
					}
				}
			}

			return ans;
		}

		public int[] solution(int[] numbers) {
			return solve(Arrays.stream(numbers).boxed().collect(Collectors.toList()))
					.stream()
					.sorted()
					.distinct()
					.mapToInt(Integer::intValue)
					.toArray();
		}
	}

}
