class Solution {
public:
    int search(vector<int>& nums, int target) 
    {
         int low = 0, high ;

    //find the range
    while (nums[high] < high) {
        low = high;
        high = high*2;
    }

    //binary search
    while(low<=high)
    {
        int mid = low + (low + high) / 2;

        if(nums[mid] == target) return mid;
        else if(nums[mid] > target)
        {
            high = mid -1;
        }
        else
        {
            low = mid +1;
        }
    }
        
    return -1;
    }
};