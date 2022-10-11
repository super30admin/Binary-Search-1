// Time Complexity : O(log n)  n=size of window
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int l = 0;
        int h = 10;
        
        //need to fix low and high bounds
        
        while (target > reader.get(h)) {
            l = h + 1;
            h = h * 2;
        }
        
        while (l <= h) {
            int mid = l + (h-l)/2;
            
            if(reader.get(mid) == target) return mid;
            
            if (reader.get(mid) > target) {
                //left side
                h = mid -1;
            } else {
                l = mid + 1;
            }
        }
        
        return -1;
    }
};
