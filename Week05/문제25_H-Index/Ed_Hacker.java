public class Solution{
    public int solution(int[] citations){
        int h = 0;
        int answer = 0;

        //citations.length의 최댓값이 1000이므로 O(n제곱)해도 시간복잡도 괜춘하다
        while(h <= citations.length){
            int count = 0;

            for(int i = 0; i < citations.length; i++){
                if( h <= citations[i]) count++;
            } //h-index보다 인용횟수 많은 것 있을 때 마다 count++

            if(h <= count){
                answer = h;  //count가 h보다 크면 h-index 업데이트
            }else{
                break;  // 조건 만족못하면 어차피 h가 더 커져도 무조건 만족 못하므로 break
            }
            h++;
        }

        return answer;


}

/*
import java.util.Arrays;

class Solution{
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >= h;
    }

    public int solution(int[] citations){
        Arrays.sort(citations);    //정렬하고 맨 뒤에서 h번째가 h이상이면 h-index 성립
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
            }
        return 0;
    }
}
 */