// Time complexity- lon(n)
// Space complexity- O(1)
function search(reader: ArrayReader, target: number): number {
	let low = 0;
	let high = 1;

	while (reader.get(high) < target) {
		low = high;
		high = high * 2;
	}

	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		if (reader.get(mid) === target) return mid;
		else if (reader.get(mid) < target) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}

	return -1;
}
