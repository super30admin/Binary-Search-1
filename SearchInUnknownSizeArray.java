// Time Complexity :log(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:we took two pointer to find the contraint for applying binary search and then we find the index pf the target

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        
            while(reader.get(high)<target){
                low=high;
                high=high*2;
            }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)<target){
                low= mid+1;
            }
            else{
                high = mid-1;
            }
        }
      return -1;  
    }
}