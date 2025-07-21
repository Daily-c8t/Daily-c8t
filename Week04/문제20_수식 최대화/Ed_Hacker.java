public class Solution{
    //수식 우선순위 정해주기
    private static final String[][] precedences = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split(""),
    };

    //수식 계산 메서드
    private long calculate(long lhs, long rhs, String op){
        return switch(op){
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    //연산자 우선순위로 계산하는 메서드
    private long calculate(List<String> tokens, String[] precedence) {
        //우선순위 높은 거 부터 계산
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }


    public long solution(String expression) {
        //split으로 나누면 나누는 기준인 연산자를 잃으므로 아래와 같이 문자열을 분리
        //StringTokenizer 공부해보기
        StringTokenizer tokenizer =
                new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            //반복해서 절댓값이 제일 큰 값 return
            long value = Math.abs(
                    calculate(new ArrayList<>(tokens), precedence));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}