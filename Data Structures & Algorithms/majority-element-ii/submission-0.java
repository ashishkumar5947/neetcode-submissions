class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > nums.length / 3)
                ans.add(num);
        }

        return ans;
    }
}