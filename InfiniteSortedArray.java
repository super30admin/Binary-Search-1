import java.io.*;

// Time Complexity : O(log n) binary search + O(log n) finding the bounds = O(log n)
// Space Complexity : O(1) in addition to the provided array which is O(n)
// Did this code successfully run on Leetcode : nope. I don't have subscription to premium.
// Any problem you faced while coding this : Not really but had to test it myself :P

public class InfiniteSortedArray {
    
    // we will do binary search when we actually find the upper and lower bounds of the target value. 
    // time : O(log n)
    public static int binarySearch(InfiniteArray arr, int l, int r, int x) 
    { 
        //Write your code here
        while(r>=l) {
            int mid = l+((r-l)/2);
            if(x == arr.get(mid)) {
                return mid;
            } else if(x < arr.get(mid)) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
    
    // fast search using slow and fast pointers
    // time : O(log n)
    public static int fastSearch(InfiniteArray arr, int target) {
        int slow = 0;
        int fast = 1;

        while(arr.get(fast) != -1 && arr.get(fast) <= target) {
            slow = fast;
            fast = slow*2;
        }

        //if fast is out of bounds get current size of infinite array/stream as the upper bound.
        if(target > arr.get(fast)) {
            fast = arr.getCurrentLength()-1;
            if(target > arr.get(fast)) {
                return -1;
            }
        }
        
        return binarySearch(arr, slow, fast, target);
    }

    //This will let you test my code -- 
    public static void main(String args[]) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size to initialize array: ");
        int size = Integer.parseInt(reader.readLine());

        InfiniteArray infArr = new InfiniteArray(size);

        System.out.println("Please add integer elements line by line: ");
        while(size-- > 0) {
            infArr.add(Integer.parseInt(reader.readLine()));
        }

        System.out.println("Please enter target value: ");
        int target = Integer.parseInt(reader.readLine());
        System.out.println(fastSearch(infArr, target));
    }
}