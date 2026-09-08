class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sorted = new ArrayList<>();
        for (int num : arr) {
            sorted.add(num);
        }

        sorted.sort((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);

            if (diffA != diffB)
                return Integer.compare(diffA, diffB);

            return Integer.compare(a, b);
        });

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(sorted.get(i));
        }

        Collections.sort(ans);
        return ans;
    }
}