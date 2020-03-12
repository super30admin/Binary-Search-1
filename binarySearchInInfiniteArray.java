class ArrayReader {
    int[] arr;
  
    ArrayReader(int[] arr) {
      this.arr = arr;
    }
  
    public int get(int index) {
        int val=Integer.MAX_VALUE;
        try
        {
            val = arr[index];
        }
        catch(IndexOutOfBoundsException e)
        {
            throw e;
        }
      return val;
    }
  }
  
  class SearchInfiniteSortedArray {
  
    public static int search(ArrayReader reader, int key) {
      int len = reader.arr.length-1;
      if (reader.get(0) > key || reader.get(len) < key)
      {
        return -1;
      }
      int start = 0, end = len;
      while (start <= end)
      {
        int mid = start + (end - start)/2;
        if (reader.get(mid) == key)
        {
          return mid;
        }
        if (reader.get(mid) > key)
        {
          end = mid - 1;
        }
        if (reader.get(mid) < key)
        {
          start = mid+1;
        }
      }
      return -1;
    }
}