/*
Time Complexity- O(log n) since binary search is used
Space Complexity- O(n)
Problem solved after the class
 */
class Search_in_infinite_sorted_array {
    public int search(ArrayReader reader, int target) {

        int left = 0;
        int right = 1;
        int mid;

        while(reader.get(right) < target){
            left = right;
            right = right*2;
        }

        return binarySearch(reader, target, left, right);

    }

    public int binarySearch(ArrayReader reader, int target, int left, int right){

        if(left > right) return -1;
        int mid = left + (right-left)/2;

        if(reader.get(mid) == target) return mid;

        if(reader.get(mid) < target)
            return binarySearch(reader, target, mid+1, right);
        else
            return binarySearch(reader, target, left, mid-1);
    }
}