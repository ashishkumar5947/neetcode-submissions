// class MyHashMap {
//     int[] array;

//     public MyHashMap() {
//         array = new int[1000001];
//         Arrays.fill(array, -1);
//     }

//     public void put(int key, int value) {
//         array[key] = value;
//     }

//     public int get(int key) {
//         return array[key];
//     }

//     public void remove(int key) {
//         array[key] = -1;
//     }
// }

// OPTIMAL
class MyHashMap {
    private final List<List<int[]>> buckets;
    private static final int M = 1000;

    public MyHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        List<int[]> bucket = buckets.get(index);

        for (int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }

        bucket.add(new int[] {key, value});
    }

    public int get(int key) {
        int index = getIndex(key);
        List<int[]> bucket = buckets.get(index);

        for (int[] pair : bucket) {
            if (pair[0] == key)
                return pair[1];
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<int[]> bucket = buckets.get(index);

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i)[0] == key) {
                bucket.remove(i);
                break;
            }
        }
    }

    private int getIndex(int key) {
        return key % M;
    }
}