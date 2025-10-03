// Time Complexity : O(log n) where n is the index of the target value provided
// Space Complexity : O(1) as we do not use any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Search in a sorted array of unknown size
 * Approach: Boundary definition and binary search
 * 
 * In this approach, before applying binary search, we need to define boundaries for search space. We use a low and high
 * pointer to locate the target. Until the target falls within the range of [low, high], we keep increasing our search
 * space by setting the low pointer to high and doubling high. Once target falls in a specific [low, high] range, we
 * know that all elements are sorted in the range and we can apply binary search on that range to find the exact position
 * of target.
 */

 // This is ArrayReader's API interface.
 // You should not implement it, or speculate about its implementation
 interface ArrayReader {
      public int get(int index);
 }

public class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) <= target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = reader.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                // search in the right part
                low = mid + 1;
            } else {
                // search in the left part
                high = mid - 1;
            }
        }

        return -1;
    }
}


