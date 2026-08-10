class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String prefix = strs[0];

        for (int i = 0; i < n - 1; i++) {
            String s1 = strs[i];
            String s2 = strs[i + 1];

            String currPrefix = getLongestPrefix(s1, s2);
            if (currPrefix.length() < prefix.length())
                prefix = currPrefix;
        }

        return prefix;
    }

    private String getLongestPrefix(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j))
                return prefix.toString();

            prefix.append(s1.charAt(i));
            i++;
            j++;
        }

        return prefix.toString();
    }
}