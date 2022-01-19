// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Writing for all conditions took time.

class Solution {
    public int search(int[] nums, int target) {
        
        int f= 0;
        int l=nums.length-1;
        int m=(f+l)/2;
        if(l==-1)
            return -1;
        return sort(f,m,l,nums,target);
    }
    public int sort(int f, int m, int l, int[] nums, int target){
        
        if(target==nums[f])
            return f;
        else if(target==nums[m])
            return m;
        else if(target==nums[l])
            return l;
        if(l-f<=2)
            return -1;
        //System.out.println("dfs"+ f+" "+ m+" "+ l );
         if(nums[f]<nums[m] && (target>nums[f] && target<nums[m])){
            return sort(f,(f+m)/2,m, nums,  target);
        }
        else if(nums[f]>nums[m] && (target>nums[f]  && target>nums[m])){
            return sort(f,(f+m)/2,m, nums, target);
        }
        else if(nums[f]>nums[m] && (target<nums[f] && target<nums[m])){
            return sort(f,(f+m)/2,m,nums, target);
        }
        else if(nums[f]>nums[m] && (target<nums[f] && target>nums[m])){
            return sort(m+1,(l+m+1)/2,l,  nums, target);
        }
        else if(nums[f]<nums[m] && (target<nums[f] )){
            return sort(m+1,(l+m+1)/2,l,  nums, target);
        }
        else if(nums[f]<nums[m] && (target>nums[m] )){
            return sort(m+1,(l+m+1)/2,l,  nums, target);
        }
        else
        return -1;
    }
}