package Day0207;

public class HarshadNumber {
    //    양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
    //    예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
    //    자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
    public boolean solution(int x) {
        boolean answer = false;
        int num = x;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
//        System.out.println(x + ": " + sum);
        if (x % sum == 0) return answer = true;
        return answer;
    }

    public static void main(String[] args) {
        HarshadNumber b = new HarshadNumber();
        System.out.println(b.solution(1234));
    }
}
