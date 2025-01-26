/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.exerc;

import java.util.Arrays;

public class Exerc01 {

    /**
     * Computes the product of all elements in the array except 
     * the current element at each index. 
     * You are not allowed to use division.
     * 
     * Note: You can assume the products fit within int data type.
     *
     * @param nums an array of integers
     * @return an array where each element at index i is the 
     *          product of all elements in nums except nums[i]
     * @throws IllegalArgumentException if nums is null or has 
     *          fewer than 2 elements
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least 2 elements.");
        }

        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; ++i) {
            int ans = 1;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                ans *= nums[j];
            }
            result[i] = ans;
        }

        return result;
        // Let's find out the big-O of this solution.
        // Input size: n -> input array length.
        // Operations to count: multiplications.
        // Total multiplications: 1 * (n - 1) * n = n^2 - n
        // O(n^2)

        // This is O(n^2). Too slow as you can see from the examples.

        // To be improved with the following idea. (See below).
        // Focus on index 2 as an example.
        // IDX: 0,   1, >2<,  3
        // Inp: 1,   2, >3<, 4
        // LHS product: 1 * 2
        // RHS product: 4
        // OUT: 24, 12, >8<, 6
        // Do a running product for LHS for each position in one pass.
        // Do a running product for RHS for each position in one pass.
        // Use them to produce the answer in another one pass.
    }
    
    /**
     * Computes the product of all elements in the array except 
     * the current element at each index. 
     * You are not allowed to use division.
     * 
     * Note: You can assume the products fit within int data type.
     *
     * @param nums an array of integers
     * @return an array where each element at index i is the 
     *          product of all elements in nums except nums[i]
     * @throws IllegalArgumentException if nums is null or has 
     *          fewer than 2 elements
     */
    public static int[] productExceptSelf_improved(int[] nums) {
        // The idea on an example input:
        // INP { 1,  2,  3, 4}
        // LHS { 1,  1,  2, 6} <- You can create this in one pass through the array.
        // RHS {24, 12,  4, 1} <- You can create this in one pass through the array.
        // ANS {24, 12,  8, 6} <- You can create this in one pass through the array.

        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least 2 elements.");
        }

        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        
        for (int i = 1; i < n; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; --i) {
            result[i]  =  result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
        // Let's find out the big-O of this solution.
        // Input size: n -> input array length.
        // Operations to count: multiplications.
        // Total multiplications: 1 * (n - 1) + 2 * (n) = n - 1 + 2n = 3n - 1
        // O(N)
    }

    public static void main(String[] args) {
        // Input 1.
        int[] nums1 = {1, 2, 3, 4}; // {24, 12, 8, 6}
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output from naive: " + Arrays.toString(productExceptSelf(nums1)));
        System.out.println("Output from improved: " + Arrays.toString(productExceptSelf_improved(nums1)));
        System.out.println();



        // Input 2.
        int[] nums2 = {0, 1, 2, 3}; // Expected output: [6, 0, 0, 0]
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output from naive: " + Arrays.toString(productExceptSelf(nums2)));
        System.out.println("Output from improved: " + Arrays.toString(productExceptSelf_improved(nums2)));
        System.out.println();



        // Input 3.
        int[] nums3 = {1, 1, 1, 1}; // Expected output: [1, 1, 1, 1]
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output from naive: " + Arrays.toString(productExceptSelf(nums3)));
        System.out.println("Output from improved: " + Arrays.toString(productExceptSelf_improved(nums3)));
        System.out.println();



        // Input 4.
        int[] nums4 = {2, 2, 1, 2, 2}; // Expected output: [8, 8, 16, 8, 8]
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output from naive: " + Arrays.toString(productExceptSelf(nums4)));
        System.out.println("Output from improved: " + Arrays.toString(productExceptSelf_improved(nums4)));
        System.out.println();



        // Initializing time variables for later use.
        long startTime = 0;
        long endTime = 0;



        // Input 5 (a large array).
        int[] nums5 = new int[100_000];
        Arrays.fill(nums5, 1);

        // The large input for the naive version.
        System.out.println("Starting the large array (100k) processing (naive)...");

        startTime = System.nanoTime();
        productExceptSelf(nums5);
        endTime = System.nanoTime();

        System.out.println("Done!");
        System.out.println("Duration (naive): " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
        System.out.println();

        // The large input for the improved version.
        System.out.println("Starting the large array (100k) processing (improved)...");

        startTime = System.nanoTime();
        productExceptSelf_improved(nums5);
        endTime = System.nanoTime();

        System.out.println("Done!");
        System.out.println("Duration: " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
        System.out.println();



        // Input 6 (even larger array).
        int[] nums6 = new int[1_000_000];
        Arrays.fill(nums6, 1);

        // The larger input for the improved version. 
        // (The naive version is not included because it took too much time).
        System.out.println("Starting the larger array (1M) processing (improved)...");

        startTime = System.nanoTime();
        productExceptSelf_improved(nums6);
        endTime = System.nanoTime();

        System.out.println("Done!");
        System.out.println("Duration: " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
        System.out.println();

    }
}