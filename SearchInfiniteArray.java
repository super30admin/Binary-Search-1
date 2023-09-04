//You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
// returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
// returns 231 - 1 if the i is out of the boundary of the array.
//  You are also given an integer target.
//Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
//You must write an algorithm with O(log n) runtime complexity.
// https://leetcode.ca/2017-11-01-702-Search-in-a-Sorted-Array-of-Unknown-Size/


//Sorted array of Infinite size with unique elements is given.Need to return the index where target is present.
//TC is O(log N)
//SC is O(1)

public class SearchInfiniteArray {

    public int find(int[] arr, int target) {
        int low = 0;
        int high = 1;    //As we don't have any high value so we'll initially take the adjacant value and keep on changing

        while (arr[high] < target) {  //This loop is to find out the high and low range so that we can apply binary search on this.
            low=high;
            high = high*2;
        }

        return binarySearchFxn(arr,target,high,low);

    }

    private int binarySearchFxn(int[] arr, int target, int low, int high){
        while(low<=high){
            int mid= low +(high-low)/2;    //To prevent integer overflow
            if (arr[mid] == target){
                return mid;
            }
            else if (target>arr[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        SearchInfiniteArray obj= new SearchInfiniteArray();

        int[] arr={1,2,3,4,7,8,12,16,24,45,67,88,99,100,101,102,103,104,105,106};
        System.out.println(obj.find(arr,24));
    }
}