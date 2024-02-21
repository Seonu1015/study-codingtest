package Day0221;

import java.util.Arrays;

public class SortString {
    //    문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
    //    각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
    //    예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            char charA = a.charAt(n);
            char charB = b.charAt(n);
            if(charA == charB) {
                return a.compareTo(b);
            } else {
                return Character.compare(charA, charB);
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        SortString s = new SortString();
        System.out.println(Arrays.toString(s.solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(s.solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
