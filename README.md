# Leetcode problem 209. Minimum-Size-Subarray-Sum

This repository contains solution and tests of [Leetcode problem 209. Minimum-Size-Subarray-Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) written in Kotlin language

## Solution

```Kotlin
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
```


## Tests

```Kotlin
import org.junit.Assert.*
import org.junit.Test

class SolutionTest {
    @Test
    internal fun `when target is 7 and nums are 2,3,1,2,4,3 should return 2`() {
        val target = 7
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)
        val solution = Solution()

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(2, result)
    }

    @Test
    internal fun `when target is 4 and nums are 1,4,4 should return 1`() {
        val target = 4
        val nums = intArrayOf(1, 4, 4)
        val solution = Solution()

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(1, result)
    }

    @Test
    internal fun `when target is 11 and nums are 1,1,1,1,1,1,1,1 should return 0`() {
        val target = 11
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        val solution = Solution()

        val result = solution.minSubArrayLen(target, nums)

        assertEquals(0, result)
    }
}
```