package Day0213;

public class StrangeCharacter {
    //    문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
    //    각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
    //    각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ", -1);
        for (int i = 0; i < str.length; i++) {
            if (i < str.length - 1) {
                answer += upperOrLower(str[i]) + " ";
            } else {
                answer += upperOrLower(str[i]);
            }
        }
        return answer.toString();
    }

    public String upperOrLower(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(s.charAt(i)));
            } else {
                result.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StrangeCharacter c = new StrangeCharacter();
        System.out.println(c.solution("try hello world"));
    }
}
