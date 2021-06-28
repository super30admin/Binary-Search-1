// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class sortedunknown {
    
    public int search(ArrayReader reader, int target){

        int low = 0, high = 1;

        while(reader.get(high) <= target){
            low = high;
            high = high * 2;

        }
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low) / 2;

            //base case if the middle is the target
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                //move left
                high = mid - 1;
            }
            else{
                //move to the right
                low = mid + 1;
            }
            return -1;
        }
    }
}
