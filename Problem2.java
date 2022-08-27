// Time Complexity : O(log(n) + log(m)) n is the search space for binary search and m is the number of steps taken every time
// Space Complexity : O(1) , constant
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


public class Problem2 {

    public int search(ArrayReader reader, int target){

        int low =0;
        int high = 1;

        while(reader.get(high) <target){
            //moving two indexes to reduce the search space
            low = high;
            high = 2*high;

        }

        //binary search
        while(low <=high){

            //to avoid integer overflow
            int mid = low + (high-low)/2;

            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;

    }
}
