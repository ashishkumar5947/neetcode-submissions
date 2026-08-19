class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);

        int current = 1, longest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;

            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(current, longest);
        }

        return longest;
    }
}
