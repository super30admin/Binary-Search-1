// Time Complexity :    O(Logn)
// Space Complexity :  0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//first, for getting the high index i moved the high pointer by 2x and compared with target (max 32 checks)
//then found the mid compared with target, based on it eleminated one half


class Solution {
    public int search(ArrayReader reader, int target) {
       int low=0,high=1;
       while(!(reader.get(high)>=target) ){
        low=high;
        high = 2*high;
       }
       while(low<=high){
          int mid=low+(high-low)/2;
          if(reader.get(mid)==target)return mid;
          if(reader.get(mid)>target){
            high=mid-1;
          }else{
            low=mid+1;
          }
       } 
       return -1;
    }
}