class LongestCommonSubsequence
{
    //Function to find the length of longest common subsequence in two strings.
    int lcs(int x, int y, String s1, String s2)
    {
        int[][] k = new int[x+1][y+1];

        for(int i = 1; i < x+1; i++) {

        	for(int j = 1; j < y+1; j++) {

        		if (s1.charAt(i-1) == s2.charAt(j-1)) {
        			k[i][j] = 1 + k[i-1][j-1];
        		}
        		else {
        			k[i][j] = Math.max(k[i-1][j], k[i][j-1]);
        		}
        	}
        }
        return k[x][y];
    }
    
}