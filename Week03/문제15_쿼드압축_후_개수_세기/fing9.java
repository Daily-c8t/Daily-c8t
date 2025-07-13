package Week03.문제15_쿼드압축_후_개수_세기;

public class fing9 {

	class Solution {

		public static final int FULL = 1;
		public static final int EMPTY = 0;
		public static final int MIXED = -1;

		public int isFullorEmpty(int[][] arr, int y, int x, int len) {
			boolean isFull = true;
			boolean isEmpty = true;

			for (int i = y; i < y + len; i++) {
				for (int j = x; j < x + len; j++) {
					if (arr[i][j] == 0) {
						isFull = false;
					}
					if (arr[i][j] == 1) {
						isEmpty = false;
					}
					if (!isFull && !isEmpty) {
						return MIXED;
					}
				}
			}
			if (isFull)
				return FULL;
			else if (isEmpty)
				return EMPTY;
			else
				return MIXED;
		}

		public int[] quadtree(int[][] arr, int y, int x, int len) {
			int mid = len / 2;
			int info = isFullorEmpty(arr, y, x, len);
			if (info == FULL) {
				return new int[] { 0, 1 };
			} else if (info == EMPTY) {
				return new int[] { 1, 0 };
			}

			int[] ans1 = quadtree(arr, y, x, mid);
			int[] ans2 = quadtree(arr, y + mid, x, mid);
			int[] ans3 = quadtree(arr, y, x + mid, mid);
			int[] ans4 = quadtree(arr, y + mid, x + mid, mid);

			return new int[] {
					ans1[0] + ans2[0] + ans3[0] + ans4[0],
					ans1[1] + ans2[1] + ans3[1] + ans4[1]
			};
		}

		public int[] solution(int[][] arr) {
			return quadtree(arr, 0, 0, arr.length);
		}

	}

}
