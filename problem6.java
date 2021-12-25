 class Solution {
    
    public int Binary_Pivot_Search(int [] nums,int len,int target){
        int pivot = Search_Pivot(nums,0,len-1);
        if(pivot == -1){
            return Binary_Search(nums, 0, len-1, target);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(nums[0]<=target){;
            return Binary_Search(nums, 0, pivot-1 , target);
        }
        return Binary_Search(nums, pivot+1, len-1, target);
        
    }

    public int Binary_Search(int [] nums,int low,int high,int target){
        if(low>high)
        {
            return -1;
        }
       
        int mid = (low + high)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid]<target) {
            return Binary_Search(nums, mid+1, high, target);}
        return Binary_Search(nums, low, mid-1, target);
    }

    public int Search_Pivot(int []nums, int low, int high){
        if(low>high){
            return -1;
        }
        if(high == low)
        {
            return low;
        }
        int mid = (low+high)/2;
        if(mid<high && nums[mid]>nums[mid+1]){
            return mid;
        }
        if(mid>low && nums[mid]<nums[mid-1]){
            return mid-1;
        }
        if(nums[low]>=nums[mid]){
            return Search_Pivot(nums, low,mid-1);
        }
        return Search_Pivot(nums, mid+1, high);  
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        return Binary_Pivot_Search(nums,len,target);
        
    }
}