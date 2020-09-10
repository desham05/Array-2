// Time Complexity : O(N) - Iterated through given array of length N
// Space Complexity : O(1) - returned the created list so no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// iterate through the array
// take the each element and negate the index which is equal to that element - here we are negating the number as we need the number further
// at last we are left with the index as missing numbers where the numbers are positive
// this will work only if we have positive numbers

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return output;
        }
        
        
        for(int i =0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *= -1;   
            }
        }
        
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0){
                output.add(i+1);
            }
        }
        
        return output;
    }
}