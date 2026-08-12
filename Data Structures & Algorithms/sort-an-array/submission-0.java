class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums; // edge case: empty ya single element

        int[] temp = new int[nums.length]; // ek hi baar allocate, reuse hoga
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums; // ab return kar do
    }

    private void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        merge(nums, temp, start, mid, end);
    }

    private void merge(int[] nums, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        int left = start, right = mid + 1, index = start;

        while (left <= mid && right <= end) {
            if (temp[left] <= temp[right]) {
                nums[index++] = temp[left++];
            } else {
                nums[index++] = temp[right++];
            }
        }
        while (left <= mid) {
            nums[index++] = temp[left++];
        }
        while (right <= end) {
            nums[index++] = temp[right++];
        }
    }
}