class Solution {
    public int search(ArrayReader reader, int target) {

        while (reader.get() != 2147483647) {
            int num = reader.get();
            if (num == target) {
                return target;
            }
        }

        return -1;
        
    }
}