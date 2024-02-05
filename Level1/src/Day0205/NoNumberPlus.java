package Day0205;

public class NoNumberPlus {
    //    0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
    //    numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += i;
        }
        for (int num : numbers) {
            answer -= num;
        }
        return answer;
    }

    public static void main(String[] args) {
        NoNumberPlus n = new NoNumberPlus();
        System.out.println(n.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }
}
