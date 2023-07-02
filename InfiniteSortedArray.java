/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int lowIndex = 0;
        //since the array is sorted.. the target should be within the range of first Index and (targetValue - value in first Index);
        //this approach avoid one while loop.
        int highIndex = target - reader.get(lowIndex);
        int midIndex = 0; 
        while(lowIndex <= highIndex){
            midIndex = highIndex - (highIndex - lowIndex)/2;
            if(reader.get(midIndex) == target){
                return midIndex;
            }
            if(reader.get(midIndex) > target){
                highIndex = highIndex -1;
            }else{
                lowIndex = lowIndex + 1;
            }
        }

        return -1;

    }
}