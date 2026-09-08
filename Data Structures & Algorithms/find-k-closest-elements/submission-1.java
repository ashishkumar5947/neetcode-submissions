class Solution {
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     List<Integer> sorted = new ArrayList<>();
    //     for (int num : arr) {
    //         sorted.add(num);
    //     }

    //     sorted.sort((a, b) -> {
    //         int diffA = Math.abs(a - x);
    //         int diffB = Math.abs(b - x);

    //         if (diffA != diffB)
    //             return Integer.compare(diffA, diffB);

    //         return Integer.compare(a, b);
    //     });

    //     List<Integer> ans = new ArrayList<>();
    //     for (int i = 0; i < k; i++) {
    //         ans.add(sorted.get(i));
    //     }

    //     Collections.sort(ans);
    //     return ans;
    // }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, minDistance = 0, bestStart = 0;

        int currDistance = 0;
        for (int i = 0; i < k; i++) {
            currDistance += Math.abs(arr[i] - x);
        }
        minDistance = currDistance;

        for (int right = k; right < arr.length; right++) {
            currDistance += Math.abs(arr[right] - x);
            currDistance -= Math.abs(arr[left] - x);
            left++;

            if (currDistance < minDistance) {
                minDistance = currDistance;
                bestStart = left;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = bestStart; i < bestStart + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}