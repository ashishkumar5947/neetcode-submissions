class Solution {

    // BRUTE FORCE
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             int sum = nums[i] + nums[j];

    //             if (sum == target)
    //                 return new int[] {i, j};
    //         }
    //     }

    //     return new int[] {};
    // }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (seen.containsKey(target - nums[i])) {
                return new int[] {seen.get(target - nums[i]), i};
            }
            
            seen.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
