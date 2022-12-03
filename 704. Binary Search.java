// binary search time complexity O(logn) --> recursion
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }
    
    public int binarySearch(int start, int end, int[] nums, int target) {
        if (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) return binarySearch(mid + 1, end, nums, target);
            else if (nums[mid] > target) return binarySearch(start, mid - 1, nums, target);
        }
        return -1;
    }
}
