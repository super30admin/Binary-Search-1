/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    public int infiniteBinarySearch(int[] nums, int target){
        
        int low = 0;
        int high = 1;
        
        while(target >= nums[high]){
            low = high;
            high = high * 2;
        }
        
        while(low <= high){
             int mid = low + (high - low)/2;
                
                if(nums[mid] == target){
                    return mid;
                }else if(target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            
        }
        
        return -1;
    }
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		int nums[] = {1, 2, 4, 6, 8, 9, 12, 22, 34, 56, 90, 89, 78, 789, 900};
		GFG gfg = new GFG();
		System.out.println(gfg.infiniteBinarySearch(nums, 12));
	}
}