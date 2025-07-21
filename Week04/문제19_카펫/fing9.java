package Week04.문제19_카펫;

public class fing9 {

	class Solution {
		public int[] solution(int brown, int yellow) {
			int[] answer = {};

			for (int height = 1; height <= yellow; height++) {
				if (yellow % height != 0) {
					continue;
				}
				int width = yellow / height;
				int possibleBrown = (height * 2) + (width * 2) + 4;
				if (possibleBrown == brown) {
					if (width < height) {
						return new int[] { height + 2, width + 2 };
					}
					return new int[] { width + 2, height + 2 };
				}
			}

			return answer;
		}
	}

}
