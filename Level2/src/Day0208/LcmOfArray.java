package Day0208;

public class LcmOfArray {
    //    두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
    //    예를 들어 2와 7의 최소공배수는 14가 됩니다.
    //    정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
    //    n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
    public int solution(int[] arr) {
        int res = arr[0];
        for (int j : arr) {
            res = lcm(res, j);
        }
        return res;
    }

    public int lcm(int a, int b) {
        int gcd = 1;
        for (int i = 1; i < a + 1; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return a * b / gcd;
    }

    public static void main(String[] args) {
        LcmOfArray l = new LcmOfArray();
        System.out.println(l.solution(new int[]{2, 6, 8, 14}));
        System.out.println(l.solution(new int[]{1, 2, 3}));
    }
}
