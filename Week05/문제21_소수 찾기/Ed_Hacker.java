import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    //소수인지 판단하는 메서드
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //재귀로 소수반환
    //acc -> 지금까지 만들어 놓은 숫자 , numbers -> 사용할 수 있는 종이 조각들
    private Set<Integer> getPrimes(int acc, List<Integer> numbers) {
        Set<Integer> primes = new HashSet<>();

        //acc의 소수 여부에 따라 결과집합에 포함
        if (isPrime(acc)) primes.add(acc);

        //numbers의 모든 숫자에 대해 상태전이 준비(재귀로)
        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }

        return primes;
    }

    public int solution(String nums) {
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')  //아스키코드를 정수로 변환
                .boxed() //int원소들을 Integer클래스로 변환
                .collect(Collectors.toList());
        return getPrimes(0, numbers).size(); //마지막으로 개수 반환
    }
}