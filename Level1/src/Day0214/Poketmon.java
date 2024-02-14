package Day0214;

import java.util.ArrayList;
import java.util.List;

public class Poketmon {
    public int solution(int[] nums) {
        List<Integer> mon = new ArrayList<>();
        for (int num : nums) {
            if (!mon.contains(num)) {
                mon.add(num);
            }
        }
        return Math.min(nums.length / 2, mon.size());
    }
}
