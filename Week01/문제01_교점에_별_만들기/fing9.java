package Week01.문제01_교점에_별_만들기;

import java.util.*;

class Solution {

	class Pair {

		private long x;
		private long y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public long getX() {
			return this.x;
		}

		public long getY() {
			return this.y;
		}

	}

	public Pair getMaxX(List<Pair> pairs) {
		Pair result = pairs.get(0);
		for (Pair pair : pairs) {
			if (result.getX() < pair.getX()) {
				result = pair;
			}
		}
		return result;
	}

	public Pair getMaxY(List<Pair> pairs) {
		Pair result = pairs.get(0);
		for (Pair pair : pairs) {
			if (result.getY() < pair.getY()) {
				result = pair;
			}
		}
		return result;
	}

	public Pair getMinX(List<Pair> pairs) {
		Pair result = pairs.get(0);
		for (Pair pair : pairs) {
			if (result.getX() > pair.getX()) {
				result = pair;
			}
		}
		return result;
	}

	public Pair getMinY(List<Pair> pairs) {
		Pair result = pairs.get(0);
		for (Pair pair : pairs) {
			if (result.getY() > pair.getY()) {
				result = pair;
			}
		}
		return result;
	}

	public List<Pair> getAllPoints(int[][] line) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				long a = (long) line[i][0];
				long b = (long) line[i][1];
				long e = (long) line[i][2];
				long c = (long) line[j][0];
				long d = (long) line[j][1];
				long f = (long) line[j][2];

				if (((a * d) - (b * c)) == 0
						|| ((b * f) - (e * d)) % ((a * d) - (b * c)) != 0
						|| ((e * c) - (a * f)) % ((a * d) - (b * c)) != 0) {
					continue;
				}

				long calculatedX = ((b * f) - (e * d)) / ((a * d) - (b * c));
				long calculatedY = ((e * c) - (a * f)) / ((a * d) - (b * c));

				pairs.add(new Pair(calculatedX, calculatedY));
			}
		}

		return pairs;
	}

	public String[] getAnswer(List<Pair> points, Pair maxX, Pair maxY, Pair minX, Pair minY) {
		List<String> answers = new ArrayList<>();

		for (long y = maxY.getY(); y >= minY.getY(); y--) {
			String row = "";
			for (long x = minX.getX(); x <= maxX.getX(); x++) {
				boolean isStar = false;
				for (Pair point : points) {
					if (point.getX() == x && point.getY() == y) {
						isStar = true;
						break;
					}
				}
				if (isStar) {
					row += "*";
				} else {
					row += ".";
				}
			}
			answers.add(row);
			// System.out.println(row);
		}

		return answers.toArray(new String[answers.size()]);
	}

	public String[] solution(int[][] line) {

		List<Pair> points = getAllPoints(line);
		Pair maxX = getMaxX(points);
		Pair maxY = getMaxY(points);
		Pair minX = getMinX(points);
		Pair minY = getMinY(points);

		return getAnswer(points, maxX, maxY, minX, minY);
	}

}