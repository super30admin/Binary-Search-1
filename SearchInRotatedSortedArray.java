//time complexity - O(logn), space complexity - O(N)
//binary search used to locate the target efficiently.
//Adjust the search based on which half of the rotated array is sorted.
//Keep updating pointers to narrow down the search space until the target is found or the search space is exhausted.
class Solution {
    public int search(int[] ar, int target) {
        int left = 0, right = ar.length - 1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(ar[mid] == target) return mid;
            else if(ar[left]<= ar[mid]){
                if(ar[left]<= target && ar[mid]>target){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(ar[mid]< target && ar[right]>=target){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
