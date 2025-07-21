public class Solution{

    private static final char[] AEIOU = "AEIOU".toCharrArray();
    //하나씩 넣기 위한 문자열배열

    private List<String> generate(String word){
        List<String> words = new ArrayList<>();
        //결과 리스트 만들어주기 -> 만들고 addAll로 합쳐버리면 됨
        words.add(word);

        //종료조건
        if(word.length() == 5)return words;

        //점화식
        for( char c : AEIOU) {
            words.addAll(generate(word+c));
            //ArrayList인 words끼리 addAll()
        }
        return words;

    }

    public int solution(String word) {
        return generate("").indexOf(word);
        //빈칸도 words의 index[0]에 들어가지만 n번째를 물어봤으므로 서로 상쇄
    }
}