//time - O(log n)
//space - O(1)

//please help me with the case when high goes out of bounds, I was trying to use a try catch block but couldn't complete it
//eg test case - [1,2,3,4] with target = 4
class Main {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(searchInfiniteArray(nums, 7));
  }

  public static int searchInfiniteArray(int[] nums, int target) {
    int low = 0;
    int high = 1;
    int currentHigh = nums[high];

    while(currentHigh < target)
    {
      high = high * 2;
      currentHigh = nums[high];
    }
    low = high / 2;

    return binarySearch(nums, low, high, target);
  }

  public static int binarySearch(int[] nums, int low, int high, int target) {
    while(low <= high) 
    {
      int mid = (low + high) / 2;
      if(nums[mid] == target)
      {
        return mid;
      }
      else if(nums[mid] > target)
      {
        high = mid - 1;
      }
      else
      {
        low = mid + 1;
      }
    }
    return -1;
  }
}
