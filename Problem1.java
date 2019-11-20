//Time Complexity : O(2 * logN) + O(N - Pivot) 
//          Pivot = index where rotation happened
// Space Complexity : O(N)
//Did this code run successfully on Leetcode : YES
//Any problem : I think the optimal solution will be finding maximum of the array and //then assign next index of maximum as left and we need to call Binary search only //once moving left and right accordingly. This is where i struggle moving left and right wrt to max Element and mid element of the Binary Search.


class Solution {    
    int search_bst(int[] in,int l, int r, int key){
     int mid = (int) Math.floor((l + r)/2);
        if(l > r)
            return -1;

        if(in[mid] == key)
            return mid;
        if(l < r){
            
            if(in[mid] > key) {
            return search_bst(in,l,mid,key);
        }else {
            return search_bst(in,mid + 1,r,key);
        }
    }
        return -1;
        
        
    }
        
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums.length == 0)
            return -1;
        
        if(nums.length == 1 && nums[0] == target)
            return 0;
            
        
        int check = nums[0];
        int i =0;
        for(i=0; i< nums.length; i++){
            if(check <= nums[i]){
                check = nums[i];
                continue;
            }
            break;
        }
             return(Math.max(search_bst(nums,left,i-1,target),search_bst(nums,i,right,target)));   
    }
}
