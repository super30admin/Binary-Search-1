// Time Complexity : O(log N)
// Space Complexity : O(N)
// run on Leetcode : NO. Its a premium question on LC I used GFG compiler to test and it tests only one test case
// Any problem you faced while coding this :

class searchInfiniteArray {

    static int binarySearch(int[] arr, int l, int h, int x) {
        while(l<=h){
            int mid = l + (h-l)/2;

            if(arr[mid] == x){
                return mid;
            }else if( arr[mid] < x){
                l = mid +1;
            }else{
                h = mid -1;
            }

        }
        return -1;
    }

    static int findPos(int[] arr, int key) {
        int low =0;
        int high =1;

        while(arr[high] < key){
            low = high;
            high = high *2;
        }
        return binarySearch(arr, low, high, key);

    }

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int k = 10;
        int ans = findPos(arr, k);
        System.out.println(ans);
    }
}