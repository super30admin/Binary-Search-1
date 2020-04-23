//Both solutions working fine

//Rotated Sorted Array
//Time Complexity o(log n)
// Space Complexity o(1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target)
                return mid;
            //left part sorted
            if(nums[low] <= nums[mid])
            {
                if(nums[low]<=target && nums[mid]>=target)
                    high = mid -1;
                else
                    low = mid + 1;
            }
            else{
                if(nums[mid]<=target && nums[high]>=target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
        
    }
}

//Search in infinite sorted array
//Time complexity o(n)
// space complexity o(1)
class InfiniteSortedArraySearch{

    public static void main(String []args){
       int[] arr ={1,3,4,6,7,9,11,13,15,16,17,19,21,22,24,27,28};
       int target = 11;
       int idx = modifiedBinarySearch(arr,target);
       System.out.println("index of target: "+ idx);
    }
    
    public static int modifiedBinarySearch(int[] arr, int target){
        int low=0,high=1;
        while(arr[high]<target)
        {
            low=high;
            high=high*2;
        }
        return BinarySearch(arr,low,high,target);
    }
    
    public static int BinarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
           int mid = low + (high-low)/2;
           if(arr[mid] == target)
               return mid;
           else if(arr[mid]>target)
               high = mid-1;
           else
               low = mid+1;
        }
        return -1;
    }
}

