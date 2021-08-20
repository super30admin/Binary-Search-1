// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class searchUnknownSortedArray {
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        //range setter
        while(reader.get(low) < target){
            low = high;
            high = high*2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
