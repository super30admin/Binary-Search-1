/*
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Did this code run successfully on leetcode: Yes
 * Any problem faced while coding this: No
 * */

class RotatedSortedArray {
    public int search(int[] arr, int target) {
        int left = 0 , right = arr.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int rotation = left;
        left = 0;
        right =arr.length - 1;

        while(left <= right){
            int mid = (left+right)/2;
            int realMid = (mid +rotation) % arr.length;
            if( arr[realMid] == target) {
                return realMid;
            } else if(arr[realMid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}