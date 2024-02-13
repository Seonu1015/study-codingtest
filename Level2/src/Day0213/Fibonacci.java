package Day0213;

import java.util.Arrays;

public class Fibonacci {
    //    피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
    //    예를들어
    //    F(2) = F(0) + F(1) = 0 + 1 = 1
    //    F(3) = F(1) + F(2) = 1 + 1 = 2
    //    F(4) = F(2) + F(3) = 1 + 2 = 3
    //    F(5) = F(3) + F(4) = 2 + 3 = 5
    //    와 같이 이어집니다.
    //    2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
    public int solution(int n) {
        // 0 1 1 2 3 5 8 13
        int answer = 0;
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        int div = 1234567;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 2] + fib[i - 1]) % div;
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.solution(3));
        System.out.println(f.solution(5));
    }
}
