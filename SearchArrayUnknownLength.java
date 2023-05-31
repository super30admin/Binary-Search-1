class SearchArrayUnknownLength {
    public int search(int arr[], int target) {
        int low = 0;
        int high = 1;

        while (arr[high] < target) {

            low = high;

            high = 2 * high;

        }

        return binarySearch(arr, target, low, high);

    }

    private int binarySearch(int arr[], int target, int low, int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
