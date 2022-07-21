// Time Complexity :0(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

//implement binary search, take 0 index as low and 1 index as high increment the high = high*2 till target value is greater than high value
//then apply normal binary search

class Solution {
    public int search(ArrayReader reader, int target) {
        int low =0;
        int high =1;
        while(target > reader.get(high)){
            low=high;
            high = high*2 ; 
        }
        while(low<=high){
            int mid =low+ (high-low)/2;
             int temp=reader.get(mid);
            if(temp== target){
                return mid;
            }
            else if(temp<target){
             low = mid +1;
            }
            else{
            high= mid-1;
            }
        
        }
        return -1;
        
    }
}