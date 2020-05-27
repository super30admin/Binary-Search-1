class BinarySearch2{

  int binarySearch(int arr[], int l, int r, int x)
  {
    //Write your code here
    if(l<=r){
      int mid = (l + (r - l))/2;
      if(arr[mid] == x)
        return mid;
      if(arr[mid] < x)
        return binarySearch(arr, mid + 1, r, x);
      else
        return binarySearch(arr, l, mid - 1, x);
    }
    return -1;

  }

  private int infiniteArr(int[] arr, int target){
    int low = 0,high =1;

    while(arr[low] < target){
      low = high;
      if(2*high < arr.length - 1)
        high = high *2;
      else
        high = arr.length - 1;
    }
    return binarySearch(arr,low,high,target);
  }

  // Driver method to test above
  public static void main(String args[])
  {
    BinarySearch2 ob = new BinarySearch2();
    int arr[] = { 2, 3, 4, 10, 40};
    int x = 10;
    int result = ob.infiniteArr(arr, x);
    if (result == -1)
      System.out.println("Element not present");
    else
      System.out.println("Element found at index " + result);
  }
}