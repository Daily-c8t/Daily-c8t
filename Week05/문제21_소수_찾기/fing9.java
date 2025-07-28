package Week05.문제21_소수_찾기;

import java.util.*;

public class fing9 {

	class Solution {

		List<Integer> primes = new ArrayList<>();

		public boolean isPrime(int n) {
			if (n == 1 || n == 0)
				return false;
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}

		public char[] charListWithOutIdx(char[] numbers, int idx) {
			List<Character> charList = new ArrayList<>();

			for (int i = 0; i < numbers.length; i++) {
				if (i == idx) {
					continue;
				}
				charList.add(numbers[i]);
			}

			String str = charList.toString().replaceAll(",", "");
			return str.substring(1, str.length() - 1).replaceAll(" ", "").toCharArray();
		}

		public int countPrime(char[] numbers, int cur) {
			int ans = 0;
			if (isPrime(cur) && !primes.contains(cur)) {
				primes.add(cur);
				ans = 1;
			}
			if (numbers.length == 0) {
				return ans;
			}

			for (int i = 0; i < numbers.length; i++) {
				int number = Character.getNumericValue(numbers[i]);
				int next = (cur * 10) + number;

				ans += countPrime(charListWithOutIdx(numbers, i), next);
			}

			return ans;
		}

		public int solution(String numbers) {
			return countPrime(numbers.toCharArray(), 0);
		}
	}

}
