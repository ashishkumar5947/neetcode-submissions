class Solution {
    // public int maxArea(int[] heights) {
    //     int n = heights.length;
    //     int maxArea = 0;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             int width = j - i;
    //             int height = Math.min(heights[i], heights[j]);

    //             int area = width * height;
    //             maxArea = Math.max(maxArea, area);
    //         }
    //     }

    //     return maxArea;
    // }

    // OPTIMAL
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int left = 0, right = n - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
