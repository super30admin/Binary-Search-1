class Solution {
  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == target) 
        return 0;

    int start = 0, end = 1;
    while (reader.get(end) < target) {
      start = end;
      end <<= 1;
    }

    int pivot, num;
    while (start <= end) {
      pivot = start + ((end - start) >> 1);
      num = reader.get(pivot);

      if (num == target) 
          return pivot;
      if (num > target) 
          end = pivot - 1;
      else start = pivot + 1;
    }

    return -1;
  }
}