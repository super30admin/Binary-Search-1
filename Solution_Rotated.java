class Solution_Rotated {
    public int bSearch(int[] arr,int l,int r,int x){
       
            if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
          
            if (arr[mid] == x) 
                return mid; 
  
           
            if (arr[mid] > x) 
                return bSearch(arr, l, mid - 1, x); 
  
          
            return bSearch(arr, mid + 1, r, x); 
        } 
  
       
        return -1; 
    }
    public int search(int[] nums, int target) {
        if (nums.length == 1)
        return nums[0] == target ? 0 : -1;
        int low = 0,max=0;
        int high = nums.length-1;
        while(low != high){
          
            if(low == high - 1){
                //array has only 2 elements
                if(nums[low] >  nums[high]){
                    max = low;
                    break;
                }
                else{
                    max = high;
                    break;
                }
            }
            else{
                int mid = (low + high)/2;
                //System.out.println("mid is "+mid);
                if(nums[mid] > nums[low]){
                    // maximum is on the right of the mid
                    low = mid;
                }
                else{
                    //maximum is on the left of the mid
                    high = mid;
                }
            }
            
        }
        
        
        int sec[] = Arrays.copyOfRange(nums,0,max+1);
       //binary search in the first part
        int res = bSearch(sec,0,sec.length - 1,target);
    
        if(res != -1){
            return res;
        }
        //binary search in the second part if target is not found in the first part
        else
        {
      
            int[] sec1 = Arrays.copyOfRange(nums,max+1,nums.length);
            
            res = bSearch(sec1,0,sec1.length-1,target);
            
            if(res != -1)
                res = res+sec.length;
            
           
        }
        return res;
    }
}
