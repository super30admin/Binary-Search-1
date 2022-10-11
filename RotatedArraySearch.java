// TC: O(log n)
// SC: O(1)

class RotatedArraySearch {
    //look for side that is sorted. Both cant be unsorted. Either left is sorted or right is sorted
    public static int search(int[] nums, int target) {

        int high = nums.length-1;
        int low = 0;
        int mid = 0;

        while(low <= high){

            mid = (low+high)/2;

            if(nums[mid] == target){
                return mid;
            }
            //left sorted
            if(nums[mid] >= nums[low]){

                if(nums[low] <= target && target <= nums[mid]){
                    high = mid -1;
                }else{
                    low = mid +1;
                }

            }

            //right sorted
            if(nums[high] >= nums[mid]){
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }

            }

        }

        return -1;

    }

    public static final void main(String [] args){
        int [] arr = {4,5,6,7,0,1,2};

        System.out.println(search(arr, 7));
        System.out.println(search(arr, 0));
        System.out.println(search(arr, 2));

    }

}