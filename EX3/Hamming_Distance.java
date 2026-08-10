class Solution {
    public int hammingDistance(int x, int y) {
        // LeetCode-ready optimal solution
        return Integer.bitCount(x ^ y);
    }
}

public class MainManual {
    // Method to calculate Hamming Distance using manual bit shifting
    public static int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        int distance = 0;
        
        while (xorResult > 0) {
            // Check if the rightmost bit is 1
            distance += xorResult & 1;
            // Unsigned right shift to process the next bit
            xorResult >>>= 1;
        }
        
        return distance;
    }

    public static void main(String[] args) {
        // Test Case 1
        int x1 = 1, y1 = 4;
        System.out.println("Input: x = " + x1 + ", y = " + y1);
        System.out.println("Output: " + hammingDistance(x1, y1)); // Expected: 2

        System.out.println();

        // Test Case 2
        int x2 = 3, y2 = 1;
        System.out.println("Input: x = " + x2 + ", y = " + y2);
        System.out.println("Output: " + hammingDistance(x2, y2)); // Expected: 1
    }
}
