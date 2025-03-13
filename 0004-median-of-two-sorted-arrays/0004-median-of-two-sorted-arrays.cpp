class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();

        if ((m + n) % 2 == 1) {
            return findKthSmallest(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);
        } else {
            int first = findKthSmallest(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2);
            int second = findKthSmallest(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);

            return (double)(first + second) / 2;
        }
    }

private:
    int findKthSmallest(vector<int>& A, int Astart, int Aend, 
                        vector<int>& B, int Bstart, int Bend, int k) {
        if (Astart > Aend) {
            return B[Bstart + k - 1];
        }
        if (Bstart > Bend) {
            return A[Astart + k - 1];
        }
        if (k == 1) {
            return min(A[Astart], B[Bstart]);
        }

        int i = min((int)A.size() - Astart, k / 2);
        int j = min((int)B.size() - Bstart, k / 2);

        if (A[Astart + i - 1] > B[Bstart + j - 1]) {
            return findKthSmallest(A, Astart, Aend, B, Bstart + j, Bend, k - j);
        } else {
            return findKthSmallest(A, Astart + i, Aend, B, Bstart, Bend, k - i);
        }
    } 
};