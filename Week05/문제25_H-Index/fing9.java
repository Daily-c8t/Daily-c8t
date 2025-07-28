package Week05.문제25_H-Index;

public class fing9 {

	class Solution {

		public int solution(int[] citations) {
			int answer = 0;
			for (int h = 1; h <= citations.length; h++) {
				for (int i = 0; i < citations.length; i++) {
					int overOrEqualsCnt = 0;
					for (int j = 0; j < citations.length; j++) {
						if (h <= citations[j]) {
							overOrEqualsCnt++;
						}
					}
					if (h <= overOrEqualsCnt) {
						if (answer < h) {
							answer = h;
						}
					}
				}
			}
			return answer;
		}
	}

}
