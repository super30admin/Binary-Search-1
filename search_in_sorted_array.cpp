// Time Complexity : O(logn)
// Space Complexity : O(logn) //stack space
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Find the sorted region and whether the target is present in the sorted region.
//2. If the target is not present explore unsorted region in both the cases.
//3. If the target is not found return -1.

class Solution {
public:
    int search(vector<int>& nums, int target) {
        //edge
        if(nums.size()==0){
            return -1;
        }
        //recurse
        int size = nums.size();
        return bin_search(nums, 0, size-1, size, target);
    }
    
    int bin_search(vector<int> & nums, int low, int high, int& size,int target){
     int result =-1;
        if(low<=high){
            int mid = low +(high-low)/2;
            //perfect match
            if(nums[mid] == target){
                return mid;
            }
            
            //sorted region
            if(nums[mid] >= nums[low] && target>=nums[low] && target<nums[mid]){
               result =  bin_search(nums, low, mid-1, size, target);
                return result;
            }else if(nums[mid] < nums[high] && target>nums[mid] && target<=nums[high]){ 
                 result = bin_search(nums, mid+1, high, size, target);
                return result;
            }else{ //unsorted region
                result = bin_search(nums,mid+1, high, size, target);
                if(result==-1)
                    result =bin_search(nums, low, mid-1, size, target);
                return result;
            }
        }
        
       return result;
    }
};
