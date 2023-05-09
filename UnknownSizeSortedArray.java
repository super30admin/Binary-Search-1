package BinarySearch1;

public class UnknownSizeSortedArray { public int search(ArrayReader reader, int target) {

    //base case
    if(reader.get(0) == target)
        return 0;

    // shifting and searching correct boundary
    int left = 0, right = 1;
    while( target > reader.get(right) ) {
        left = right;
        right <<= 1;
    }

    //binary search within the correct boundary
    while(left <= right) {
        int mid = left + ((right-left)/2);
        int mid_element = reader.get(mid);

        if (mid_element == target)
            return mid;
        if(mid_element > target)
            right = mid-1;
        else
            left = mid + 1;

    }
    // target not found
    return -1;

}
}
