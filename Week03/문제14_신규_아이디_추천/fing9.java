package Week03.문제14_신규_아이디_추천;

public class fing9 {

	class Solution {

		public boolean isValidChar(char c) {
			return (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || c == '-' || c == '.' || c == '_');
		}

		public String solution(String new_id) {
			StringBuilder sb = new StringBuilder("");

			// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
			new_id = new_id.toLowerCase();

			// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
			for (int i = 0; i < new_id.length(); i++) {
				if (isValidChar(new_id.charAt(i))) {
					sb.append(new_id.charAt(i));
				}
			}
			new_id = sb.toString();
			// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
			for (int i = 0; i < new_id.length(); i++) {
				new_id = new_id.replace("..", ".");
			}
			// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
			while (new_id.length() >= 1
					&& (new_id.charAt(new_id.length() - 1) == '.'
							||
							new_id.charAt(0) == '.')) {
				if (new_id.charAt(new_id.length() - 1) == '.') {
					new_id = new_id.substring(0, new_id.length() - 1);
				} else if (new_id.charAt(0) == '.') {
					new_id = new_id.substring(1, new_id.length());
				}
			}
			// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
			if (new_id.equals("") || new_id == null) {
				new_id = "a";
			}
			// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
			if (new_id.length() > 15) {
				new_id = new_id.substring(0, 15);
			}
			// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
			while (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
			// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
			while (new_id.length() <= 2) {
				new_id += new_id.charAt(new_id.length() - 1);
			}
			return new_id;
		}
	}
	
}
