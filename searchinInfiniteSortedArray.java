
    /*  Explanation
    Time Complexity for operators : log(n) + log(n) = log(n) 
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    The implemntation consists dividing array and find the element. Once element is found traverse till left most
    of the element and same for right side.
    */

public class searchinInfiniteSortedArray{


    public static void main(String args[]){
            int arr[] = new int[]{5,7,7,8,8,10};
            int arr1[] = searchRange(arr,8);
            System.out.println(arr1[0]);
            System.out.println(arr1[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = traverseLeft(nums,target);
        int right = traverseRight(nums,target);
           
        return new int[]{left,right};
    }
   
    public static int traverseLeft(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
       
        while(low <= high){
            int mid = low + (high-low)/2;
           
            if(nums[mid] == target){
                if(mid==low || nums[mid-1]!=target){
                    return mid;
                }
                high = mid-1;
            }else if(nums[mid]>target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
       
        return -1;
    }
   
        public static int traverseRight(int[] nums,int target){
            int low = 0;
            int high = nums.length-1;

            while(low <= high){
                int mid = low + (high-low)/2;

                if(nums[mid] == target){
                    if(mid==high || nums[mid+1]!=target){
                        return mid;
                    }
                    low = mid+1;
                }else if(nums[mid]>target){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }
       
        return -1;
    }
}