public class Unknown {

    public int search(int arr[], int key) {

        // we need high and low range for the binary search

        int l = 0;
        int h = 1;

        while (key < arr[h]) {
            if (h < arr.length) {
                h = 2 * h;
            } else {
                h = arr.length - 1;
            }
        }

        return binarySearch(arr, l, h, key);
    }

    public int binarySearch(int arr[], int l, int r, int x) {
        int pivot = l + (r - l) / 2;

        if (x == arr[pivot]) {
            return pivot;
        } else if (x < arr[pivot] && pivot <= r) {
            return binarySearch(arr, l, pivot - 1, x);
        } else if (x > arr[pivot] && pivot <= r) {
            return binarySearch(arr, pivot + 1, r, x);
        } else
            return -1;
    }

    public static void main(String[] args) {

        Unknown uk = new Unknown();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 };
        System.out.println(uk.search(arr, 21));
        System.out.println(uk.search(arr, 50));
    }
}
