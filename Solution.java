/*
time complexity: O(log n)
space complexity: O(1)
 */

//[4, 5, 6, 7, 0, 1, 2] //target is 0
//low is 0 and high is 6 where as mid is 3
//Ran successfully on leetcode
//so far no challenges faced


class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2; //calculating mid like this to avoid integer overflow error.

        if(arr[mid] == target) return mid;

            else if(arr[low] <= arr[mid]){
                //arr is left sorted

                if(arr[low] <= target && arr[mid] > target){
                    high = mid -1;
                } else{
                    low = mid + 1;
                }
            }else{
                if(arr[high] >= target && arr[mid] < target){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }

        }
        return -1;

    }
}