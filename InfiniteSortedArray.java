class InfiniteSortedArray {

    // Time Complexity: O(log n)

    public int search(ArrayReader reader, int target) {
        int i = 0;
        while(reader.get(i) != 2147483647)
            i = i + 2;
        
        if(reader.get(i) == 2147483647) 
            i--;
        
        int low = 0;
        int high = i;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}