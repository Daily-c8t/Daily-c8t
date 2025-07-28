import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers) {
        //빅문제 -> 배열은 크기가 고정이라 중복 생기면 어캄?
        // 그럼 크기 알고리즘을 짜서 정해놓고 스트림으로 바꿔서 distinct() 조지고 다시 배열로 변환해서 .sort()하자
        //크기가 5면 크기 경우의 수는 4+3+2+1
        int numbersLength = 0;

        for(int i = numbers.length-1; i >= 1; i--){
            numbersLength += i;
        }

        int[] fullArray = new int [numbersLength];

        int count = 0;

        for(int i = 0; i < numbers.length ; i++){
            for(int j = i+1; j < numbers.length ; j++){
                fullArray[count] = numbers[i] + numbers[j];
                count++;
            }
        }
        IntStream answerStream = Arrays.stream(fullArray);
        int[] answer = answerStream.distinct().toArray();
        Arrays.sort(answer);

        return answer;

    }
}