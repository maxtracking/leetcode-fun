class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (s.isBlank()) return ""
        if (s.length == 1) return s

        val len = s.length
        val chars = s.toCharArray()
        var c = 0
        var j = 0
        val fullRows = len / (2 * numRows - 2)
        var reminder = len % (2 * numRows - 2)
        val hasAdditionalRow = reminder > 0
        if (hasAdditionalRow) {
            reminder -= numRows
        }
        val lastLines = if (hasAdditionalRow && reminder > 0) (reminder % numRows) else 0
        val totalRows = fullRows * (numRows - 1) + (if (hasAdditionalRow) 1 else 0) + lastLines
        val zigzag = Array(numRows) { CharArray(totalRows) }

        while (c < len) {
            // full rows
            while (j < fullRows * (numRows - 2 + 1)) {
                for (i in 0 until numRows) {
                    if (c >= len) {
                        break
                    }
                    zigzag[i][j] = chars[c++]
                }
                j++
                for (i in numRows - 2 downTo 1) {
                    zigzag[i][j++] = chars[c++]
                }
            }
            // additional row
            var k = totalRows - lastLines - 1
            for (i in 0 until numRows) {
                if (c >= len) {
                    break
                }
                zigzag[i][k] = chars[c++]
            }
            if (c < len) {
                var l = totalRows - lastLines
                for (i in numRows - 2 downTo 1) {
                    if (c >= len) {
                        break
                    }
                    zigzag[i][l++] = chars[c++]
                }
            }
        }

        val buffer = StringBuffer()
        for (i in 0 until numRows) {
            for (j in 0 until totalRows) {
                val char = zigzag[i][j]
                if (char != '\u0000')
                    buffer.append(char)
            }
        }

        return buffer.toString()
    }

    fun convert2(s: String, rows: Int): String {
        val result = StringBuffer()
        val jump = 2*(rows - 1)
        for(i in 0 until rows){
            result.append(alternateAdder(s,i,jump))
        }
        return result.toString()
    }

    private fun alternateAdder(s: String, indexNumber: Int, jumpNumber: Int): String {
        if (jumpNumber == 0) {
            return s
        }
        val result = StringBuffer()
        val a1 = jumpNumber - 2 * indexNumber
        val a2 = 2 * indexNumber // jumpNumber-a1
        var isA1 = true
        var i = indexNumber
        while (i <= s.lastIndex) {
            if (a1 == 0) {
                isA1 = false
            } else if (a2 == 0) {
                isA1 = true
            }

            if (isA1) {
                result.append(s[i])
                i += a1
                isA1 = false
            } else {
                result.append(s[i])
                i += a2
                isA1 = true
            }
        }
        return result.toString()
    }
}