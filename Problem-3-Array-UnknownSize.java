/*
 * Searches for a target in a sorted array of unknown size using ArrayReader.
 * 1. First expands the search bounds exponentially until reader.get(h) >= target.
 * 2. Then performs binary search within the identified bounds.

 * - search(): expands range using h = 2*h until the value at h exceeds target.
 * - binarySearch(): standard binary search using reader.get(mid) within [l, h].
 */

// Time Complexity : O(log T) - Performed in range [l, h], which is at most size 2T
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 1;
        // Expand the search range exponentially until reader.get(h) >= target
        while (reader.get(h) < target) {
            l = h;
            h = 2 * h;
        }
        return binarySearch(reader, target, l, h);
    }

    public int binarySearch(ArrayReader reader, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // If target is found at mid
            if (reader.get(mid) == target) {
                return mid;
            }
            // If value at mid is greater than target, search left half
            else if (reader.get(mid) > target) {
                r = mid - 1;
            }
            // If value at mid is less than target, search right half
            else {
                l = mid + 1;
            }
        }
        // Target not found
        return -1;
    }
}

