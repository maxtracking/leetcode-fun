import kotlin.math.max

class Solution4 {
    private fun mergeArray(nums1: IntArray, nums2: IntArray): IntArray {
        val n = nums1.size
        val m = nums2.size
        val result = IntArray(m + n)
        var i = 0
        var j = 0
        var k = 0

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < n) {
            result[k++] = nums1[i++];
        }

        while (j < m) {
            result[k++] = nums2[j++];
        }

        return result
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val ans = mergeArray(nums1, nums2);
        val a = ans.size / 2;
        val sum =
            if (ans.size % 2 == 0) {
                (ans[a - 1] + ans[a]).toDouble() / 2;
            } else {
                ans[a].toDouble()
            }
        return sum;
    }
}