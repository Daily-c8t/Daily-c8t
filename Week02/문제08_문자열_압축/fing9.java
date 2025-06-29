package Week02.문제08_문자열_압축;

public class fing9 {

	class Solution {

		public int getNumberSize(int size) {
			String sizeText = size + "";
			return sizeText.length();
		}

		public int solution(String s) {
			int answer = Integer.MAX_VALUE;
			int size = 1;

			while (size <= s.length()) {
				int cnt = s.length();
				int i = 0;

				while (i <= s.length()) {
					int subI = i + size;
					int subCnt = 1;

					if (i + size < s.length()) {
						String sub = s.substring(i, i + size);

						while (subI + size <= s.length()) {
							String nextSub = s.substring(subI, subI + size);

							if (!sub.equals(nextSub)) {
								break;
							}
							subCnt++;
							subI += size;
						}
					}

					cnt -= (size * (subCnt > 1 ? (subCnt - 1) : 0)) - (subCnt > 1 ? getNumberSize(subCnt) : 0);
					i += subCnt * size;
				}
				size++;
				if (cnt < answer) {
					answer = cnt;
				}
			}

			return answer;
		}

	}

}
