/*Leetcode 33: Search in Rotated Sorted Array*/ 
class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int[] array = nums;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(target == array[mid]){
                return mid;
            }
            
            if(array[mid]>= array[start]){
//                 sorted
                if(target < array[mid] && target >= array[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target > array[mid] && target <= array[end]){
                    start = mid + 1;
                }else{
                    end = mid -1; 
                }
            
            }
        }
        return -1;
    }
}