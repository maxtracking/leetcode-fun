class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var result = 0
        val numStrings = strs.size
        try {
            while (true) {
                val char = strs[0][result]
                for (i in 1 until numStrings) {
                    if (strs[i][result] != char) {
                        return strs[i].substring(0, result)
                    }
                }
                result++
            }
        } catch (e: IndexOutOfBoundsException) {
            return strs[0].substring(0, result)
        }
    }
}