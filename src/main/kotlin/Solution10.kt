class Solution10 {
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val M =
            Array(m + 1) { arrayOfNulls<Boolean>(n) } // Why Boolean: null indicates the sub-problem not processed yet
        return dfs(s, p, 0, 0, m, n, M) // The problem: to match s[i, m), p[j, n)
    }

    // the sub-problem: to match[i, m
    private fun dfs(s: String, p: String, i: Int, j: Int, m: Int, n: Int, M: Array<Array<Boolean?>>): Boolean {
        if (j == n) return i == m
        if (M[i][j] != null) return M[i][j]!!
        val c2 = p[j]
        return if (j < n - 1 && p[j + 1] == '*')
            dfs(s, p, i, j + 2, m, n, M) ||  // do not match 'x*' , x means any char or . (use'*' as 0 char)
                    (i < m && match(s[i], c2) && dfs(s, p, i + 1, j, m, n, M)
                        .also {
                            M[i][j] = it // match 1 char in string for '*'
                        }
                            )
        else i < m && match(s[i], c2) && dfs(s, p, i + 1, j + 1, m, n, M)
            .also {
                M[i][j] = it // match 1 char from both sides
            }
    }

    private fun match(c1: Char, c2: Char): Boolean {
        return if (c2 == '.') true else c1 == c2
    }

    fun isMatch2(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val M = Array(m + 1) { BooleanArray(n + 1) }
        for (i in m downTo 0) {
            for (j in n downTo 0) {
                if (j == n) {
                    M[i][j] = i == m
                } else if (j + 1 < n && p[j + 1] == '*') {
                    M[i][j] = M[i][j + 2] || (i < m && match(s[i], p[j]) && M[i + 1][j])
                } else { // j == cols - 1 || j < cols - 1 && p.charAt(j + 1) != '*'
                    M[i][j] = i < m && match(s[i], p[j]) && M[i + 1][j + 1]
                }
            }
        }
        return M[0][0]
    }

    fun isMatch3(str: String, ptn: String): Boolean {
        if (ptn == ".*") return true
        val s = str.toCharArray()
        val p = ptn.toCharArray()
        val m = s.size
        val n = p.size

        // left to right, add '' at the beginning, so dp[i+1][j+1] means match s[0, j] vs p[0, j]
        val dp = Array(m + 1) { BooleanArray(n + 1) }
        dp[0][0] = true
        for (j in 0 until n)  // fill i = 0
            dp[0][j + 1] = p[j] == '*' && dp[0][j - 1] // "ab" vs "a*b*c*"

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (p[j] == '*')
                    dp[i + 1][j + 1] =
                        dp[i + 1][j - 1] ||  // use '*' as 0 char, check back j-1(j-2 in p)
                                (match(
                                    s[i],
                                    p[j - 1]
                                ) && dp[i][j + 1]) // use '*' to match 1 more char, i must match j-1, s[0,i-1] must match p[0,j-1]
                else
                    dp[i + 1][j + 1] = match(s[i], p[j]) && dp[i][j] // normal match
            }
        }
        return dp[m][n]
    }
}