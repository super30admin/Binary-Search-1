import java.sql.Time;

public class SearchInRotatedSorted {
    //Time Complexity: O(LogN)
    //Space Complexity: constant
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target?0:-1;
        }

        // find rotation index;
        int begin = 0;
        int end = nums.length -1;
        int mid = -1;

        if(nums[begin] > nums[end]){

            while(begin <= end ){
                mid = (begin + end) / 2;

                if(nums[mid] > nums[mid + 1]){
                    //found starte element at mid + 1
                    break;
                }

                if(nums[mid]  < nums[end]){
                    //starte is at left
                    end = mid;
                }
                else{
                    begin = mid;
                }
            }

            begin = 0;
            end = nums.length - 1;
            if(target >= nums[begin]){
                end = mid;
            }
            else{
                begin = mid + 1;
            }
        }else{
            begin = 0;
            end = nums.length - 1;
        }

        // perform binary search


        while(begin <= end){
            mid = (begin + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                begin = mid + 1;
            }else {
                end = mid - 1;

            }
        }

        return -1;

    }
}
