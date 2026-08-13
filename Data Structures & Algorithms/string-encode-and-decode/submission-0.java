class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String word : strs) {
            encoded.append(word.length()).append("#").append(word);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            // Read length
            StringBuilder lengthBuilder = new StringBuilder();

            while (str.charAt(i) != '#') {
                lengthBuilder.append(str.charAt(i));
                i++;
            }

            int length = Integer.parseInt(lengthBuilder.toString());

            // Skip '#'
            i++;

            // Read the word
            StringBuilder word = new StringBuilder();

            while (length > 0) {
                word.append(str.charAt(i));
                i++;
                length--;
            }

            decoded.add(word.toString());
        }

        return decoded;
    }
}
