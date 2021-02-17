// The array reader inferface gives us an element at a particular index.
// The first school of though is starting from 0, increment the index by one and get the elements. 
// When you find the element, return the index. This will take O(n) time. 

// What we can do is find left and right bowndaries within which the target is present and then search only between that boundary. 
// At each point multiply the index with 2 to increment the boundary

// Time Complexity : O(lon n), where n is the index where target is present
// Space Complexity : O(1)

public class SearchInSortedArrUnknownSize {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target)
            return 0;

        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        int mid, n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            n = reader.get(mid);

            if (n == target)
                return mid;
            else if (n > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
