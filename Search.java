class Search {

    /*
    // Time Complexity : O(2log n) = O(log n)
    // Space Complexity : O(1)
        To serach in an array of unknown size, we implement binary search but not starting with first and last
        index of the array as it is unknown. We start with the first two indices of the array and check if the value at high index
        is less than the target, then we increment the serch size of array by high * 2. We do this as long as we get a high index which is 
        less than the target value. Once we get the high index range, we do a regular binary search on the array to find index of the target element.
    */

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high -low)/2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}