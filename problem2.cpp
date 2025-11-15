// We will caluculate mid, check if mid = target, if not check white part is sorted then check if target lies in left or right sorted part,
//then checking if target lies in between and updating the search array.

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        

        while (low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>=nums[low]){
                // left sorted
                if(nums[low]<=target && nums[mid]>target){
                    high = mid;                          

                }
                else{
                    low = mid + 1;
                }
            }else{
                // right sorted
                if(nums[mid]<target && nums[high]>=target){
                    low = mid + 1;
                   
                }
                else{
                    high = mid;

                }

            }

        }
        
        return -1;
    }


        
    
};