package GrokkingDynamicProgramming.Pattern5LongestCommonSubstring;

public class LongestBitonicSubsequence {
    public int recursionSolvtion(int[] nums){
        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            int c1 = findLDSLength(nums, i, -1);
            int c2 = findLDSLengthRev(nums, i, -1);
            maxLength = Math.max(maxLength, c1+c2-1);
        }
        return maxLength;
    }
    private int findLDSLength(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + findLDSLength(nums, currentIndex+1, currentIndex);

        // excluding the number at currentIndex
        int c2 = findLDSLength(nums, currentIndex+1, previousIndex);

        return Math.max(c1, c2);
    }

    private int findLDSLengthRev(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex < 0)
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + findLDSLengthRev(nums, currentIndex-1, currentIndex);

        // excluding the number at currentIndex
        int c2 = findLDSLengthRev(nums, currentIndex-1, previousIndex);

        return Math.max(c1, c2);
    }

    private int dpSolver(int[] nums){
        int[] lds = new int[nums.length];
        int[] ldsReverse = new int[nums.length];

        // find LDS for every index up to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            lds[i] = 1; // every element is an LDS of length 1
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
        }

        // find LDS for every index up to the end of the array
        for (int i = nums.length - 1; i >= 0; i--) {
            ldsReverse[i] = 1; // every element is an LDS of length 1
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[i]) {
                    ldsReverse[i] = Math.max(ldsReverse[i], ldsReverse[j] + 1);
                }
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lds[i] + ldsReverse[i] - 1);
        }

        return maxLength;

    }
}
