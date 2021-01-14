package org.atanu.java.ds.array;

public class JumpGameTwo {

	public static int jump(int[] nums) {

		int jump = 1;

		int canTillJump = nums[0]; // How Far we can reach for next step
		int maxJump = nums[0]; // How Far we can already Reach

		for(int i = 1; i < nums.length; i++){

			if(i > maxJump){

				++jump;
				maxJump = Math.max(maxJump, canTillJump);
				if(maxJump >= nums.length -1){
					return jump;
				}
			}

			canTillJump = Math.max(canTillJump, i + nums[i] );
		}

		return jump;
	}
	

     //[0] case	
	 public static int jumpTwo(int[] nums) {
	       
	        int jump = 0;
	        
	        int canTillJump = 0; // How Far we can reach for next step
	        int maxJump = 0; // How Far we can already Reach
	        
	        for(int i = 0; i < nums.length; i++){
	            
	            if(i > maxJump){
	                
	                ++jump;
					maxJump = Math.max(maxJump, canTillJump);
					System.out.println(maxJump);
	                if(maxJump >= nums.length -1){
	                    return jump;
	                }
	            }
	            
	            canTillJump = Math.max(canTillJump, i + nums[i] );
	        }
	        
	        return jump;
	    }
	public static void main(String[] args) {
		
		int[] nums = new int[] {2,3,1,1,4};
		int[] nums1 = new int[] {1, 4, 3, 7, 1, 2, 6, 7, 6, 10};
		
		int result = jumpTwo(nums1);
		System.out.println("Minimum jump required is "+ result);
	}

}
