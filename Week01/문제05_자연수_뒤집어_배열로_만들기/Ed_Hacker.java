public class Problem_5 {
    public int[] solution(long n){
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] chars = reversed.toCharArray();

        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] - '0';
        }
        return result;
    }
}
