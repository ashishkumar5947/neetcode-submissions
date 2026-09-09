class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] ans = new int[n - k + 1];

    //     int index = 0;
    //     for (int i = 0; i < n - k + 1; i++) {
    //         int max = Integer.MIN_VALUE;

    //         for (int j = i; j < i + k; j++) {
    //             max = Math.max(max, nums[j]);
    //         }

    //         ans[index++] = max;
    //     }

    //     return ans;
    // }

    // OPTIMAL
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        int left = 0, index = 0;

        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if (deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            if (right >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}
