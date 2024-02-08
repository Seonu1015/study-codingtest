package Day0208;

import java.util.ArrayList;
import java.util.List;

public class IsSquareRoot {
    //    임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
    //    n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
    public long solution1(long n) {
        long answer = 0;
        List<Integer> sqrt = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sqrt.add(i);
            }
        }
        System.out.println(sqrt);
        if (sqrt.size() % 2 == 0) {
            answer = -1;
        } else {
            int num = sqrt.get(sqrt.size() / 2);
            answer = (long) (num + 1) * (num + 1);
        }
        return answer;
    }

    // 위의 코드는 시간 초과
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long) Math.sqrt(n);
        System.out.println(sqrt);
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                long num1 = i;
                long num2 = n / i;
                if(num1 == num2) {
                    answer = (num1 + 1) * (num1 + 1);
                }
            }
        }
        return answer == 0 ? -1 : answer;
    }

    public static void main(String[] args) {
        IsSquareRoot sqrt = new IsSquareRoot();
        System.out.println(sqrt.solution(121));
        System.out.println(sqrt.solution(3));
    }
}
