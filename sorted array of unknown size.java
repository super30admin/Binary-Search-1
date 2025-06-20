// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no
class Solution{
    public int search(ArrayReader reader, int target){
        int low=0;
        int high=1;
        
        while(reader.get(high)< target){
            low=high;
            high=high*2; // Using exponential search method check untill high value is greater than or equal to target .
                        // untill that condition low will be high and high will be double of high.
                        // If the condition satisifies than binary search will be between the latest low and high
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(reader.get(mid)==target){
                return mid;
            } else if (reader.get(mid)> target || reader.get(mid)==Integer.MAX_VALUE){ //either mid value equal to out of boundary value or greater than target
                high=mid-1; // search in left side 
            } else{   // if above condition does not satisifies search in right side of mid 
                low=mid+1;
            }
            }
      return -1;
    }
}

