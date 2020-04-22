

/**
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
 * Accessing an element out of bounds throws exception.
 * If the number occurs multiple times, return the index of any occurrence. If its not present then return -1.
 */
public class SearchInSortedArray {

    //Time Complexity:o(log n) as every time my range is incresing twice as previous
    // + (log n) for binary search=>o(log n)+o(log n)=o(log n)
    //Space Complexity:o(1)
    /**
     * Search target value in infinite size array, and the array size is not known in advance
     * @param nums integer array of infinite size
     * @param target value to be searched in array
     * @return return index value if target is available else return -1
     */
    public static int searchInArray(int [] nums,int target){
        //Using 2 pointers, slow points to first element,second points to 2nd element.
        //I am updating slow and fast till nums[fast]<target
        int slow=0;
        int fast=1;

//I am assuming array size is infinite so it will not go array index out of bound
        while(nums[fast]<target){
            slow=fast;
            fast=fast*2;
        }
        return binarySearch(nums,target,slow,fast);
    }

    //Time Complexity:o(log n) where n is input array size
    //Space Complexity:o(1)
    /**
     * Binary Search function
     * @param nums number array
     * @param target value to be serched
     * @param l left index in an array
     * @param r right index in an array
     * @return
     */
    public static int binarySearch(int[]nums, int target,int l,int r){

        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target<nums[mid]) {
                r = mid - 1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int nums[]={0,1,24,5,6,7,10,12,14};
        int target=0;
        System.out.println(searchInArray(nums,target));
        target=3;
        System.out.println(searchInArray(nums,target));
    }
}
