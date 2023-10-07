import javax.lang.model.util.ElementScanner14;

//in a rotated sorted array, we know that one half of the array will be sorted whereas the other will be unsorted
//we have to find which half is sorted and whether or not our element lies in that side
//if element is in the sorted side, we continue searching binary search in the sorted side
//else we come to the unsorted side, and then find the sorted side in that half and repeat the above steps

class SearchRotatedSortedArray {    

    public static void main(String[] args) {
        int[] array = {7,8,9,10,11,1,2,3,4,5,6};
        //int[] array = {6,7,8,0,1,2,3};
         //int[] array = {};
        int element = 4;
        int result = searchElement(array, element);

        if (result == -1){
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found at index " + result);
        }
    }

    //Time complexity : O(logn)
    //Space Complexity : O(1) no additional auxillary space needed
    public static int searchElement(int[] arr, int target)
    {

        if(arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        while(low<=high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) 
            {
                return mid;
            }
            else if(arr[low] <= arr[mid])
            {   
                if(arr[low] <= target && target <= arr[mid])
                {
                    high = mid - 1;
                }else 
                {
                    low = mid + 1;
                }
            }
            else if (arr[mid] <= arr[high]) 
            {
                if(arr[mid] <= target && target <= arr[high])
                {
                    low = mid + 1;
                }else 
                {
                    high = mid - 1;
                }
            }
        }


        return -1;

    }
    
}
