//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int left=0;
        int right=nums.size()-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]==target){   //If the element is equal to target, return mid
                return mid;
            }
            else if(nums[mid]>=nums[left]){                         //If the array is sorted from left to mid
                if(target<=nums[mid] && target>=nums[left])         //If target lies between left and mid, update right
                    right=mid-1;                                   
                else
                    left=mid+1;                                     //Otherwise update left
            }
            else{                                                   //If the array is sorted from mid to right
                if(target>=nums[mid] && target<=nums[right])
                    left=mid+1;                                     //If target lies between left and mid, update left
                else
                    right=mid-1;                                    //Otherwise update right
            }
        }
        return -1;
    }
};