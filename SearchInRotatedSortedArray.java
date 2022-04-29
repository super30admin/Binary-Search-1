//time complexity O(logN)
//space complexity O(1)
public class SearchInRotatedSortedArray
{
     public int search(int[] arr, int target)
     {
         int low = 0;
         int high = arr.length-1;
         while(low<=high)
         {
             int mid = low +(high - low)/2;
             if(arr[mid]==target) return mid;
             if(arr[mid]>=arr[low])
                if(target>=arr[low] && target<arr[mid])
                {
                    high = mid-1;
                }
                else
                {
                 low=mid+1;
                }
             else{
                 if(arr[mid]<target &&  target<=arr[high])
                 {
                     low = mid+1;
                 }
                 else
                 {
                     high = mid -1;
                 }
             }
         }
         return -1;
     }
}
