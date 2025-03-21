package org.example;


/**
 * 2149. Rearrange Array Elements by Sign
 */
public class Main {
    public static void main(String[] args) {
        rearrangeArray2(new int[]{-1, 1});
    }


    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;

        int[] result = new int[n];
        for (int num : nums) {
            if (num > 0) {
                result[pos] = num;
                pos += 2;
            } else {
                result[neg] = num;
                neg += 2;
            }
        }
        return result;
    }


    /**
     * my first draft, not tested well
     *
     * @param nums
     * @return
     */
    public static int[] rearrangeArray2(int[] nums) {
        int positives = 0;
        int negatives = 1;
        int i = 0; // searchIndex for positives
        int j = 0; // searchIndex for negatives
        while (true) {
            // looking for positives
            if (nums[i] < 0 && i < nums.length - 1) {
                i++;
            }

            // looking for negatives
            if (nums[j] > 0 && j < nums.length - 1) {
                j++;
            }

            // changing
            if (nums[i] > 0 && nums[j] < 0) {

                // positives
                if (i != positives) {
                    swap(nums, positives, i);
                }
                positives += 2;
                if (i <= positives) {
                    i = positives;
                }


                // negatives
                if (j != negatives) {
                    swap(nums, negatives, j);
                }
                negatives += 2;

                if (j <= negatives) {
                    j = positives;
                }
            }

            if (positives >= nums.length - 2 && negatives >= nums.length - 1) {
                break;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}