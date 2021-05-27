//Time Complexity - O(logN)
//Space Complexity - O(1)

class SearchSortedArrayUnknownSize {
  public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while(reader.get(right) < target){
            left = right;
            right = 2 * right;
        }

        while(left <= right){
            int mid = (left + right)/2;

            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
