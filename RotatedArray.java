// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class RotatedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1; 
        int low=0; int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else{
                if(nums[low]<= nums[mid]){
                    if(nums[low] <=target && nums[mid]>target){
                        high=mid-1;
                    }
                    else
                        low=mid+1;
                }
                else{
                    if(nums[mid] <target && nums[high]>=target){
                        low=mid+1;
                    }
                    else
                        high=mid-1;
                }
                    
                }
            }
        return -1;
        }

        public static void main(String args[]) 
        {
           
            RotatedArray obj = new RotatedArray();
        int array_input[]={ 7,8,9,0,1,2,3  };
        if(obj.search(array_input, 3)==-1)
            System.out.println("Element is not present ");
        else
            System.out.println("Element is  present");
        }
    }
