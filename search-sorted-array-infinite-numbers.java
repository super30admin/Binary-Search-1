/*

Did it run : yes
Time Complexity: 2*O(Log p) = 0(Log P) where P is the position of the element
Space Complexity: 0(1)

Algorithm:
- To do a binbary search, we need  bounds. So first step is to find the bounds in which we can do binary search
- Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
- if it is greater than high index element then copy high index in low index and double the high index.
- if it is smaller, then apply binary search on high and low indices found.

*/

class Main {
    public static void main(String[] args) {
      int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,  140, 160, 170};
      int target = 10; 
      int pos = Main.binarySearch(arr, target);
  
      System.out.println(pos);
    }
  
    public static int binarySearch(int[] arr, int target){
  
      int low=0,high=1;
      while(target>=arr[high]){
        low=high;
        high = 2*high;
      }
  
  
      while(low<=high){
        int mid = (low+high)/2;
        if(arr[mid]==target){
          return mid;
        }
        else if(arr[mid]>target){
          high = mid-1;
        }
        else{
          low = mid+1;
        }
      }
      return -1;
    }
  }