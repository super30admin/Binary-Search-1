// TC: O(log(n))
// SC: O(1)
// Executed in leetcode: YES

// Approach:
//   Everytime we divide by mid, we will have two arrays. One is sorted and one is unsorted
//  Check target == mid 
//  Then, Check target exists in sorted part of the array by comparing nums[low] and nums[mid]
//  Otherwise check in unsorted array

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
        
//         int min = nums[0];
//         int min_index = 0;
//         int[] copy = new int[nums.length];
//         for (int i=0;i<nums.length;i++) {
//             if(nums[i] < min) {
//                 min = nums[i];
//                 min_index = i;
                
//             }
//         }
        
//         int initial = min_index;
        
        
//        if(min_index != 0) {
//             min_index = nums.length - min_index;
//             for(int i=0;i<nums.length;i++) {
//             copy[(i+min_index)%nums.length] = nums[i];
//             }
//        } else {
//             System.out.println("in else");
           
//             for(int i=0;i<nums.length;i++) {
//             copy[i] = nums[i];
//             }
//        }
        
//         for(int i=0;i<nums.length;i++) {
//             System.out.println(copy[i] +" " + i);
//         }
        
//         int low = 0;
//         int high = copy.length -1;
        
//         int value = searchMid(copy, low, high, target, initial);
//        return value;
//     }
    
//     public int searchMid(int[] num, int low, int high, int target, int minI) {

//         int mid = (low + high)/2;
        
//         if(low <= high) {
//         if(num[mid] == target) {
//            if(minI+mid >= num.length) {
//                return (minI+mid)%num.length;
//            } else {
//                return minI+mid;
//            }
//         } else if(num[mid] > target) {
//             return searchMid(num, low, mid-1, target, minI);
//         } else if(num[mid] < target){
//             return searchMid(num, mid+1, high, target, minI);
//         }
           
//         }
        
//         return -1;
    } 
}
