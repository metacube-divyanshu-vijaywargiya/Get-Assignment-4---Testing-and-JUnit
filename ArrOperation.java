package com.metacube;

public class ArrOperation {
	/**
	 * To count clumps in an array
	 * @param numberArray as argument to find clumps
	 * @return integer clumpsCount in array
	 * @throws AssertionError
	 */
	public int countClumps(int [] numberArray)  throws AssertionError {
		if(numberArray.length == 0) {
			throw new AssertionError("Number array must be of size greater than 0.");
		}
		int clumpsCount =0 ;
		boolean isClump = false;
		
		for ( int i=1; i< numberArray.length; i++ ) {
			if ( numberArray[i] == numberArray[i-1] ) {
				if ( !isClump ) {
					clumpsCount++;
					isClump= true;
				}
			} else {
				isClump = false;
			}
		}
		
		return clumpsCount;
	}
	
	/**
	 * To find Index from which left and right array sum is equal
	 * @param numberArray as argument to find index to split
	 * @return integer where left and right array sum is equal
	 * @throws AssertionError
	 */
	public int splitArray(int[] numberArray) throws AssertionError {
		if(numberArray.length == 0) {
			throw new AssertionError("Array should not be empty.");
		}
		int totalSumOfArray = 0;
		
		for ( int singleNumber : numberArray ) {
			totalSumOfArray += singleNumber;
		}
		
		int leftSum =0;
		for ( int i=0; i < numberArray.length; i++ ) {
			leftSum += numberArray[i];
			
			if ( leftSum*2 == totalSumOfArray ) {
				return i+1;
			}
		}
		
		return -1;		
	}
	
	/**
	 * To rearrange it so that every X is immediately followed by a Y
	 * @param numberArray array to rearrange 
	 * @return array it will return rearranged array 
	 * @throws AssertionError
	 */
	public int[] fixXY(int[] numberArray, int userInputX, int userInputY) throws AssertionError {
		int arrayLength = numberArray.length;
		if(arrayLength == 0) {
			throw new AssertionError("Number array must be of size greater than 0.");
		}
		
	    int countX = 0;
	    int countY = 0;

	    // First Count occurrences of X and Y
	    for (int number : numberArray) {
	        if (number == userInputX) {
	            countX++;
	        } else if (number == userInputY) {
	            countY++;
	        }
	    }

	    // Check If there are unequal numbers of X and Y in input array.
	    if (countX != countY) {
	        throw new AssertionError("Unequal numbers of " + userInputX + " and " + userInputY + " in the array.");
	    }
	    
	    
	    // Check If two adjacent X values are there and If X occurs at the last index of array.
	    for (int i = 0; i < arrayLength; i++) {
	        if (numberArray[i] == userInputX) {
	            // Check for adjacent X values
	            if (i < numberArray.length - 1 && numberArray[i + 1] == userInputX) {
	                throw new AssertionError("Two adjacent " + userInputX + " values are not allowed.");
	            }
	            // Check if X occurs at last index
	            if (i == arrayLength - 1) {
	                throw new AssertionError(userInputX + " cannot occur at the last index of the array.");
	            }
	        }
	    }
	    
		int i = 0;
		int j = 0;
		
		while ( j < arrayLength && numberArray[j] != userInputY ) {
			j++;
		}
		
		while ( i < arrayLength) {
			if( numberArray[i] == userInputX ) {
	            int temp = numberArray[i+1];
	            numberArray[i+1] = numberArray[j];
	            numberArray[j] = temp;
	            
	            while ((j < arrayLength && numberArray[j] != userInputY) || (j == i+1) ) {
	            	j++;
	            }
			}
			i++;
		}
		
		return numberArray;
	}
	
	/**
	 * To find size of the largest mirror section
	 * @param array as argument to find largest mirror
	 * @return integer the size of the largest mirror 
	 * @throws AssertionError
	 */
	public int maxMirror(int[] numberArray)  throws AssertionError {
		if(numberArray.length == 0) {
			throw new AssertionError("Number array must be of size greater than 0.");
		}
		int arrayLength = numberArray.length;
	    int max = 0;
	    
	    for ( int i = 0; i < arrayLength; i++ ) {
	        int count = 0;
	        for ( int j = arrayLength - 1; j >= 0 && i + count < arrayLength; j-- ) {
	            if ( numberArray[i + count] == numberArray[j] ) {
	                count++;
	            } else {
	                max = Math.max(max, count);
	                count = 0;
	            }
	        }
	                                                                
	        max = Math.max(max, count);
	    }

	    return max;
	}

}
