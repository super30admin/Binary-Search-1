//Search in a sorted array of unknown size


since we dont know the upper boundary , lets start with low= 0 and high as 1 and double high every time we di not find high


class Solution {
    public int search(ArrayReader reader, int target) {

    int low = 0 ; int high = 1;

    while(target < reader.get(high)) {
    low = high;
    high = high *2;

    }

    while(low<=high) {
   
     int mid = low + (high-low)/2;
     
     if( target == reader.get(mid) {
     return mid;
    }

    if(reader.get(mid) > target) {
    high = mid -1;
      } else {

      low = mid + 1;
      }


    }
     return -1;
    }