package S30_Codes.Binary_Search_1;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Binary-Search-1

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int arr[], int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;

            if(arr[start] < arr[mid]){
                if(arr[start] <= target && target < arr[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else{
                if(mid+1<=end && arr[mid+1] <= target && target <= arr[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }

        return -1;
    }
}