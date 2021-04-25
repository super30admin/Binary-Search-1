package BinarySearch;

/*
  Time complexity : o(log n)
  Space complexity : o(n)
  Did this code run succesfully in leetcode : yes
  problems faces : no
  check if the target lies in the sorted side .if found then apply binay search to that side
  else move the pivot the opposite side and apply binary search again 
*/    
public class SearchRotatedSortedArray {
    
    public static void main(String[] args)
    {
        int[] inputArray = {5,1,2,3,4};
        int target = 5;
      int index =  search(inputArray,target);
      System.out.println("index : "+ index);
        
    }
    
     public static int search(int[] nums, int target) {
         int left =0, right =nums.length-1;
         int pivotIndex ;
         
        while(left<=right)
        {
            pivotIndex = left+ (right-left)/2;
            
           if(nums[pivotIndex] == target) 
           {
               return pivotIndex;
           }
           else if(nums[left] <= nums[pivotIndex]) //left array is sorted
            {
               if(nums[left] <= target && nums[pivotIndex] > target)
               {
                   right = pivotIndex-1;
               }
               else 
               {
                   left = pivotIndex+1;
               }
              
            }
           else if(nums[right] > nums[pivotIndex]) //right array is sorted
           {
                   if(nums[right]>= target && nums[pivotIndex]<target)
                   {
                       left = pivotIndex+1;
                   }
                   else
                   {
                       right=pivotIndex-1;
                   }
           }
        }
        return -1;
    }
    

}
