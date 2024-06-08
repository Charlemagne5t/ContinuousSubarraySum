import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        if(n < 2) {
            return false;
        }
        int[] ps = new int[n];
        ps[0] = nums[0];
        for(int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) {
                if(map.containsKey(0) || (i > 0 && nums[i - 1] == 0)){
                    return true;
                }
                continue;
            }
            if(ps[i] % k == 0 && i != 0) {
                return true;
            }else {
                if(map.containsKey(ps[i] % k) && map.get(ps[i] % k) != i - 1) {
                    return true;
                }else {
                    map.put(ps[i] % k, i);
                }
            }
        }

        return false;
    }
}