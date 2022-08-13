class Unique {
    fun isUnique(string: String): Boolean {
        val set = mutableSetOf<Char>()
        for (i in string.indices) {
            if (set.contains(string[i])) {
                return false
            }
            set.add(string[i])
        }

        return true
    }

    fun isUnique2(string: String): Boolean {
        var bitField = 0
        for (i in string.indices) {
            if (bitField and (string[i] - 'a') != 0) {
                return false
            }
            bitField = bitField or (string[i] - 'a')
        }

        return true
    }

    fun isUnique3(string: String): Boolean {
        val chars = string.toCharArray()
        chars.sort()
        for (i in 0 until chars.size - 1) {
            if (chars[i] == chars[i + 1]) {
                return false
            }
        }
        return true
    }
}