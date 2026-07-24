class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] dp = new boolean[MAX];
        dp[0] = true;

        for (int step = 0; step < 3; step++) {
            boolean[] next = new boolean[MAX];

            for (int x = 0; x < MAX; x++) {
                if (!dp[x]) continue;

                for (int v : nums) {
                    next[x ^ v] = true;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (boolean b : dp) {
            if (b) ans++;
        }

        return ans;
    }
}