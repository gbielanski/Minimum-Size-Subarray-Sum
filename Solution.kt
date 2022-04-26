class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minSubArrayLen = Int.MAX_VALUE
        var subArrayLen = 0
        var subArraySum = 0
        var k = 0

        for (num in nums) {
            subArrayLen++
            subArraySum += num

            while (subArraySum >= target) {
                if (minSubArrayLen > subArrayLen) {
                    minSubArrayLen = subArrayLen
                }

                subArraySum -= nums[k++]
                subArrayLen--
            }
        }

        return if (minSubArrayLen == Int.MAX_VALUE) 0 else minSubArrayLen
    }
}