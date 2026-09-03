class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] copy = new int[n];

        for (int i = n - k; i < n; i++) {
            copy[i - (n - k)] = nums[i];
        }

        for (int i = 0; i < n - k; i++) {
            copy[i + k] = nums[i];
        }

        for (int i = 0; i < n; i++) nums[i] = copy[i];
    }
}