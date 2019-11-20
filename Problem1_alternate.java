//Problem 1 (Alternative Approach)
//Time Complexity : O(logN) 
//          Pivot = index where rotation happened = MAX ELEMENT ARRAY - 1
// Space Complexity : O(N)
//Did this code run successfully on Leetcode : YES
//Any problem : I think the optimal solution will be finding maximum of the array and then call BST checking where mid element will lie wrt to key and the maximum value i.e. (pivot - 1). 


class Solution {    
    int search_bst(int[] in,int l, int r,int pivot, int key){
        int mid = (l + r)/2;
        if(in[mid] == key)
            return mid;
            
            if(l<r){
            if(mid < pivot){
                if(in[mid] < key){
                    return search_bst(in,mid + 1,pivot, pivot, key);
                }else {
                    if(in[l] > key){
                        return search_bst(in,pivot + 1,r,pivot,key);
                    }else{
                        return search_bst(in,l,pivot-1,pivot, key);
                    }
                }
            }else if(mid > pivot){
                if(in[mid] >= key){  
                    return search_bst(in,pivot+1,mid-1, pivot, key);
                }else {
                    if(in[r] > key){
                    return search_bst(in,pivot + 1,r-1,pivot,key);        
                    }else{
                    
                    return search_bst(in,l,pivot,pivot,key);           
                    }
                }   
            }else{
                if(in[mid] < key){
                    return -1;
                }else{
                    if(in[l]  > key){
                        return search_bst(in,pivot+1,r,pivot,key);
                    }else{
                        return search_bst(in,l,pivot,pivot,key);
                    }
                }
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
            
        
        //Identify pivot element
        int check = nums[0];
        int pivot;
        for(pivot=0; pivot < nums.length; pivot++){
            if(check <= nums[pivot]){
                check = nums[pivot];
                continue;
            }
            break;
        }
        pivot = pivot - 1;
        return(search_bst(nums,left,right,pivot,target));
    }
}

