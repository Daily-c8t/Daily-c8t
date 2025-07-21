public class solution{
    private static final int[][] RULES = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5},
    };

    private int getPicked(int person, int problem){
        int[] rule = RULES[person];
        int index = problem % rule.length;
        //미친 크랙; 규칙이 반복되니까 나누기로 규칙에서 몇번째인지 구하기 가능
        return rule[index];
    }


    //수포자별 맞힌 개수
    int[] corrects = new int[3];

    //가장 정답을 많이 맞힌 사람의 정답 개수
    int max = 0;

    for(int problem = 0; proble < answers.length; problem++){
        int answer = answers[problem];
        //각 수포자별로 정답 개수 세기
        for(int person = 0; person < 3; person++){
            int picked = getPicked(person,problem);
            if(answer == picked){
                if(++corrects[person] > max){
                    max = corrects[person];
                }
                //정답일 때 비교하는거니까 전위연산자 써야함
    }


        }
    }

    final int maxCorrects = max;
    return IntStream.range(0,3)
            .filter(i -> corrects[i] == maxCorrects)
            .map(i->i+1) //n번째 사람이 n-1으로 등록되어있어서
            .toArray();
    //스트림 문법 정리ㄱㄱ
}