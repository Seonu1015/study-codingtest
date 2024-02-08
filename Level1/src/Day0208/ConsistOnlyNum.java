package Day0208;

public class ConsistOnlyNum {
    //    문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
    //    예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
    public boolean solution(String s) {
        boolean answer = true;
        char[] c = s.toCharArray();
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < c.length; i++) {
                if (Character.isLetter(c[i])) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        ConsistOnlyNum n = new ConsistOnlyNum();
        System.out.println(n.solution("a234"));
        System.out.println(n.solution("1234"));
    }
}
