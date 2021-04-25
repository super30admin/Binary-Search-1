// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class SearchUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        // initializing low and high
        int low=0, high=1;
        //while high index is valid
        while(reader.get(high)!=Integer.MAX_VALUE && target>reader.get(high)){
            low = high;
            high =2*high;
        }
        //call binary search
        return binarySearch(reader, target, low, high);
    }


    private int binarySearch(ArrayReader reader, int target, int low, int high){
        // while search space is valid
        if(low<=high){
            // get mid
            int mid = low+(high-low)/2;
            //if target found
            if(reader.get(mid)==target) return mid;
            // target on the left half
            else if(reader.get(mid)>target){
                high = mid-1;
            }//target on the right half
            else{
                low = mid+1;
            }
            return binarySearch(reader, target, low, high);
        }
        //if target not found
        return -1;

    }
}