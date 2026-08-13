class Solution {
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> frequency = new HashMap<>();

    //     for (int num : nums) {
    //         frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    //     }

    //     List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());

    //     entries.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

    //     int[] result = new int[k];

    //     for (int i = 0; i < k; i++) {
    //         result[i] = entries.get(i).getKey();
    //     }

    //     return result;
    // }

    // OPTIMAL
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().getKey();
        }

        return ans;
    }
}
