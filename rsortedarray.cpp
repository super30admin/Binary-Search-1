class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        // since its an array, size of the array minus one gives us the last index

        while (low < high ){
            int mid = low + (high - low)/2;
            if (nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){// left sorted array
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                    // move the high pointer a step down from mid
                }
                else{
                    low = mid + 1;
                    // move the low pointer a step up from mid
                }
            }
            else{// right sorted array
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                    // move the low pointer a step up from mid
                }
                else{
                    high = mid - 1;
                    // move the high pointer a step down from mid
                }
            }
        }
    
    if (nums[low] == target) return low ;
    //edge case where the low == high
    //can check with nums[low] or nums[high] doesnt make a difference
    return -1;
        
    }
};