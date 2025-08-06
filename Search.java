//since we are not using any extra space space complexity is O(1) and only space we are using is for variables which runs in O(1)
//time complexity is O(logn) since at each iteration we are reducing the search space by half
//approach is since the array is rotated sorted array irrespective of the no. of rotations at any iteration one of the half's of the array is sorted. based on this property we are checkiing for sorted part and cheching is the element would be present. if not we do the same to the other half

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)return mid;
            if(nums[low]<=nums[mid]){//left sorted array
                //checking to see if the target falls under range
                if(nums[low]<=target && nums[mid]>target){
                    high=mid-1;
                }
                else low=mid+1;
            }else{ //right sorted array
             //checking to see if the target falls under range
             if(nums[mid]<target && nums[high]>=target){
                low=mid+1;
             }else high=mid-1;
            }
        }
        return -1;
       }
        
    }

