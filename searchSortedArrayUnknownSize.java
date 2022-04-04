// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution{
    public int search(ArrayReader reader, int target){
        //initialize low and higher bounds
        int low=0, high=1;
        //as we dont have access to the array, we use array reader to get the elements
        while(reader.get(high)<target){
            low=high;
            high=2*high;
        }
        return binarySearch(reader, target, low, high);
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            //initialize midValue
            int midValue=low+(high-low)/2;
            //checking the midValue with the target
            if(reader.get(midValue)==target){
                return midValue;
            }
            else if(target<reader.get(midValue)){
                high=midValue-1;
            }
            else{
                low=midValue+1;
            }
        }
        return -1;
    }
}
