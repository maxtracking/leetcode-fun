class Permutation {
    fun isPermutation(string1: String, string2: String): Boolean {
        if (string1.length != string2.length) {
            return false
        }
        val chars1 = string1.toCharArray()
        chars1.sort() // n log(n)
        val chars2 = string2.toCharArray()
        chars2.sort() // m log(m)
        return chars1.contentEquals(chars2) // max(m, n)
        // nlog(n) + mlog(m) + max(m,n) = 2nlog(n) + n ~ nlog(n)
    }

    fun isPermutation2(string1: String, string2: String): Boolean {
        if (string1.length != string2.length) {
            return false
        }
        val set1 = string1.toSet() // n
        for (element in string2) { // m
            if (set1.contains(element).not()) {
                return false
            }
        }
        // max(m,n)
        return true
    }
}