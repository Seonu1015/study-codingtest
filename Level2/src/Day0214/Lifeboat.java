package Day0214;

import java.util.Arrays;

public class Lifeboat {
    //    무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다.
    //    구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
    //    예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고
    //    구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만
    //    1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
    //    구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
    //    사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
    //    모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
    public int solution(int[] people, int limit) {
        quickSort(people, 0, people.length - 1);
        int count = 0;
        int left = 0;
        int right = people.length -1;
        while (left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Lifeboat b = new Lifeboat();
        int[] people1 = {70, 50, 80, 50};
        int[] people2 = {70, 80, 50};
        System.out.println(b.solution(people1, 100));
        System.out.println(b.solution(people2, 100));
    }
}
