class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int longest = 0;

        int maxFrequency = 0;
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencies.get(c));

            while ((right - left + 1) - maxFrequency > k) {
                c = s.charAt(left);
                frequencies.put(c, frequencies.getOrDefault(c, 0) - 1);
                if (frequencies.get(c) == 0)
                    frequencies.remove(c);

                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
