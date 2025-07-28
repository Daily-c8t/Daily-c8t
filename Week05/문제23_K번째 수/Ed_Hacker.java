import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //command 배열의 길이 = 결과 개수
        for(int n = 0; n < commands.length; n++ ){
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            //i,j,k 할당

            int arrayLength = j - i + 1;
            int[] slashArray = new int [arrayLength];

            for(int l = i-1 , m = 0; m < arrayLength; l++, m++){
                slashArray[m] = array[l];
            }

            Arrays.sort(slashArray);
            //오름차순으로 정렬

            answer[n] = slashArray[k-1];
        }
        return answer;
    }
}