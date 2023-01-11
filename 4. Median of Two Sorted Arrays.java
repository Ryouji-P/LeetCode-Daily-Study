/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


**/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if (x > y) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = x;

        while (low <= high) {
            int midX = (low + high) / 2;
            int midY = (x + y + 1) / 2 - midX;

            int maxLeftX = (midX == 0) ? Integer.MIN_VALUE : nums1[midX - 1];
            int minRightX = (midX == x) ? Integer.MAX_VALUE : nums1[midX];

            int maxLeftY = (midY == 0) ? Integer.MIN_VALUE : nums2[midY - 1];
            int minRightY = (midY == y) ? Integer.MAX_VALUE : nums2[midY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) high = midX - 1;
            else low = midX + 1;

        }
        return 0;
    }
}
