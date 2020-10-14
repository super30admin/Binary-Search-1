/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

/**
 *
 * @author Samartha_Swaroop
 */
public class Solution {
public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length-1, target);
}
 
public int binarySearch(int[] nums, int left, int right, int target){
    if(left>right) 
        return -1;
 
    int mid = left + (right-left)/2;
 
    if(target == nums[mid])
        return mid;
 
    if(nums[left] <= nums[mid]){
        if(nums[left]<=target && target<nums[mid]){
          return binarySearch(nums,left, mid-1, target);
        }else{
          return  binarySearch(nums, mid+1, right, target);
        }
    }else {
        if(nums[mid]<target&& target<=nums[right]){
          return  binarySearch(nums,mid+1, right, target);
        }else{
          return  binarySearch(nums, left, mid-1, target);
        }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
