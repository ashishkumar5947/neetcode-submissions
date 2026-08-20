class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix ke liye seed

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum - k, 0); // kitne purane prefix match karte hain
            prefixCount.put(
                sum, prefixCount.getOrDefault(sum, 0) + 1); // current sum ko record karo
        }
        return count;
    }
}