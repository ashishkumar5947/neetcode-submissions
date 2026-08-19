class Solution {
    // public int longestConsecutive(int[] nums) {
    //     if (nums.length == 0)
    //         return 0;
    //     Arrays.sort(nums);

    //     int current = 1, longest = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i - 1])
    //             continue;

    //         if (nums[i] == nums[i - 1] + 1) {
    //             current++;
    //         } else {
    //             current = 1;
    //         }

    //         longest = Math.max(current, longest);
    //     }

    //     return longest;
    // }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int current = num;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
