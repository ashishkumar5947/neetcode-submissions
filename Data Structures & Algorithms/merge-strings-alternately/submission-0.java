class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int left = 0, right = 0;
        StringBuilder ans = new StringBuilder();

        while (left < n1 && right < n2) {
            ans.append(word1.charAt(left));
            ans.append(word2.charAt(right));

            left++;
            right++;
        }

        while (left < n1) {
            ans.append(word1.charAt(left));
            left++;
        }

        while (right < n2) {
            ans.append(word2.charAt(right));
            right++;
        }

        return ans.toString();
    }
}