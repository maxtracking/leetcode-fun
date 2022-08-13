import kotlin.math.max

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }
        val resultSet = mutableSetOf<Int>()
        val subSet = mutableSetOf<Char>()
        resultSet.add(subSet.size)
        for (i in s.indices) {
            subSet.add(s[i])
            for (j in i + 1 until s.length) {
                if (subSet.contains(s[j])) {
                    resultSet.add(subSet.size)
                    subSet.clear()
                    break;
                } else {
                    subSet.add(s[j])
                }
            }
            if (subSet.size == s.length) {
                break;
            }
        }
        resultSet.add(subSet.size)

        return if (resultSet.isEmpty()) 0 else resultSet.sortedBy { it }.last()
    }

    fun lengthOfLongestSubstring2p(s: String): Int {
        // create and initialize HashMap to false for all the characters in the string
        val map: HashMap<Char, Boolean> = HashMap()
        for (c in s.toCharArray()) map[c] = false

        // two pointers for the sliding window technique
        var left = 0
        var right = 0
        var maxLen = 0 // variable to keep the maximum length so far
        while (right < s.length && left < s.length) {
            // if the right char is a duplicate, increment left (and mark false) until there is no duplicate
            if (map[s[right]]!!) {
                map[s[left++]] = false
            } else { // keep incrementing left and counting maxLen while there is no duplicate
                map[s[right]] = true
                maxLen = max(maxLen, right - left + 1)
                right++
            }
        }
        return maxLen
    }
}