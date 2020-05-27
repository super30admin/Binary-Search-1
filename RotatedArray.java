class Solution {
    public int search(int[] nums, int target) {
        
        //1.Define low and high
        //2.find mid//barrier
        //3. find which side is sorted
        //4.do binary search on that side 
        int low=0;
        int high= nums.length -1;   
        while(low<=high){
            int mid =(low+high)/2;
            
            if(nums[mid]==target){
                return mid;
            }
            
            else if(nums[low]<=nums[mid]){
                //left side is sorted
                if(target>=nums[low]&&target<=nums[mid]){
                    //it is in the middle 2 <=x<=4
                    high = mid -1;
                    
                }else{
                    low =mid+1;
                }
            }else{
                
                //left side is sorted
                if(target>=nums[mid]&&target<=nums[high]){
                    //it is in the middle 2 <=x<=4
                   low = mid+1;
                    
                }else{
                    high = mid-1;
                }
            
        }
        
        
    }
        return -1;
}
}

//Time Complexity - O( log n)