// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;
        
        while(target >= reader.get(high)){
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, target, low, high);
        
    }
    int binarySearch(const ArrayReader& reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target == reader.get(mid)){
                return mid;
            }
            else if(target < reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
};
