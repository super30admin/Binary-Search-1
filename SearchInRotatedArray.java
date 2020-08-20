// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
 
 class  SearchInRotatedArray {
    public int search(int[] nums, int target) {
       //1
        int low=0; 
        int high=nums.length-1;
        
        //2
        while(low<=high){
            int mid=(low+high)/2;

            //3
            //If the target is found at the mid index then we return the mid value.
            if(target==nums[mid]) return mid;
            
            //4
            //Check if the right part of the array is sorted.
            if(nums[mid]<=nums[high]){
                //Also check if the target lies in the right part of the array
                if(nums[mid]<target && target<=nums[high])
                     low=mid+1;
                else  high=mid-1;
            }

            //5
            //Check if left part of the array is sorted or not.
            else{
                //Check if the target lies in the left part of array.
                if(target >= nums[low] && target<nums[mid] )
                     high=mid-1;
                else  low=mid+1;
            }
            
            
        }
        //If target is not found then return -1;
        return -1;       
        
        
    }


    public static void main(String args[]){

        SearchInRotatedArray obj=new SearchInRotatedArray();
        int nums[] = {4,5,6,7,0,1,2};
        int target = 6;      
        

        int index=obj.search(nums,target);
        if(index>=0)
        System.out.println("Target found at index: "+index);
        else
        System.out.println("Target not found");

    }
}