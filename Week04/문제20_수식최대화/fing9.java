package Week04.문제20_수식최대화;

import java.util.*;
import java.math.*;

public class fing9 {

	class Solution {

		public long findHeadStart(String expression, int delemeterIndex) {
			boolean minus = false;
			for (int i = delemeterIndex - 1; i >= 0; i--) {
				char c = expression.charAt(i);
				if (!('0' <= c && c <= '9' && !minus) && !(c == '-')) {
					if (minus) {
						if (expression.charAt(delemeterIndex) == '-') {
							return i + 1;
						}
						return i + 2;
					}
					return i + 1;
				}
				if (c == '-') {
					minus = true;
				}
			}
			return 0;
		}

		public long parseHead(String expression, int delemeterIndex) {
			String longString = expression.substring((int) findHeadStart(expression, delemeterIndex), delemeterIndex);
			if (longString.isEmpty()) {
				return 0L;
			}
			if (longString.equals("-")) {
				return 0L;
			}
			return Long.parseLong(longString);
		}

		public long findTailEnd(String expression, int delemeterIndex) {
			for (int i = delemeterIndex + 1; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if (!('0' <= c && c <= '9') && !(c == '-' && i == delemeterIndex + 1)) {
					return i;
				}
			}
			return expression.length();
		}

		public long parseTail(String expression, int delemeterIndex) {
			String longString = expression.substring(delemeterIndex + 1, (int) findTailEnd(expression, delemeterIndex));
			return Long.parseLong(longString);
		}

		public String operating(long a, long b, char operator) {
			if (operator == '+') {
				return String.valueOf(a + b);
			} else if (operator == '-') {
				return String.valueOf(a - b);
			} else {
				return String.valueOf(a * b);
			}
		}

		public String evaluation(String expression, char operator) {
			for (int i = 0; i < expression.length(); i++) {
				if (expression.charAt(i) == operator) {
					long a = parseHead(expression, i);
					long b = parseTail(expression, i);
					long headStartIndex = findHeadStart(expression, i);
					long tailEndIndex = findTailEnd(expression, i);
					if (headStartIndex == i || i == tailEndIndex) {
						continue;
					}
					String newExpression = expression.substring(0, (int) headStartIndex) +
							operating(a, b, operator) +
							expression.substring((int) tailEndIndex, expression.length());

					return evaluation(newExpression, operator);
				}
			}

			return expression;
		}

		public long solution(String expression) {
			long answer = 0;

			// answer =
			// Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression,'+'),'-'),'*')));
			// answer =
			// Math.max(Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression,'+'),'*'),'-'))),
			// answer);
			// answer =
			// Math.max(Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression,'*'),'-'),'+'))),
			// answer);
			// answer =
			// Math.max(Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression,'*'),'+'),'-'))),
			// answer);
			// answer =
			// Math.max(Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression,'-'),'+'),'*'))),
			// answer);
			answer = Math.max(Math.abs(Long.parseLong(evaluation(evaluation(evaluation(expression, '-'), '*'), '+'))),
					answer);

			return answer;
		}
	}

}
