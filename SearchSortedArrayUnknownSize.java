import javax.lang.model.util.ElementScanner14;

//we have a buffer of incoming numbers
// we assign a low and high pointer starting from index 0 and 1 respectively
//if the number does not lie in the range, we shift the low pointer in place of high and high pointer at double the previous index
//if we go out of bounds, then return -1 as element not found, in the problem, out bounds is reflected when high pointer is at 2^31 - 1 index
// this will work for reader interface, in leetcode, but in array it won't work



class SearchSortedArrayUnknownSize {

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11};
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

    // time complexity: O(logn)
    //space complexity: O(1)
    public static int searchElement(int arr[], int element)
    {
        if(arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = 1;

        while(arr[high]<element)
        {
            low = high;
            high = 2*high;
        }
                

                while(low<=high){
                    int mid = low + (high-low)/2;

                    if(arr[mid] == element)
                    {
                        return mid;
                    }else if(arr[mid]>element)
                    {
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }

                }

        

        return -1;
    }
    
}
