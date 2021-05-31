class Solution {
public:
    //shortened the code as per discussed by sir, my previous used to work, but it was un-necessarily long
    int search(vector<int>& nums, int target) {
        if(nums.size()==0) return -1;
        int low = 0, high = nums.size()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid]){//left is sorted
                if(nums[low]<= target && nums[mid]>target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }                
            }
            else{//right is sorted
                 if(nums[mid]< target && nums[high]>=target){
                     low = mid+1;
                 }else{
                     high = mid-1;
                 }
            }   
        }
         return -1;
    }
};
