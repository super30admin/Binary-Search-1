/*
Time: O(logN) where N=length of the array
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class SearchInfiniteArray {

    public int search(ArrayReader reader, int target) {

        int left = 0;
        int right = 1;

        // Keep moving 'left' and 'right' until we find the correct window
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);

            if (target == midValue)
                return mid;

            else if (target < midValue)
                right = mid - 1;

            else if (target > midValue)
                left = mid + 1;

        }
        return -1;
    }

}
