class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (n == 0)
            return;

        k = k % n;

        if (k == 0)
            return;

        int[] copy = new int[n];

        // Copy last k elements
        for (int i = n - k; i < n; i++) {
            copy[i - (n - k)] = nums[i];
        }

        // Copy remaining elements
        for (int i = 0; i < n - k; i++) {
            copy[i + k] = nums[i];
        }

        // Copy back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = copy[i];
        }
    }
}