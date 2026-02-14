// 702. Search in a Sorted Array of Unknown Size
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// 

// Your code here along with comments explaining your approach in three sentences only

//Approach 
// 1) no fixed length given in this
// 2) find the range of search 
// 3) Search using binary searchx
// 4) return if found the target 

public class BinarySearch3 {
	ppublic int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target)
                return mid;
            else if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}