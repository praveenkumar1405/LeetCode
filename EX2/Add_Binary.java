class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int digitA = 0;
            int digitB = 0;

            if (i >= 0) {
                if (a.charAt(i) == '1') {
                    digitA = 1;
                }
                i--;
            }

            if (j >= 0) {
                if (b.charAt(j) == '1') {
                    digitB = 1;
                }
                j--;
            }

            int sum = digitA + digitB + carry;

            if (sum == 0) {
                result = "0" + result;
                carry = 0;
            } else if (sum == 1) {
                result = "1" + result;
                carry = 0;
            } else if (sum == 2) {
                result = "0" + result;
                carry = 1;
            } else if (sum == 3) {
                result = "1" + result;
                carry = 1;
            }
        }

        return result;
    }
}
