class MyHashSet {
    boolean[] array;
    
    public MyHashSet() {
        array = new boolean[10000001];
    }

    public void add(int key) {
        array[key] = true;
    }

    public void remove(int key) {
        array[key] = false;
    }

    public boolean contains(int key) {
        return array[key];
    }
}