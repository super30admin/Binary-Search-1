 /*
  * We are doing Binary Search here.
  * Time Complexity   : O(log(n)) - We take a few iterations initially to find the sub-array to search in.
  *                                 Then we do Binary Search. So we would take O(log(n)) interations to find the sub-array.
  *                                 And then O(log(m)) to search. m being number of elements in the sub-array.
  *                                 So, on average we can say that the time complexity if O(log(n)).
  * Space Complexity  : O(1)      - No extra space is being used 
  */
int search(const ArrayReader& reader, int target)
{
     int low = 0, high = 1;
     while (target > reader.get(high)) {
         low = high;
         high *= 2;
     }
        
     return binarySearch(reader, target, low, high);
}
  
int binarySearch(const ArrayReader& reader, int target, int low, int high)
{
    int mid;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        if (reader.get(mid) == target) {
            return mid;
        }
            
        if (target > reader.get(mid)) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
        
    return -1;
}
