class Solution {
    // public int majorityElement(int[] nums) {
    //     int n = nums.length;

    //     Map<Integer, Integer> frequencies = new HashMap<>();
    //     for (int num : nums) {
    //         frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
    //     }

    //     for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
    //         int num = entry.getKey();
    //         int frequency = entry.getValue();

    //         if (frequency > n / 2)
    //             return num;
    //     }

    //     return -1;
    // }

    // Boyer Moore Algo
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}