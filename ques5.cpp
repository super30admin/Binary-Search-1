Time Complexity- O(log n)
Space Complexity-O(n)
Did the code run successfully on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==0)
        {
            return -1;
        }
        int left=0;
        int right=nums.size()-1;
        while(left<right)
        {
            int midpoint=left+(right-left)/2;
            if(nums[right]<nums[midpoint])
            {
                left=midpoint+1;
            }
            else
            {
                right=midpoint;
            }
        }
        int start=left;
        left=0;
        right=nums.size()-1;
        if(target<=nums[right] && target>=nums[start])
        {
            left=start;
        }
        else
        {
            right=start;
        }
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(target>nums[mid])
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return -1;
    }
};

int main(){
    vector<int>nums={4,5,6,7,0,1,2};
    Solution soln;
    cout<<soln.search(nums,1);
}
