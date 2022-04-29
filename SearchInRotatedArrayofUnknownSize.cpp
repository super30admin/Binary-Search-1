// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//We keep the start=0 and end= 9999 and perform binary search on the array since we dont know the size
// And utilize the reader function to get the values

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        
        int start = 0;
        int end = 9999;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return -1;
    }
};
