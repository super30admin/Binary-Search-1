// Time Complexity : O(logn)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I have tried division by constant size subarray but it gave me an error. So, I have learned concept from youtube

class Main {

    public static int binarySearch(ArrayReader reader, int l, int r, int target) {

        // traverse for finding the target element
        while (l <= r) {
            // find the mid element
            int mid = (l + r) / 2;
            // if mid elemen is equal to our target element then we return mid index;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                // else if mid element is greater then target that means our target element may
                // be in first half of the array. So,
                r = mid - 1;
            } else {
                // else target element in second half of the array. So,
                l = mid + 1;
            }
        }

        // if array is not in our array we return -1
        return -1;
    }

    public int search(ArrayReader reader, int target) {

        // here we are going to find element in infinite array by dividing array into
        // subarary then use binary search
        // if we divide array in subarray by any constant number of elements then time
        // complexity still O(n) so we are going to use exponential division.

        // intially starting index of first divide is 0 to 1;
        int low = 0;
        int high = 1;

        // until we find element at high index greater then the target element we are
        // going to increase our subarray
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        // once we find our subarray where our element may be exist we use binary search
        // to find that element.
        return binarySearch(reader, low, high, target);
    }

    public static void main(String[] args) {

    }
}