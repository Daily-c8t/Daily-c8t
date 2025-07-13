package Week02.문제10_이진_변환_반복하기;

public class fing9 {

	class Solution {

		public class Answer {
			int cnt;
			int deletedZero;

			public void plusCnt() {
				this.cnt++;
			}

			public void addDeletedZero(int deletedZero) {
				this.deletedZero += deletedZero;
			}

			public int getCnt() {
				return this.cnt;
			}

			public int getDeletedZero() {
				return this.deletedZero;
			}

			public Answer(int cnt, int deletedZero) {
				this.cnt = cnt;
				this.deletedZero = deletedZero;
			}

		}

		public String deleteZero(String s) {
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					sb.append('1');
				}
			}
			return sb.toString();
		}

		public String intToBinary(int size) {
			StringBuilder sb = new StringBuilder("");
			while (size > 0) {
				sb.append(String.valueOf(size % 2));
				size /= 2;
			}
			return sb.toString();
		}

		public void toBinaryConversion(String s, Answer curAns) {
			if (s.equals("1")) {
				return;
			}
			String sDeletedZero = deleteZero(s);
			curAns.plusCnt();
			curAns.addDeletedZero(s.length() - sDeletedZero.length());
			toBinaryConversion(intToBinary(sDeletedZero.length()), curAns);
		}

		public int[] solution(String s) {
			Answer ans = new Answer(0, 0);
			toBinaryConversion(s, ans);
			int[] answer = new int[2];
			answer[0] = ans.getCnt();
			answer[1] = ans.getDeletedZero();
			return answer;
		}

	}

}
