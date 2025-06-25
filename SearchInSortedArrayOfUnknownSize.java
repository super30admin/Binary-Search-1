// Time Complexity : O(log n) 
    // There are two operations that we are performing here, each operation is taking logn time so overall time is 2logn -> logn
    // First operation skips an element and iterates over the array to determine the high
        //even if we had to iterate through the entire array, we would have skipped checking half of the elements so the time is logn.
    // Second Operation perform the search between low and high
// Space Complexity : O(1) no additional space is required
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //Very interesting and intutive problem.
    


//Your code here along with comments explaining your approach in three sentences only



class Solution {
    public int search(ArrayReader reader, int target) {
        
        //things that we know:
        //1. array is sorted
        //2. needs to access via an interface ArrayReader.get(i)
        //3. if the index is out of bounds then return an infinity, meaning we hit the out bounds.
        
        //Approach:
        //initialize low to 0 and high to 1, check the base case if either of these is target
        //while the value at high does not hit infinity and high < target, multiple high by 2
        //to reduce the search space even more, we set low to high then update the value for high.
        //loop exists if either of the condition is false. We determined our lower and higher bound.
        //then perform normal binary search to find the target.
        
        //initialize low and high
        int low = 0;
        int high = 1;
        double outOfBoundValue = Math.pow(2, 31) - 1;

        //base case
        if(reader.get(low)==target){
            return low;
        }
        if(reader.get(high) == target){
            return high;
        }

        //determine the high
        while(reader.get(high) != outOfBoundValue && reader.get(high) < target){
            high = high * 2;
        }
        
        //check if the value at high is target
        if(reader.get(high) == target){
            return high;
        }

        while(low <= high){
            //get mid
            int mid = low + (high - low) / 2;

            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }


        return -1;

    }
}