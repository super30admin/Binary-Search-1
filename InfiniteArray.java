/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Any problem faced while coding this: I am not able to think of O(log n) solution. Also I dont know how to handle ArrayOutOfBounds Exception
 * */

class InfiniteArray {

    public int searchElementInInfiniteArray(int[] arr, int target) {

        int i = 0;

        while(arr [i] <= target){
            System.out.println(arr[i]);
            if(arr[i] == target) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        InfiniteArray array  = new InfiniteArray();
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(array.searchElementInInfiniteArray(input, 4));
    }
}