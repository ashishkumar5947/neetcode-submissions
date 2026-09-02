class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}