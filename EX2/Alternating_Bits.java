class Solution {
    public boolean hasAlternatingBits(int n) {
        int d = n % 2;
        n = n / 2;

        while (n > 0) {
            int c = n % 2;

            if (c == d) {
                return false;
            }

            d = c;
            n = n / 2;
        }

        return true;
    }
}
