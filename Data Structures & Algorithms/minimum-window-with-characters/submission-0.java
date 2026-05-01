class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128]; // ASCII characters

        // Step 1: Store frequency of t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int count = t.length(); // total characters needed

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If character is needed, reduce count
            if (freq[r] > 0) {
                count--;
            }
            freq[r]--; // include in window

            // When all characters matched
            while (count == 0) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++; // remove from window

                // If removed char was required → window invalid
                if (freq[l] > 0) {
                    count++;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
