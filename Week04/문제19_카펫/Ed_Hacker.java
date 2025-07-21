public class Solution{
    public int[] solution(int brown, int yellow){
        //n+m = (brown + 4) / 2
        int plus = (brown + 4) / 2;

        // n * m = yellow + brown
        int multi = yellow + brown;

        int answer[] = new int[2];

        for(int n= 1; n <= 5000; n++){
            int m = plus - n;
            if(n*m == multi){
                answer[0]= n;
                answer[1]= m;
            }
        }
        return answer;
    }

}