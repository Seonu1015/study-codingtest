package Day0208;

public class SumBetween {
    //    두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
    //    예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
    public long solution(int a, int b) {
        long answer = 0;
        if (a < b) {
            for (int i = a; i < b + 1; i++) {
                answer += i;
            }
        } else if (b < a) {
            for (int i = b; i < a + 1; i++) {
                answer += i;
            }
        } else{
            answer = a;
        }
        return answer;
    }

    public static void main(String[] args) {
        SumBetween s = new SumBetween();
        System.out.println(s.solution(3, 5));
        System.out.println(s.solution(3, 3));
        System.out.println(s.solution(5, 3));
    }
}
