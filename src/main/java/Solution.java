import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        Map<Integer, Integer> mapPrefix = new HashMap<>();
        prefixSum[0] = nums[0];
        mapPrefix.put(prefixSum[0], 0);
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            if(prefixSum[i] % k == 0 || (nums[i - 1] == 0 && nums[i] == 0) ){
                return true;
            }
            mapPrefix.put(prefixSum[i], i);
        }
        int iter = (prefixSum[n - 1] - prefixSum[0]) / k;

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= iter; j++){
                if(prefixSum[i] + k * j > prefixSum[n - 1]){
                    break;
                }
                if(mapPrefix.containsKey(prefixSum[i] + k * j)){
                    if(mapPrefix.get(prefixSum[i] + k * j) - i > 1 ){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}