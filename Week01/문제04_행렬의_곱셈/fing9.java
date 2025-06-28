package Week01.문제04_행렬의_곱셈;

class Solution {

	int multiple(int[] row, int[][] colArr, int col) {
		int n = row.length;

		int ret = 0;
		for (int i = 0; i < n; i++) {
			ret += row[i] * colArr[i][col];
		}
		return ret;
	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			int[] retRow = new int[arr2[0].length];
			for (int j = 0; j < arr2[0].length; j++) {
				retRow[j] = multiple(arr1[i], arr2, j);
			}
			answer[i] = retRow;
		}

		return answer;
	}
}