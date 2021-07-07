// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    defining boundary size

// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        //first element is target
        if(reader.get(0)==target)return 0;
        int start=0,end=1;
        
        //select a boundary 
        while(reader.get(end) < target){
            end=end*2;
        }
        //binary search over boundary 
        while(start<=end){
            int mid = (start+end)/2;
             if(reader.get(mid) == target){
                 return mid;
             } else if(reader.get(mid)>target) {
                 end = mid-1;
             } else {
                 start = mid+1;
             }
        }
        return -1;
         
    }
}


        