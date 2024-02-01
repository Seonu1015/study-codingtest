package Day0201;

public class EvenOrOdd {
    //정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
    public String solution1(int num) {
        String answer = "";
        if(num%2==0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }

    // 개선 - 삼항연산자를 사용해서 간결한 코드로 수정
    public String solution2(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        EvenOrOdd e = new EvenOrOdd();
        System.out.println(e.solution1(3));
        System.out.println(e.solution2(2));
    }
}
