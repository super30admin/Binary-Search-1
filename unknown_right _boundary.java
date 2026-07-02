class Solution{
    public int search(ArrayReader reader, int target){
        int left = 0;
        int right = 1;

        //expanding search rage
        while(.get(right)< target){
            left = right + 1;
            right = right * 2;
        }
            //the binary search
            while(left <= right){
                int mid = left + (right - left)/2;

                int value = reader.get(mid);

                if(value == target){
                    return mid;
                }else if(value < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return -1;
    }
}