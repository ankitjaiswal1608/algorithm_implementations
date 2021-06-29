import java.util.*;

class LongestPeak {

	public static int longestPeak(int[] array) {
		
		if (array.length < 3) return 0;
		
    	int peakLen = 0;
		
		List<Integer> peaks = new ArrayList<>();
		
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i-1] < array[i] && array[i] > array[i+1]) peaks.add(i);
		}
		
		if (peaks.size() > 0) {
			for (int peak : peaks) {
				peakLen = Math.max(peakLen, getPeakLen(peak, array));
			}
		}
		
		return peakLen;
	}
	
	private static int getPeakLen(int index, int[] array) {
		int left = 0;
		int right = 0;
		for (int i = index-1; i >= 0; i--) {
			if (array[i] < array[i+1]) left++;
			else break;
		}
		
		for (int i = index+1; i < array.length; i++) {
			if (array[i-1] > array[i]) right++;
			else break;
		}
		
		return left+right+1;
	}
}