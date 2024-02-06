package Day0206;

import java.util.Arrays;

public class DescendString {
    //    문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
    //    s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
    public String solution(String s) {
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper.append(s.charAt(i));
            } else {
                lower.append(s.charAt(i));
            }
        }
        char[] sortedUpper = quickSort(upper.toString().toCharArray(), 0, upper.length() - 1);
        char[] sortedLower = quickSort(lower.toString().toCharArray(), 0, lower.length() - 1);

        String upperString = new String(sortedUpper);
        String lowerString = new String(sortedLower);

        return lowerString + upperString;
    }

    public char[] quickSort(char[] str, int low, int high) {
        if (low < high) {
            char pivot = str[low + (high - low) / 2];
            int i = low;
            int j = high;
            while (i <= j) {
                while (str[i] > pivot) {
                    i++;
                }
                while (str[j] < pivot) {
                    j--;
                }
                if (i <= j) {
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                    i++;
                    j--;
                }
            }
            quickSort(str, low, j);
            quickSort(str, i, high);
        }
//        System.out.println(Arrays.toString(str));
        return str;
    }

    public static void main(String[] args) {
        DescendString s = new DescendString();
        System.out.println(s.solution("ABDCEFvr"));
    }
}
