// Time Complexity : O(log n + log k), where n is the number of times the first while loop runs and k is the number of elements on which binary search is done at the end
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution{
    public int search(ArrayReader reader, int target){
        int low = 0; //low will point to the element at 0th index initially
        int high = 1; //high will point to the element at the 1st index initially
        while(reader.get(high) < target){ //As long as the element the 'high' index is less than target
            low = high; //Shift low to high index
            high = 2 * high; //Double the index of high
        }
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low) / 2; //Calculated this way to avoid integer overflow
            if(reader.get(mid) == target) //If the element at mid position is the target
                return mid;
            else if(reader.get(mid) > target) //If target is less than the mid element
                high = mid - 1; //Shift high to the left of mid if target is less than mid
            else
                low = mid + 1; //Shift low to the right of mid if the target is greater than mid
        }
        return -1; //Target not found
    }
}