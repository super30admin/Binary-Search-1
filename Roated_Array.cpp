class Solution {
public:
    int search(vector<int>& nums, int target) {


        int mid;

            int right = nums.size()-1;
            int left = 0;
        


        while(left<=right){

            mid = (left+right)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>= nums[left]){
                if(nums[mid]>=target && target>=nums[left]){
                right = mid-1;
                }
                else{
                left = mid+1;
                }
            }

            else
            {
                if(target>= nums[mid] && target<= nums[right])
                {
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }


        }
        return -1;

    }
};