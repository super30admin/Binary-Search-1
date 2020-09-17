// Class Solved
class Solution { // O(log n )
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid ;
        
        if(nums.length == 0){// if array is empty
            return -1;
        }
        while (left<= right){ // 
            mid = left + (right - left)/2 ;
            if(nums[mid]== target) return mid ; // already found at mid index
            
            if(nums[left]<= nums[mid]){ // check if left side is sorted
                if(target>= nums[left] && target < nums[mid]){// searching inside left
                    right = mid - 1;
                }else{ // target not in left so check right
                    left = mid + 1 ;
                }
            }else{
                if(target<=nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1 ;
                }
                
            }
        }
        return -1;    
    } 
   
}