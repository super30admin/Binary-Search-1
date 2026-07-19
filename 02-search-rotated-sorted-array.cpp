/*
TC - O(log(n)) - since we perform binary search and at any time always discard a half of the array basis the comparison logic
SC - O(1) - no additional space utilised
Issues Faced - have seen this problem before, but once again I was not able to realize that having a sorted half means you can O(1) check if the target is in that range or not. Pretty disappointing but I hope to improve next time.
Solved on Leetcode - yes


*/



class Solution {
    public:
        int search(vector<int>& nums, int target) {
    
            int n = nums.size();
            int lo = 0;
            int hi = nums.size() - 1;
    
            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
    
                if (nums[mid] == target) {
                    return mid;
                }
    
                if (nums[mid] >= nums[lo]) { //this left half is normally sorted 
                    if (target >= nums[lo] && target <= nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else if (nums[mid] <= nums[lo]) { //the right half is normally sorted 
                    if (target >= nums[mid] && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
    
            return -1;
            
        }
    };
