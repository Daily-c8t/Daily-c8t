package Week02.문제06_이상한_시저_암호;

public class fing9 {

	class Solution {

		public char encript(char c, int key) {
			if ('a' <= c && c <= 'z') {
				c += key;
				if ('z' < c) {
					c = (char) ((int) 'a' + (int) c - (int) 'z' - 1);
				}
			} else if ('A' <= c && c <= 'Z') {
				c += key;
				if ('Z' < c) {
					c = (char) ((int) 'A' + (int) c - (int) 'Z' - 1);
				}
			}
			return c;
		}

		public String solution(String s, int n) {
			String answer = "";
			StringBuilder sb = new StringBuilder(answer);
			for (int i = 0; i < s.length(); i++) {
				sb.append(encript(s.charAt(i), n));
			}
			return sb.toString();
		}
	}

}