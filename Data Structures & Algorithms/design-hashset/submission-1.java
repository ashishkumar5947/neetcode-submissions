class MyHashSet {
    private final List<List<Integer>> buckets;
    private static final int M = 1000; // number of buckets

    public MyHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);

        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);

        bucket.remove(Integer.valueOf(key)); // Object remove, not index remove
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);

        return bucket.contains(key);
    }

    private int getIndex(int key) {
        return key % M;
    }
}