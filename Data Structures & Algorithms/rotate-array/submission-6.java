class Solution {
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;

    //     if (n == 0)
    //         return;

    //     k = k % n;

    //     if (k == 0)
    //         return;

    //     int[] copy = new int[n];

    //     // Copy last k elements
    //     for (int i = n - k; i < n; i++) {
    //         copy[i - (n - k)] = nums[i];
    //     }

    //     // Copy remaining elements
    //     for (int i = 0; i < n - k; i++) {
    //         copy[i + k] = nums[i];
    //     }

    //     // Copy back to nums
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = copy[i];
    //     }
    // }

    // OPTIMAL
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return;
        k = k % n;
        if (k == 0)
            return;

        rotateArr(nums, 0, n - k - 1);
        rotateArr(nums, n - k, n - 1);
        rotateArr(nums, 0, n - 1);
    }

    private void rotateArr(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];

            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}