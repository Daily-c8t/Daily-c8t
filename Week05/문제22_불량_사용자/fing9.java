package Week05.문제22_불량_사용자;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fing9 {

	class Solution {

		List<List<String>> answers = new ArrayList<>();

		public boolean equals(String bannedId, String userId) {
			if (bannedId.length() != userId.length()) {
				return false;
			}
			for (int i = 0; i < bannedId.length(); i++) {
				if (bannedId.charAt(i) == '*') {
					continue;
				}
				if (bannedId.charAt(i) != userId.charAt(i)) {
					return false;
				}
			}
			return true;
		}

		public String[] ignoreOneItem(String[] arr, int idx) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (i == idx) {
					continue;
				}
				list.add(arr[i]);
			}
			return list.toArray(new String[0]);
		}

		public List<String> copy(List<String> arr) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < arr.size(); i++) {
				list.add(arr.get(i));
			}
			return list;
		}

		public int solve(String[] user_id, String[] banned_id, List<String> answer) {
			if (banned_id.length == 0) {
				List<String> list = copy(answer);
				Collections.sort(list);
				if (!answers.contains(list)) {
					answers.add(list);
					return 1;
				}
				return 0;
			}

			int ans = 0;
			String banned = banned_id[0];
			for (int j = 0; j < user_id.length; j++) {
				if (equals(banned, user_id[j])) {
					answer.add(user_id[j]);
					ans += solve(ignoreOneItem(user_id, j), ignoreOneItem(banned_id, 0), answer);
					answer.remove(answer.size() - 1);
				}
			}
			return ans;
		}

		public int solution(String[] user_id, String[] banned_id) {
			return solve(user_id, banned_id, new ArrayList<>());
		}

	}

}
