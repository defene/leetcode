class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int na = nums1.length;
        int nb = nums2.length;

        int n = na + nb;
        if (n % 2 == 1) {
            return helper(n / 2, nums1, 0, na - 1, nums2, 0, nb - 1);
        } else {
            return (double)(helper(n / 2, nums1, 0, na - 1, nums2, 0, nb - 1) + helper(n / 2 - 1, nums1, 0, na - 1, nums2, 0, nb - 1)) / 2;
        }
    }

    private int helper(int k, int[] nums1, int aLeft, int aRight, int[] nums2, int bLeft, int bRight) {
        if (aRight < aLeft) {
            return nums2[k - aLeft];
        }
        if (bRight < bLeft) {
            return nums1[k - bLeft];
        }

        int aMid = (aLeft + aRight) / 2;
        int bMid = (bLeft + bRight) / 2;
        int aValue = nums1[aMid];
        int bValue = nums2[bMid];

        if (aMid + bMid < k) {
            if (aValue > bValue) {
                return helper(k, nums1, aLeft, aRight, nums2, bMid + 1, bRight);
            } else {
                return helper(k, nums1, aMid + 1, aRight, nums2, bLeft, bRight);
            }
        } else {
            if (aValue > bValue) {
                return helper(k, nums1, aLeft, aMid - 1, nums2, bLeft, bRight);
            } else {
                return helper(k, nums1, aLeft, aRight, nums2, bLeft, bMid - 1);
            }            
        }
    }
}