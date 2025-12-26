package binarysearch;

class MockArrayReader implements ArrayReader {
    private int[] arr;

    MockArrayReader(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= arr.length) return Integer.MAX_VALUE;
        return arr[index];
    }
}
