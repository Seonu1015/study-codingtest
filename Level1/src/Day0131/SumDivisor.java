package Day0131;

public class SumDivisor {
    // 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요
    public int sumDivisor1(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    // 개선 - 반복문을 절반으로 줄임
    public int sumDivisor2(int n) {
        int answer = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer+n;
    }

    // 개선2 - 제곱근 활용
    public int sumDivisor3(int n) {
        int answer = 0;
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                answer += i;
                if (i != n / i) { // 제곱수는 한 번만 더해야 함
                    answer += n / i;
                }
            }
        }
        return answer;
    }

    // 테스트 결과 출력 코드
    public static void main(String[] args) {
        SumDivisor s = new SumDivisor();
        System.out.println(s.sumDivisor1(12));
        System.out.println(s.sumDivisor2(12));
        System.out.println(s.sumDivisor3(12));
    }
}
