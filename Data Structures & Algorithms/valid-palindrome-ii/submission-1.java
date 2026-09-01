class Solution {
    // public boolean isPalindrome(String s) {
    //     s = s.toLowerCase();
    //     int left = 0, right = s.length() - 1;

    //     while (left < right) {
    //         if (!Character.isLetterOrDigit(s.charAt(left))) {
    //             left++;
    //         } else if (!Character.isLetterOrDigit(s.charAt(right))) {
    //             right--;
    //         } else {
    //             if (s.charAt(left) != s.charAt(right)) {
    //                 return false;
    //             }
    //             left++;
    //             right--;
    //         }
    //     }

    //     return true;
    // }

    // // Input: s = "abbda"
    // // Output: true
    // public boolean validPalindrome(String s) {
    //     StringBuilder temp = new StringBuilder(s);

    //     for (int i = 0; i < s.length(); i++) {
    //         temp = temp.deleteCharAt(i);

    //         boolean isValid = isPalindrome(temp.toString());

    //         if (isValid)
    //             return true;

    //         temp = new StringBuilder(s);
    //     }

    //     return false;
    // }

    // OPTIMAL
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}