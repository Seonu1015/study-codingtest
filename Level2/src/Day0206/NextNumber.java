package Day0206;

public class NextNumber {
//    자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//    조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//    조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//    조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//    예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//    자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

    public int solution1(int n) {
        int count = toCount(n);
        int nextNum = n + 1;
        while (true) {
            if (toCount(nextNum) != count) {
                nextNum++;
            } else {
                break;
            }
        }
        return nextNum;
    }

    public static int toCount(int number) {
        if (number == 0) return 0;
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.insert(0, number % 2);
            number /= 2;
        }
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    // 위 코드는 효율성 체크에서 시간초과로 실패
    // 이진법으로 변환하는 과정 없이 바로 1을 count 하는 방식으로 변경
    public int solution(int n) {
        int count = countOnes(n);
        int nextNum = n+1;
        while (true) {
            if(countOnes(nextNum) == count) {
                return nextNum;
            }
            nextNum++;
        }
    }

    public int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        NextNumber n = new NextNumber();
        System.out.println(n.solution(78));
    }
}
