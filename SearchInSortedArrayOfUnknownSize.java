// Time Complexity : O(log(n)) Binary search applied for searching the element in array
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int index = 1;
        while(reader.get(index) < target) {
            index = index *2; // exponentially increase the size of index
        }
        int low = index / 2; // half the index because target can be between low and index
        int high = index;

        //same like previous
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;

    }
}
