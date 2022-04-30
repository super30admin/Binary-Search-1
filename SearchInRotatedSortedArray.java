/*
## Problem2
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Time complexity: O(log(n))
Spacce complexity: O(1) No auxilary space needed to compute if target exists in the matrix
*/

class SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
            int pivot = findPivot(nums);
            
            int left = 0, right = nums.length - 1;;
           
            if(target >= nums[pivot] && target <= nums[right]){
                left = pivot;
                right = nums.length-1;
            }
            else if(target > nums[pivot] && target >= nums[left]){
                left = 0;
                right = pivot-1;
            }
            //System.out.println(left+" "+right+" "+pivot);
            return searchUpdated(nums, left, right, target);
        }
        
        private int searchUpdated(int nums[], int left, int right, int target){
            
            while(left <= right){
                int mid = left + (right - left)/2;
                
                if(nums[mid] == target) return mid;
                
                else if(nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            return -1;
        }
        
        private int findPivot(int nums[]){
            int left = 0;
            int right = nums.length - 1;
            
            while(left < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else right = mid;
            }
            return left;
        }
    }