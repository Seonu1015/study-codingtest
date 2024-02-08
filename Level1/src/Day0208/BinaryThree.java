package Day0208;

public class BinaryThree {
    //    자연수 n이 매개변수로 주어집니다.
    //    n을 3진법 상에서 앞뒤로 뒤집은 후,
    //    이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer *= 3;
            answer += n % 3;
            n /= 3;
        }
        return answer;
    }

    public static void main(String[] args) {
        BinaryThree b = new BinaryThree();
        System.out.println(b.solution(45));
        System.out.println(b.solution(125));
        System.out.println(b.solution(3));
    }
}
