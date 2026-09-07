class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int left = 0;
        Map<Character, Integer> reqFrequency = new HashMap<>();
        for (char c : s1.toCharArray()) {
            reqFrequency.put(c, reqFrequency.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowFrequency = new HashMap<>();

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);

            windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) + 1);

            while (right - left + 1 > s1.length()) {
                c = s2.charAt(left);
                windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) - 1);
                if (windowFrequency.get(c) == 0)
                    windowFrequency.remove(c);

                left++;
            }

            if (reqFrequency.equals(windowFrequency))
                return true;
        }

        return false;
    }
}
