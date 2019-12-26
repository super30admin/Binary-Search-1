// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Note that the while condition should be low <= high


// Your code here along with comments explaining your approach
class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums== null || nums.length==0)
            return -1;


        int low = 0 ;
        int high = nums.length-1;
        int mid;

        while(low<=high){

            mid = low + (high-low) / 2; //Prevents interger overflow

            // System.out.println("***");
            // System.out.println("low "+low);
            // System.out.println("Mid "+mid);
            //  System.out.println("high "+high);

            //base condition
            if(target == nums[mid])
                return mid;

            //Check if left half is sorted
            if(nums[mid]>= nums[low]){

                //if target is in sorted array, move the high pointer
                if(target<= nums[mid] && target >= nums[low]){
                    high = mid -1;
                }
                //if target not in sorted array, check the unsorted array. Move the pointers accordingly
                else{
                    low = mid +1;
                }
            }

            //Check if right half is sorted
            else{

                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }

}
class Main{
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
       // System.out.println(SearchRotatedSortedArray.search(nums,target));

    }
}