public class rotateSort {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length-1;

        if(target>=nums[start] && target<=nums[right]){
            left = start;
        }else{
            right = start;
        }

        while(left<=right){
            int mid = left+ (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]< target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        rotateSort r = new rotateSort();
        int nums[] = {4,5,6,7,10,0,1,2};
        int target = 10;
        r.search(nums,target);
    }
}
