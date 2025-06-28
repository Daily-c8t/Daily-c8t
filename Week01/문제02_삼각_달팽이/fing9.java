package Week01.문제02_삼각_달팽이;

import java.util.*;

class Solution {

	public int[][] fillUp(int[][] map, int n, int current, int x, int y, int depth) {
		int totalUpCount = 0;
		for (int j = y; j < n - depth; j++) {
			map[j][x] = current;
			current++;
			totalUpCount++;
		}
		y = n - depth - 1;
		for (int i = x + 1; i < n - (x * 2); i++) {
			map[n - depth - 1][i] = current;
			current++;
			totalUpCount++;
		}
		x = n - (x * 2) - 1;
		x--;
		y--;
		// System.out.println("X:" + x);
		// System.out.println("Y:" + y);
		while (y >= depth && x >= depth && map[y][x] == 0) {
			map[y][x] = current;
			y--;
			x--;
			current++;
			totalUpCount++;
		}
		if (totalUpCount <= 6) {
			return map;
		}
		return fillUp(map, n, current, x + 1, y + 2, depth + 1);
	}

	public int[] solution(int n) {
		List<Integer> answer = new ArrayList<>();
		int[][] map = new int[1000][1000];

		map = fillUp(map, n, 1, 0, 0, 0);
		// for (int i=0;i<n;i++) {
		// for (int j=0;j<i+1;j++) {
		// System.out.print(map[i][j] + " ");
		// }
		// System.out.println();
		// }
		// System.out.println("----------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				answer.add(map[i][j]);
			}
		}

		return answer.stream()
				.mapToInt(i -> i)
				.toArray();
	}
}