class Solution {
    // BRUTE
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     char[] word1 = s.toCharArray();
    //     char[] word2 = t.toCharArray();

    //     Arrays.sort(word1);
    //     Arrays.sort(word2);

    //     return Arrays.equals(word1, word2);
    // }

    // BETTER
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length())
    //         return false;

    //     Map<Character, Integer> frequency = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    //     }

    //     for (char c : t.toCharArray()) {
    //         if (!frequency.containsKey(c))
    //             return false;

    //         frequency.put(c, frequency.get(c) - 1);

    //         if (frequency.get(c) < 0)
    //             return false;

    //         if (frequency.get(c) == 0)
    //             frequency.remove(c);
    //     }

    //     return frequency.isEmpty();
    // }

    // OPTIMAL
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            frequency[c - 'a']--;

            if (frequency[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
