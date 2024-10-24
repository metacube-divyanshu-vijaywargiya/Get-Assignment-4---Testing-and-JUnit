package com.metacube;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestClass {
	ArrOperation arrOperation = new ArrOperation();
	
	//Test for max mirror 
	@Test
	public void maxMirrorTest() {
		
        Object[][] testCases = {
                {new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3}, // Expected mirror sequence: [3, 2, 1]
                {new int[]{1, 2, 3, 2, 1}, 5},          // Expected mirror sequence: [1, 2, 3, 2, 1]
                {new int[]{1, 2, 3, 4, 5}, 1},          // Expected mirror sequence: [1] or [2] or [3] or [4] or [5]
                {new int[]{5, 6, 7, 8, 9, 7, 6, 5}, 3}, // Expected mirror sequence: [5, 6, 7]
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1}  // Expected mirror sequence: [1] or [2] or ... [8]
            };

        // iterate through each test case in testCases
        for (Object[] testCase : testCases) {
            int[] inputArray = (int[]) testCase[0];		
            int expectedOutput = (int) testCase[1];
            int actualOutput = arrOperation.maxMirror(inputArray);
            assertEquals(expectedOutput, actualOutput);
        }
	}
	
	
	//Test for clumps count
	@Test
	public void countClumpsTest() {
		
        Object[][] testCases = {
                {new int[]{1, 2, 2, 3, 4, 4}, 2},		// Expected clumps count: 2
                {new int[]{1, 1, 2, 1, 1}, 2},			// Expected clumps count: 2
                {new int[]{1, 1, 1, 1, 1}, 1},     		// Expected clumps count: 1
            };
        
        // iterate through each test case in testCases
        for (Object[] testCase : testCases) {
            int[] inputArray = (int[]) testCase[0];
            int expectedOutput = (int) testCase[1];
            int actualOutput = arrOperation.countClumps(inputArray);
            assertEquals(expectedOutput, actualOutput);
        }
	}
	
	
	//Test for splitArray
	@Test
	public void splitArrayTest() {
		
	     Object[][] testCases = {
	                {new int[]{1, 1, 1, 2, 1}, 3},			// Expected split array index: 3
	                {new int[]{2, 1, 1, 2, 1}, -1},			// Expected split array index: -1
	                {new int[]{10, 10}, 1},					// Expected split array index: 1
	           };
	     
	     // iterate through each test case in testCases
	     for (Object[] testCase : testCases) {
	         int[] inputArray = (int[]) testCase[0];
	         int expectedOutput = (int) testCase[1];
	         int actualOutput = arrOperation.splitArray(inputArray);
	         assertEquals(expectedOutput, actualOutput);
	     }
	}
	
	
	//Test to fixXY , Rearrange array
	@Test
	public void fixXYTest() {
		
        Object[][] testCases = {
                {new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}},				// Expected rearranged array: {9, 4, 5, 4, 5, 9}
                {new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}},							// Expected rearranged array: {1, 4, 5, 1}
                {new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}},     	// Expected rearranged array: {1, 4, 5, 1, 1, 4, 5}
            };
        
	     // iterate through each test case in testCases
	     for (Object[] testCase : testCases) {
	         int[] inputArray = (int[]) testCase[0];
	         int[] expectedOutput = (int[]) testCase[1];
	         int[] actualOutput = arrOperation.fixXY(inputArray,4,5);
	         assertArrayEquals(expectedOutput, actualOutput);
	     }
	}
}
