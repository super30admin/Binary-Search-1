// Time Complexity : O(log n)
// Space Complexity : O(1)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Increase the high by 2 times everytime target is greater than high
//2. Do binary search on new found length
//3.
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low =0;
        int high = 1; 
        while(reader.get(high) < target){
           low=high; high = 2*high;
        }
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid-1;
            }else{
                low =mid+1;
            }
        }
        return -1;
    }
};
