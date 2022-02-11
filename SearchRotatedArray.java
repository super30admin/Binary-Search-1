//Time Complexity: O(n);
//Space Complexity: O(1);
//Code Run: Yes;

class Solution {
    int low, high, mid;
    
   
    public int search(int[] nums, int target) {
        
        low=0;
        high=nums.length-1;
        
        //What i am going to check is if:
        //my target lies in which range, if it lies in the sorted range of first half;
        // or if it lies in the sorted region of the next half;
        
        //How do i check which portion is sorted?
        //I will check the mid element with the high/low of the array;
        
        while(low<=high){
            mid= low+(high-low)/2; //to avaoid int overflow;
            if(target==nums[mid]){
                // System.out.println(target);
                return mid;
                }
               if(nums[low]<=nums[mid]){        
                   //Checking if fisrt is sorted and then checking the target element;
                 if(target>=nums[low] && target<nums[mid]){
                      high=mid-1;
                 }else{
                     low=mid+1;
                  }
                } else{     //nums<=high
//Checking if second half is sorted and then checking the target element;                   
                    if(target<=nums[high] && target>nums[mid]){
    
                            low=mid+1;
                        }else{
                            high=mid-1;
                        }
                    } 
        }
        return -1;
    }
}

//TC: O(m*n);
//Less Optimized check first and last element of each row and apply binary search on that row:
//So, TC: O(m+logn);
//Can perform Binary Search on first Coulumn to find the number range and to perform BSearch on that row;
//that way O(logM+logN);

//Brute Force Approach:
//Search each and every element iof the given 2D Matrix:
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }



