//time complexity: O(log n)
// space complexity: O (n)  {not sure} 
public class RotationalSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null && nums.length<=0){
            return -1;
        }
        int l = 0;
        int h = nums.length-1;
       
        while(l<=h){
             int m = l+(h-l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[l]<=nums[m]){
               if(nums[l]<=target && nums[m]> target){
                h=m-1;
               }
              else{
                l=m+1;
             }
            }
            else{
               if(nums[m]<target && nums[h]>= target){
                l=m+1;
               }
              else{
                h=m-1;
             }
        }
            
        }
        return -1;
    }
}
