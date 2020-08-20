// Time Complexity : 
// for findArr we find the high and low so that it doesnt get out of bounds The findArr funciton will require O(log t)
// time complexity where t is the index of the target element and sicne the size of the array doubles everytime until p is in the subarray.
// for binarySearch time complexity will be O(log t) as well and hence overall it will be O(log t)

// Space Complexity : O(n) where n is the number of elements in the array as nothing else is required
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Search {

    // normal recursive binary search
    public int binarySearch(int arr[], int l, int r, int target) {

        if (r >= l) {

            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                return binarySearch(arr, l, mid - 1, target);
            return binarySearch(arr, mid + 1, r, target);
        }
        return -1;
    }

    // find the sub array in an exponential way
    int findArr(int arr[], int target) {

        // Initially we set the array as the first two elements
        int h = 1, l = 0;
        // find in an exponential way to find the range of array which might have the target by checking the target is smaller than element at high position
        while (target > arr[h]) {
            l = h;
            if (2*h<arr.length-1)
                h = 2*h
            else h =arr.length-1;
        
        }

        return binarySearch(arr,l,h,target);
    }

    public static void main(String[] args) {

    }

}