class Solution {
    public int lastStoneWeight(int[] stones) {

        int n = stones.length;

        while (n > 1) {

            Arrays.sort(stones, 0, n);

            int y = stones[n - 1];
            int x = stones[n - 2];

            stones[n - 2] = y - x;
            n--;
        }

        return n == 0 ? 0 : stones[0];
    }
}