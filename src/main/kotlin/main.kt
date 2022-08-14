fun main(args: Array<String>) {
    val list = mutableListOf(10, 1, 5)
    ReverseList().reverseList(list)
    println(list)

    val unique = Unique()
    println("isUnique: ${unique.isUnique("abc")}, isUnique2: ${unique.isUnique2("abc")}, isUnique3: ${unique.isUnique3("abca")}")
    println("isPermutation: ${Permutation().isPermutation2("abb", "bac")}")

    val list1 = buildList1()
    val list2 = buildList2()
    val result = Solution2().addTwoNumbers(list1, list2)
    var head = result
    while (head != null) {
        print(head.`val`)
        head = head.next
    }
    println("\nFINISHED")

    val solution3 = Solution3()
    println(solution3.lengthOfLongestSubstring("abcabcbb"))
    println(solution3.lengthOfLongestSubstring2p("abcabcbb"))

    val solution4 = Solution4()
    println(solution4.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))

    println(Solution5().longestPalindrome("abbaba"))
    println(Solution6().convert("ABCDE", 4))
    println(Solution7().reverse(1534236469))
    println(Solution8().myAtoi("-91283472332"))
    println(Solution9().isPalindrome(1000021))
    println(Solution10().isMatch2("ab", ".*c"))
//    println(Solution11().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(Solution11().maxArea(intArrayOf(1,2,4,3)))
    println(Solution12().intToRoman(1994))
    println(Solution13().romanToInt("MCMXCIV"))
}

private fun buildList1(): ListNode {
    val result = ListNode(9)
    var head: ListNode? = result
    for (i in 1..6) {
        head!!.next = ListNode(9)
        head = head.next
    }
    return result
}

private fun buildList2(): ListNode {
    val result = ListNode(9)
    var head: ListNode? = result
    for (i in 1..3) {
        head!!.next = ListNode(9)
        head = head.next
    }
    return result
}
