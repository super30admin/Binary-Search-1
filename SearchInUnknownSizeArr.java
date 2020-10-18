// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this :

public class SearchInUnknownSizeArr {
    public int search(ArrayReader reader, int target) {
        int low =0;
        int high = 1;

        while(reader.get(high) < target){
            low = high;
            high = high*2;
        }

        return binarySearch (reader, low, high, target);
    }

    public int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid +1;
            }

        }
        return -1;
    }
}
