class Solution {
    // public int trap(int[] height) {
    //     int n = height.length;

    //     int[] leftMaxBoundary = new int[n];
    //     leftMaxBoundary[0] = height[0];
    //     int maxHeight = height[0];
    //     for (int i = 1; i < n; i++) {
    //         if (maxHeight < height[i]) {
    //             maxHeight = height[i];
    //         }
    //         leftMaxBoundary[i] = maxHeight;
    //     }

    //     int[] rightMaxBoundary = new int[n];
    //     rightMaxBoundary[n - 1] = height[n - 1];
    //     maxHeight = height[n - 1];
    //     for (int i = n - 2; i >= 0; i--) {
    //         if (maxHeight < height[i]) {
    //             maxHeight = height[i];
    //         }
    //         rightMaxBoundary[i] = maxHeight;
    //     }

    //     int totalWater = 0;
    //     for (int i = 0; i < n; i++) {
    //         int boundary = Math.min(leftMaxBoundary[i], rightMaxBoundary[i]);
    //         int water = boundary - height[i];
    //         totalWater += water;
    //     }

    //     return totalWater;
    // }

    // OPTIMAL
    public int trap(int[] height) {
        int n = height.length;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        int totalWater = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                int water = leftMax - height[left];
                totalWater += water;
                left++;
            } else {
                int water = rightMax - height[right];
                totalWater += water;
                right--;
            }
        }

        return totalWater;
    }
}
