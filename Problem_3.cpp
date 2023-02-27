162. Find Peak Element


TC O(logn) 
SC O(1)


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int low = 0;
        int high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if (((mid == 0) || nums[mid] > nums[mid-1]) && ((mid == n-1) || nums[mid] > nums[mid+1])) {
                return mid;
            } else if ((mid > 0) && (nums[mid-1] > nums[mid])) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return 5353;
    }
};
