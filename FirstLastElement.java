//TC=O(2logn)
//SC=0(1)

class Solution {
    
    private int getStartPos(int[] nums, int target){
        int s=0, e=nums.length-1;
    while(s<=e){
        // we will find target first and then the starting position of the target
        int m=s+(e-s)/2; 
        
        if(nums[m]==target){
            if(m==0 || nums[m-1]!=target){ // if previous element is also target or                                          //mid is the first element
                return m;   
            }
            else{
                e=m-1; // we are going towards left
            }
        }
        else if (target<nums[m]){
            e=m-1;  //moving towards left
        }
        else{
            s=m+1; // moving towards right
        }
    }
        return -1;
    }
    
    private int getEndPos(int[] nums, int target, int s){
        // we will find target first and then the ending position of the target
        
        if(s==-1){
            return -1;
        }
        int e=nums.length-1;
        
        while(s<=e){
        // we will find target first and then the starting position of the target
        int m=s+(e-s)/2; 
        
        if(nums[m]==target){
            if(m==nums.length-1 || nums[m+1]!=target){ // if next element also is                                             //target or mid is  the last element
                return m;   
            }
            else{
                s=m+1; // we are going towards left
            }
        }
        else if (target<nums[m]){
            e=m-1;  //moving towards left
        }
        else{
            s=m+1; // moving towards right
        }
    }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int startPos= getStartPos(nums, target);
        int endPos= getEndPos(nums,target, startPos); //narrowing the search space                                                          //using startpos
        return new int[]{startPos, endPos};
    }
}