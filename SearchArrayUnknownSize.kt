
class SearchArrayUnknownSize {
    fun search(reader: ArrayReader, target: Int): Int {
        var low = 0
        var high = 1

        while (reader.get(high) < target) {
            low = high
            high *= 2
        }

        while (low <= high) {
            val mid = low + (high - low) / 2
            val value = reader.get(mid)

            if (value == target) {
                return mid
            } else if (value < target) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return -1
    }
}