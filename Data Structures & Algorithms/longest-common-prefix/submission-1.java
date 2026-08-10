class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String prefix = strs[0];

        for (int i = 1; i < n; i++) {
            String s1 = strs[i];
            prefix = getLongestPrefix(s1, prefix);
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