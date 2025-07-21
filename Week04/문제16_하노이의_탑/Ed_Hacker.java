import java.util.ArrayList;
import java.util.List;

public class Solution{
    private List<int[]> hanoi(int n, int from, int to){
        if(n==1)return List.of(new int[] {from,to});
        // n이 1이면 해당 from,to로 이동경로로 return
        // 불변값이므로 List.of 사용
        int empty = 6 - from - to;
        // 6 = 1 + 2 + 3 이니까 from하고 to 빼주면 나머지 한 곳 나오는 로직

        List<int[]> result = new ArrayList<>();
        // 계속 추가해야 하니까 ArrayList 사용
        result.addAll(hanoi(n-1,from,empty));
        //빈 곳으로 n-1개 옮기기
        result.addAll(hanoi(1,from,to));
        // 나머지 1개 목표지점으로 옮기기
        result.addAll(hanoi(n-1,empty,to));
        // 빈곳으로 옮긴 n-1개 목표지점으로 옮기기

        return result;
    }

    public int[][] solution(int n){
        return hanoi(n,1,3).toArray(new int[0][]);
        // from,to를 2차원 배열로 받는다
        // 2차원 배열 선언시에 첫번째에는 크기를 무조건 넣어줘야한다
    }
}