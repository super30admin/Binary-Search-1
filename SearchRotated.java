//TC: O(logN)
//SC: O(1)

class SearchRotated {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){ //Left is sorted check in it
                if(nums[low] <= target && nums[mid] > target)
                    high = mid -1;
                else
                    low = mid +1;
            }
            else { // right is sorted
                 if(nums[mid] < target && nums[high] >= target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SearchRotated sr = new SearchRotated();
        int[] arr = {4,5,6,8,0,1,2};
        System.out.println("Element 5 present at: "+ sr.search(arr,5));
         System.out.println("Element 7 present at: "+ sr.search(arr,7));       
    }
}

/**
output:

Element 5 present at: 1
Element 7 present at: -1
 */