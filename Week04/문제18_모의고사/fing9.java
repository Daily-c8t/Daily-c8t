package Week04.문제18_모의고사;

public class fing9 {

	class Solution {
		public int[] solution(int[] answers) {
			int[] spj1 = { 1, 2, 3, 4, 5 };
			int[] spj2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
			int[] spj3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
			int cnt1 = 0;
			int cnt2 = 0;
			int cnt3 = 0;
			int[] answer = {};

			for (int i = 0; i < answers.length; i++) {
				if (spj1[i % 5] == answers[i]) {
					cnt1++;
				}
				if (spj2[i % 8] == answers[i]) {
					cnt2++;
				}
				if (spj3[i % 10] == answers[i]) {
					cnt3++;
				}
			}
			if (cnt1 == cnt2 && cnt2 == cnt3) {
				return new int[] { 1, 2, 3 };
			}
			if (cnt1 == cnt2 && cnt1 > cnt3) {
				return new int[] { 1, 2 };
			}
			if (cnt1 == cnt3 && cnt1 > cnt2) {
				return new int[] { 1, 3 };
			}
			if (cnt2 == cnt3 && cnt2 > cnt1) {
				return new int[] { 2, 3 };
			}
			if (cnt1 > cnt2 && cnt1 > cnt3) {
				return new int[] { 1 };
			}
			if (cnt2 > cnt1 && cnt2 > cnt3) {
				return new int[] { 2 };
			}
			if (cnt3 > cnt1 && cnt3 > cnt2) {
				return new int[] { 3 };
			}
			return answer;
		}
	}

}
