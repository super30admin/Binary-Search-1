//Search in a Rotated Sorted Array

//Time Complexity: O(log n)
//Space Complexity: O(1)

class rotSearch {
    public int search(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            if(a[mid] == target)
                return mid;
                // [4,5,6,7,0,1,2]
            else if(a[low] <= a[mid]){ //left side is sorted
                if(a[low] <= target && a[mid] >= target) //key is in left half
                    high = mid - 1;
                else
                    low = mid + 1; //key is in right half
            }
            // [ 7,8,0,1,2 ]
            else{
                if(a[mid] <= target && a[high] >= target) // key is in right half
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}