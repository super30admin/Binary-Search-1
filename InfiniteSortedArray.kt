class Solution {
    fun search(reader: ArrayReader, target: Int): Int {

        var low = 0
        var high = 1

        while (reader.get(high) < target) {
            low = high
            high = high * 2
        }

        while (low <= high){

            val mid = low + (high - low)/2

            if(reader.get(mid) == target){
                return mid
            }
            else {
                if(reader.get(mid) < target){
                    low = mid +1
                }
                else{
                    high = mid -1
                }
            }

        }

        return -1

    }
}