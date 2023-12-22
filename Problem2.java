//Executed on leetcode
//The idea i had was to somehow find the pivot around whihc the rotation is done so as to make it balanced array with one side smaller and one side larger but i failed than what i thought was just to apply binary search and play with inequalities and yep it worked.
//Time O(mxn)

class Solution {
    public int search(int[] nums, int target) {
        int idx = bs(nums,0,nums.length-1,target);
        return idx;

        
    }

    int bs(int[] nums,int l,int h,int x){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==x){
                return mid;
            }
            else if(nums[mid]>x){
                if(nums[l]>x && nums[mid]>=nums[l]){
                    l=mid+1;

                }
                else{
                    h = mid-1;
                }

            }
            else if(nums[mid]<x){
                if(nums[mid]<nums[h] && nums[h]<x){
                    h=mid-1;
                }
                else{
                  l=mid+1;
                }

            }
        }
        return -1;
    }

}