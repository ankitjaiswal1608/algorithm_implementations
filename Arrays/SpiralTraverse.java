import java.util.*;

class SpiralTraverse {
  public static List<Integer> spiralTraverse(int[][] array) {
    
		List<Integer> result = new ArrayList<Integer>();
		int n = 0;
		int e = array[0].length - 1;
		int s = array.length - 1;
		int w = 0;
		int arrayarea = array[0].length * array.length;
		while (true) {
			for (int i = w; i <= e; i++) {
				result.add(array[n][i]);
			}
			if (arrayarea == result.size()) break;
			n++;
			for (int i = n; i <= s; i++) {
				result.add(array[i][e]);
			}
			if (arrayarea == result.size()) break;
			e--;
			for (int i = e; i >= w; i--) {
				result.add(array[s][i]);
			}
			if (arrayarea == result.size()) break;
			s--;
			for (int i = s; i >= n; i--) {
				result.add(array[i][w]);
			}
			if (arrayarea == result.size()) break;
			w++;
		}
		
		return result;
  }
}