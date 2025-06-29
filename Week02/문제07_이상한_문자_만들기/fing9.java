package Week02.문제07_이상한_문자_만들기;

public class fing9 {

	class Solution {

		public char conversion(char c, boolean capital) {
			if ('a' <= c && c <= 'z' && capital) {
				char gap = (char) ((int) c - (int) 'a');
				c = (char) ((int) 'A' + (int) gap);
			} else if ('A' <= c && c <= 'Z' && !capital) {
				char gap = (char) ((int) c - (int) 'A');
				c = (char) ((int) 'a' + (int) gap);
			}
			return c;
		}

		public String solution(String s) {
			String answer = "";
			StringBuilder sb = new StringBuilder(answer);
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ') {
					count = -1;
				}
				sb.append(conversion(s.charAt(i), count % 2 == 0));
				count++;
			}
			return sb.toString();
		}
	}

}
