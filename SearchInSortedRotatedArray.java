public class SearchInSortedRotatedArray {
    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high) {
            int mid;
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){ //sorted first half
                System.out.println("first half");
                if(target >= nums[low] && target < nums[mid]){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else { //sorted second half
                System.out.println("second half");
                if(target > nums[mid] && target <= nums[high]){
                    low=mid+1;
                }
                else high=mid-1;
            }

        }
    return -1;
    }
    public static void main(String args[]){
        int[] array={4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(array,target));
    }
}
