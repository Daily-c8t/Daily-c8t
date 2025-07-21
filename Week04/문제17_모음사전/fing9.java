package Week04.문제17_모음사전;

import java.util.*;
import java.util.stream.Collectors;

public class fing9 {

	class Solution {

		public List<String> getWords() {
			char[] alphabet = { 'A', 'E', 'I', 'O', 'U' };
			List<String> words = new ArrayList<>();

			for (int i = 0; i < 6; i++) {
				String a = "";
				if (i < 5) {
					a += alphabet[i];
				}
				for (int j = 0; j < 6; j++) {
					String b = a;
					if (j < 5) {
						b += alphabet[j];
					}
					for (int k = 0; k < 6; k++) {
						String c = b;
						if (k < 5) {
							c += alphabet[k];
						}
						for (int s = 0; s < 6; s++) {
							String d = c;
							if (s < 5) {
								d += alphabet[s];
							}
							for (int t = 0; t < 5; t++) {
								String e = d + alphabet[t];
								words.add(e);
							}
						}
					}
				}
			}

			Collections.sort(words);
			return words.stream().distinct().collect(Collectors.toList());
		}

		public int solution(String word) {
			int answer = 0;
			List<String> words = getWords();
			for (int i = 0; i < words.size(); i++) {
				if (word.equals(words.get(i))) {
					return i + 1;
				}
			}
			return answer;
		}
	}

}
