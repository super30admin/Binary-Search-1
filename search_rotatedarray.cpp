// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :if(l<=r) condition in binary search forgot to write
// and in left sorted checking arr[low]<= target && target <=arr[mid - 1] --not possible if only one element left 
//we can just write like target < arr[mid];


// Your code here along with comments explaining your approach in three sentences only
// calculate min
//atleast oneside of min is sorted 
//if arr[low] <= arr[mid] then left side is sorted go to left side and check if it is possible then do binary search 
//if not possible then got to right side and check like this only 

//if left side is not sorted then right side is sorted

#include <iostream>
#include <vector>
using namespace std;

class Solution {
    private:
        int binarysearch(vector<int>& nums, int low, int high, int target){
            while(low <= high){ //checking condition 
                int mid = low + ((high-low)/2); // calculating mid
                if(nums[mid] == target){ //if mid element is target return
                    return mid;
                }
                //atleast oneside is sorted 
                if(nums[low] <= nums[mid]){ //then left side is sorted 
                    if(nums[low] <= target && target <= nums[mid]){// then do sorting in left side 
                    high = mid -1;//O(logn) time complexity 
                    }
                    else{// if not go to right side 
                        low = mid + 1;
                    }
                }
                else{//right side is sorted 
                    if(nums[mid+1] <= target && target <= nums[high]){ //do sorting on right side 
                        low = mid + 1;
                    }
                    else{ //if not do it in left side 
                        high = mid -1;
                    }
    
                }
            }
            return -1; // as low became high target is not there 
            
        }
    public:
        int search(vector<int>& nums, int target) {
            int size = nums.size(); //calculating size of array if size is 5 then high is 4
            return binarysearch(nums, 0, size-1, target);
        }
    };