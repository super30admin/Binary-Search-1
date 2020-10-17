// Time Complexity : O(log N)+log(M) where N is total elements in the array
// and M < N ie M is max elements in the binary single iteration for worst case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
interface ArrayReader {
    public int get(int index);
}

public class SearchInSortedArrayUnkownSize {

    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;

        int low=0, high = 1;
        while(reader.get(high)<target){
            low=high;
            high= high*2;
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }
}