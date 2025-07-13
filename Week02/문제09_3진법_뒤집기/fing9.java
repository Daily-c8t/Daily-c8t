package Week02.문제09_3진법_뒤집기;

public class fing9 {

	class Solution {

		public int toTernary(int n, int ret) {
			ret *= 3;
			ret += n % 3;
			if (n >= 3) {
				return toTernary(n / 3, ret);
			}
			return ret;
		}

		public int solution(int n) {
			int answer = toTernary(n, 0);
			return answer;
		}
	}

}
