package Week01.문제03_거리두기_확인하기;

import java.util.*;
import java.lang.Math.*;

class Solution {

	boolean canGo(String[] place, int sy, int sx, int ey, int ex) {
		int diffY = sy - ey;
		int diffX = sx - ex;

		if (Math.abs(diffY) == 1 && Math.abs(diffX) == 1) {
			if (place[sy - diffY].charAt(sx) == 'X' && place[sy].charAt(sx - diffX) == 'X') {
				return false;
			} else {
				return true;
			}
		}
		if ((diffY == 2) && (diffX == 0)) {
			if (place[sy - 1].charAt(sx) == 'X') {
				return false;
			} else {
				return true;
			}
		}
		if ((diffY == -2) && (diffX == 0)) {
			if (place[sy + 1].charAt(sx) == 'X') {
				return false;
			} else {
				return true;
			}
		}
		if ((diffX == 2) && (diffY == 0)) {
			if (place[sy].charAt(sx - 1) == 'X') {
				return false;
			} else {
				return true;
			}
		}
		if ((diffX == -2) && (diffY == 0)) {
			if (place[sy].charAt(sx + 1) == 'X') {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	boolean isMenhatan2(int sy, int sx, int ey, int ex) {
		if (Math.abs(sy - ey) + Math.abs(sx - ex) <= 2) {
			return true;
		}
		return false;
	}

	boolean isIn(int n, int y, int x) {
		return !(y < 0 || n <= y || x < 0 || n <= x);
	}

	boolean validate(String[] place, int y, int x) {
		int n = place.length;

		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				int targetY = y + i;
				int targetX = x + j;
				if ((i == 0 && j == 0) || !isIn(n, targetY, targetX)) {
					continue;
				}
				if (!(place[targetY].charAt(targetX) == 'P') || !isMenhatan2(y, x, targetY, targetX)) {
					continue;
				}

				if (canGo(place, y, x, targetY, targetX)) {
					return false;
				}
			}
		}

		return true;
	}

	Integer solve(String[] place) {
		for (int y = 0; y < place.length; y++) {
			for (int x = 0; x < place[y].length(); x++) {
				if (place[y].charAt(x) == 'P' && !validate(place, y, x)) {
					return 0;
				}
			}
		}
		return 1;
	}

	public int[] solution(String[][] places) {
		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i < places.length; i++) {
			answers.add(solve(places[i]));
		}
		return answers.stream().mapToInt(i -> i).toArray();
	}

}