import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;

/*
 * Leetcode 702: (Medium) Given an Integer array sorted in ascending order,
 * write a function to search target in nums if Target exists return -1. However
 * the
 * array size is unknown. Only access the array using ArrayReader.get from
 * ArrayReader intercface.
 * ArrayReader.get(k) return the element of he array at Index k.
 * You may assume all integers in the array are less than 10000 and
 * if you access the array out of bounds; ArrayReader.get(k) will return the
 * 2147483647.
 * 
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE)
            return -1;

        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;

            else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}