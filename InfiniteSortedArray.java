/*
The time complexity is O(logN) and the space complexity is O(1)

Here, since we dont know the length of the array. we start with left as 0 and right as 1. This is the reverse of our traditional binary
search. When the right value is found. We apply the binary search between left and right.
 */
class Solution{

    public int search(int[] array, int target){

        int left = 0; int right = 1; int value = array[right];
        while(value<target){
            left = right;
            right = right*2;
            value = array[right];
        }

        return search(array,left,right,target)
    }

    public int seach(int[] array, int left, int right, int target){

        while(left<=right){
            int mid = left+ (right-left)/2;

            if(array[mid]==target){
                return mid;
            }
            else if(array[mid]>target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
    }
}