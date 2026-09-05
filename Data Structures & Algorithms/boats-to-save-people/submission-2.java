class Solution {
    // public int numRescueBoats(int[] people, int limit) {
    //     int n = people.length;
    //     boolean[] used = new boolean[n];
    //     int boats = 0;
    //     int remaining = n;

    //     while (remaining > 0) {
    //         int heavyIdx = -1;
    //         for (int i = 0; i < n; i++) {
    //             if (!used[i] && (heavyIdx == -1 || people[i] > people[heavyIdx])) {
    //                 heavyIdx = i;
    //             }
    //         }

    //         used[heavyIdx] = true;
    //         remaining--;
    //         boats++;

    //         int lightIdx = -1;
    //         for (int i = 0; i < n; i++) {
    //             if (!used[i] && (lightIdx == -1 || people[i] < people[lightIdx])) {
    //                 lightIdx = i;
    //             }
    //         }

    //         if (lightIdx != -1 && people[heavyIdx] + people[lightIdx] <= limit) {
    //             used[lightIdx] = true;
    //             remaining--;
    //         }
    //     }

    //     return boats;
    // }

    // OPTIMAL
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }
}