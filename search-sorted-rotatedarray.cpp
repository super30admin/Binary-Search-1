// Time Complexity : O(log n): as we are not looking at n elements and reducing the number of elements searching everytime
// Space Complexity : O(1) havent used any extra space for performing the operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yeah, first submit in the code it used target <= high instead of using target <= nums[high],
// that issue passed the basic test cases few on submit it failed 5 testcases then figured out what mistake i made


// Leetcode(33): https://leetcode.com/problems/search-in-rotated-sorted-array/
/*Approach:
whole idea is: identify the sorted arrays and check if target falls in that range or skip that to the same on the other side by using binary search
if you find a left sorted array: then look that the target is in that range if yes do binary search to find it
if not move the low to mid + 1 ( which is ignoring that sorted array and looking in the right )
Same as above if you end up in right sorted array: if your target is the range if no, ignore that right sorted and shilt the high to mid - 1 and perform a binary search

*/
#include<iostream>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1; // mid = low + (high-low)/2 to avoid int overflow
        
        //binary search
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){ 
                return mid;
            }
            //finding if it's a left sorted array
            if(nums[mid] >= nums[low]){

                //find if your target is in the range of mid and low then move your high to mid - 1 which only searches in left sorted array
                if(target >= nums[low] && target < nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid + 1;//move search to right 
                }
            }
            else{
                //right sorted
                //now find if your target is in between the mid and high value and make your low as mid + 1 as your target is in the right sorted array
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    //move search to left
                    high = mid - 1;
                }
            }
        }
        return -1;//target not found
        } 
};