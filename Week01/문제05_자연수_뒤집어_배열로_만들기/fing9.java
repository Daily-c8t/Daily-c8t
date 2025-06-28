package Week01.문제05_자연수_뒤집어_배열로_만들기;

import java.util.*;

class Solution {

	void getNextNumber(List<Long> list, long n) {
		list.add(n % 10);
		if (n >= 10) {
			getNextNumber(list, n / 10);
		}
		return;
	}

	public int[] solution(long n) {
		List<Long> list = new ArrayList<>();
		getNextNumber(list, n);

		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			ans[i] = list.get(i).intValue();

		return ans;
	}
}