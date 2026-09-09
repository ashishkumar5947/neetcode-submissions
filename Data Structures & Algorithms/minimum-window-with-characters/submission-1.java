class Solution {
    // public String minWindow(String s, String t) {
    //     int start = 0;
    //     int minLength = Integer.MAX_VALUE;

    //     Map<Character, Integer> reqFrequency = new HashMap<>();
    //     for (char c : t.toCharArray()) reqFrequency.put(c, reqFrequency.getOrDefault(c, 0) + 1);

    //     for (int i = 0; i < s.length(); i++) {
    //         Map<Character, Integer> currFrequency = new HashMap<>();

    //         for (int j = i; j < s.length(); j++) {
    //             currFrequency.put(s.charAt(j), currFrequency.getOrDefault(s.charAt(j), 0) + 1);

    //             if (isValidFrequency(currFrequency, reqFrequency)) {
    //                 if (j - i + 1 < minLength) {
    //                     minLength = j - i + 1;
    //                     start = i;
    //                 }
    //             }
    //         }
    //     }

    //     return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    // }

    // private boolean isValidFrequency(
    //     Map<Character, Integer> currFrequency, Map<Character, Integer> reqFrequency) {
    //     for (Map.Entry<Character, Integer> entry : reqFrequency.entrySet()) {
    //         char c = entry.getKey();
    //         int frequency = entry.getValue();

    //         if (currFrequency.getOrDefault(c, 0) < frequency) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public String minWindow(String s, String t) {
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> reqFrequency = new HashMap<>();
        for (char c : t.toCharArray()) reqFrequency.put(c, reqFrequency.getOrDefault(c, 0) + 1);

        int left = 0;
        Map<Character, Integer> currFrequency = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            currFrequency.put(s.charAt(right), currFrequency.getOrDefault(s.charAt(right), 0) + 1);

            while (isValidFrequency(currFrequency, reqFrequency)) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                currFrequency.put(
                    s.charAt(left), currFrequency.getOrDefault(s.charAt(left), 0) - 1);
                if (currFrequency.get(s.charAt(left)) == 0)
                    currFrequency.remove(s.charAt(left));

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    private boolean isValidFrequency(
        Map<Character, Integer> currFrequency, Map<Character, Integer> reqFrequency) {
        for (Map.Entry<Character, Integer> entry : reqFrequency.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();

            if (currFrequency.getOrDefault(c, 0) < frequency) {
                return false;
            }
        }

        return true;
    }
}
