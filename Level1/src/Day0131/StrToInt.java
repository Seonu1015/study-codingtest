package Day0131;

public class StrToInt {
    // 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
    public int solution(String s) {
        int sign = 1;

        if(s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }

        int answer = Integer.parseInt(s);
        return answer * sign;
    }

    // 추가 공부 - parseInt를 사용하지 않고 해보기


    public static void main(String[] args) {
        StrToInt i = new StrToInt();
        System.out.println(i.solution("-1234"));
    }
}
