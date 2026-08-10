class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     int n = strs.length;
    //     List<List<String>> ans = new ArrayList<>();
    //     boolean[] visited = new boolean[n];

    //     for (int i = 0; i < n; i++) {
    //         if (visited[i])
    //             continue;

    //         List<String> group = new ArrayList<>();

    //         for (int j = i; j < n; j++) {
    //             if (visited[j])
    //                 continue;

    //             if (isValidAnagram(strs[i], strs[j])) {
    //                 group.add(strs[j]);
    //                 visited[j] = true;
    //             }
    //         }

    //         ans.add(group);
    //     }

    //     return ans;
    // }

    // private boolean isValidAnagram(String word1, String word2) {
    //     if (word1.length() != word2.length())
    //         return false;

    //     int[] frequency = new int[26];

    //     for (char c : word1.toCharArray()) {
    //         frequency[c - 'a']++;
    //     }

    //     for (char c : word2.toCharArray()) {
    //         frequency[c - 'a']--;

    //         if (frequency[c - 'a'] < 0)
    //             return false;
    //     }

    //     return true;
    // }

    // OPTIMAL
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] frequency = new int[26];
            for (char c : word.toCharArray()) {
                frequency[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int count : frequency) {
                key.append(count).append('#');
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
