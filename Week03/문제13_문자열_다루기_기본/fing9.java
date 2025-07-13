package Week03.문제13_문자열_다루기_기본;

public class fing9 {

	class Solution {
		public boolean solution(String s) {
			try {
				Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return false;
			}

			return s.length() == 4 || s.length() == 6;
		}
	}

}
