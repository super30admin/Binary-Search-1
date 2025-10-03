// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :no (premium question) 
// Any problem you faced while coding this :no


// Increment low and high until reaching target range. Then do binary search in that range. 

class Solution {

    public int search(ArrayReader reader, int target) {
        int low, mid, high;
        low = 0;
        high = 1;

        while(reader.get(high) < target){ //increment low and high until we reach the range of target by doubling high
            low = high ;
            high = 2*high;
        }

        while(low <= high){ 
            mid = low + (high - low)/2;
            if(reader.get(mid) == target) { //found target in mid
                return mid;
            }
            if(reader.get(mid) > target){ //search in left side
                high = mid - 1;
            }
            else{//search in right side
                low = mid + 1;
            }
        }
      
        return -1;//not found
    }
}