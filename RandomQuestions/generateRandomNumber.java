/*package whatever //do not write package name here */

import java.io.*;

class Random {
    static int currentRandom; 
    int maxNumber; 
    int leftToRandom;
    int rightToRandom; 
	public static void main (String[] args) {
	    Random randomNumber = new Random(6); 
	    int iterations = 10; 
	    while(iterations-->0) {
	        System.out.println(randomNumber.getRandomNumber());
	    }
    }
	public Random(int maxNumber){
	   this.maxNumber = maxNumber; 
	   setRandomAttributes(); 
	}
    
	public int getRandomNumber() {
	int randomNumber = currentRandom;  
	int availableNumbers = (maxNumber - rightToRandom + 1) + leftToRandom;
	
	if(availableNumbers == 0) {
	   int lastRandomNumber = randomNumber;
	   setRandomAttributes();
	   return lastRandomNumber;
	}
	
	if(availableNumbers % 2 == 0) {
	    currentRandom = leftToRandom; 
	    if(leftToRandom > 0)
	        leftToRandom--; 
	}else {
	   currentRandom = rightToRandom; 
	   if(rightToRandom <= maxNumber) 
	        rightToRandom++; 
	}
	    return randomNumber;
	}
	
    void setRandomAttributes(){
       if(maxNumber % 2 != 0)
	    currentRandom = maxNumber / 2 + 1; 
	   else
	    currentRandom = maxNumber / 2;
	    
	   leftToRandom = currentRandom - 1;
	   rightToRandom = currentRandom + 1;;
    }
}
