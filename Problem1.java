// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


//Approach
/*
Step 1: Get the starting index
first get the start of array before rotation by the binary search method by checking if the middle element is greater than the end element.
If so, then the binary search would narrow down to the right half else the left half. At the end we get the index of the starting element 
or the minimum element.

Step 2: Narrow down the search of target :
If the target lies between the start element and the end element, then apply binary search only to that part of the array.
Else apply binary search to the other half.

if the target element is not found, return -1.

*/

class Problem1 {
    public int search(int[] nums, int target) {
        if(nums ==null || nums.length == 0){
            return -1;
        }
        
        int left = 0;
        int right = nums.length-1;
        
        //Getting the index of the start element
        while(left<right){
            int middle = left + (right-left)/2;
            if(nums[middle]>nums[right]){
                left = middle+1;
            }else{
                right = middle;
            }
        }

        //narrowing down the search of the target 
        int start = left;
        left =0;
        right = nums.length-1;
        if(target>=nums[start] && target<=nums[right]){
            left = start;
        }else{
            right = start;
        }
        
        //applying binary serach 
        while(left<=right){
            int midpoint = left +(right-left)/2;
            if(target==nums[midpoint]){
                return midpoint;
            }else if(target > nums[midpoint]){
                left = midpoint+1;
            }else{
                right = midpoint-1;
            }
        }
        
        
        return -1;    
        
    }
}


class Main { 
    public static void main(String args[]) 
    { 
        SearchSolution s = new SearchSolution(); 
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums, target)); 
        target = 3;
        System.out.println(s.search(nums, target)); 

    } 
}