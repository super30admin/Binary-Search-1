public class searchInfinte {

  public int search(ArrayReader reader, int target) {
    int low = 0;
    int high = target - reader.get(0);

    while (target > reader.get(high)) {
      low = high + 1;
      high = high * 2;
    }
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == reader.get(mid)) return mid; else if (
        target < reader.get(mid)
      ) high = mid - 1; else low = mid + 1;
    }
    return -1;
  }
}
