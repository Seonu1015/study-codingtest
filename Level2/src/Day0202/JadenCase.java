package Day0202;

import java.util.Arrays;

public class JadenCase {
//    JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
//    단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
//    문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//    "3people unFollowed me" -> "3people Unfollowed Me"

    public String solution(String s) {
        String answer = "";

        String[] strs = {};
        strs = s.split(" ", -1); // -1을 사용하여 마지막 빈 문자열도 포함하게 처리
        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].isEmpty()) {
                continue;
            }
//            System.out.println(Character.isDigit(str.charAt(0)));
            String str = strs[i];
            str = str.toLowerCase();
//            System.out.println(str);

            if (!Character.isDigit(str.charAt(0))) {
                str = str.substring(0, 1).toUpperCase() + str.substring(1);
            }
            strs[i] = str;
        }
//        System.out.println(Arrays.toString(strs));
        answer = String.join(" ", strs);
        return answer;
    }

    // 삼항 연산자 활용해서 재풀이
    public String solution2(String s) {
        String answer = "";
        String[] strs = s.toLowerCase().split("");
        boolean flag = true;

        for (String str : strs) {
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase j = new JadenCase();
        System.out.println(j.solution("3people unFollowed me"));
        System.out.println(j.solution(" for the last week "));
    }

}
