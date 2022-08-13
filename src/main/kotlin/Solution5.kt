class Solution5 {
    fun longestPalindrome(s: String): String {
        val chars = s.toCharArray()
        val len = s.length
        var even = intArrayOf()
        var odd = intArrayOf()
        var longest = intArrayOf(0, 0)
        for (i in 0..len) {
            odd = expand(chars, i, i)
            if (odd[1] - odd[0] > longest[1] - longest[0]) {
                longest = odd;
            }
            even = expand(chars, i, i + 1)
            if (even[1] - even[0] > longest[1] - longest[0]) {
                longest = even;
            }
        }
        return s.substring(longest[0] + 1, longest[1]);
    }

    private fun expand(chars: CharArray, i: Int, j: Int): IntArray{
        var left = i
        var right = j
        while (left >= 0 && right < chars.size && chars[left] == chars[right]) {
            left--
            right++
        }

        return intArrayOf(left, right)
    }
}