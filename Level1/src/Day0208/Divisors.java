package Day0208;

public class Divisors {
    //    두 정수 left와 right가 매개변수로 주어집니다.
    //    left부터 right까지의 모든 수들 중에서,
    //    약수의 개수가 짝수인 수는 더하고,
    //    약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
    public int solution(int left, int right) {
        int answer = 0;
        for(int n = left; n<=right; n++) {
            if(numberOfSqrt(n) == 0 ) {
                answer += n;
            } else {
                answer -= n;
            }
        }
        return answer;
    }

    public int numberOfSqrt(int n) {
        int sqrt = (int) Math.sqrt(n);
        int count = 0;
        for (int i=1; i<= sqrt; i++) {
            if (n % i == 0) {
                long num1 = i;
                long num2 = n / i;
                if(num1 == num2) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count % 2 == 0 ? 0 : 1;
    }

    // 효율적인 방법 생각해보기
    public int solution1(int left, int right) {
        int answer = 0;
        for(int n = left; n<=right; n++) {
            if(n % Math.sqrt(n) == 0) {
                answer -= n;
            } else {
                answer += n;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Divisors d = new Divisors();
        System.out.println(d.solution(13,17));
        System.out.println(d.solution(24,27));
        System.out.println(d.solution1(13,17));
        System.out.println(d.solution1(24,27));
    }
}
