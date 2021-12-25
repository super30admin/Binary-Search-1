//Time Complexity: log(n)
//Space Complexity: O(1)


public class problem2 {

        public int search(int[] nums, int target) {
            int low = 0, high = nums.length-1;
            
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid]==target) return mid;
                else if(nums[low]<=nums[mid]){ //This means that left is sorted
                    if(nums[low]<=target && nums[mid]>target)// nums is in the left side of the array
                    {
                        high = mid-1;
                    }
                    else{
                        low = mid +1;
                    }
                }else{//right part of the array is sorted
                    if(nums[mid] < target && nums[high]>=target){//element is in the right array
                        low = mid + 1;
                    }else{
                        high = mid -1;
                    }
                }    
            }
            return -1;
        }
    
}
