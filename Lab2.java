public class Lab2 {
        //// HELPER METHODS ARE AT THE BOTTOM, THANK YOU :) ////
    public static void cleanSquare()
        {
        Robot.load("square.txt");
        Robot.setDelay(0.05);

        //This code runs for every block, for a total of 29 times.
        //The robot begins at its starting spot.
        for (int times=0; times < 28; times++) {
            //The robot makes everything light regardless of whether
            //it is on dark or not.
            Lab2.changeToLight();
            if (Robot.frontIsClear() == false) {
                //When the robot reaches the corner, it turns left.
                Robot.turnLeft();
            } else {
                //If the robot is not at a corner (which means that it can
                //move foward), it moves foward.
                Robot.move();
            }
        }; 
        //When this loop is complete, all light squares should be gone 
        //and the robot will be at its starting location.
        
    }
        
        
    public static void darkenComb()
    {
        Robot.load("comb.txt");
        Robot.setDelay(0.05);
        
        // NEW CODE : for an infinitely long prongs and combs. No Variables
        int combLength = 0; // This variable tracks how long the comb is.
        
        //This loop calculates how long the comb is, ending at the top.
        while (Robot.frontIsClear()){
            Robot.move();
            Robot.move();
            combLength++;
        }
        
        //This loop brings the robot back to its starting position.
        Lab2.turnAround();
        while (Robot.frontIsClear()){
            Robot.move();
        }
        Lab2.turnAround();
        
        //This loop colors in prongs.
        while (combLength >= 0) {
            Lab2.turnRight();
            //This loop makes every block dark until the end of the prong.
            while (Robot.frontIsClear()) {
                Robot.makeDark();
                Robot.move();
            }
            Robot.makeDark();
            Lab2.turnAround();
            
            //This loop returns the robot to the beginning of the prong.
            while (Robot.frontIsClear()) {
                Robot.move();
            }
            
            //This olors in the ridge of the comb.
            Lab2.turnRight();
            Lab2.moveWithCondition();
            Lab2.changeToDark();
            Lab2.moveWithCondition();
            combLength--;
        }
        
        /*
            // OLD CODE : Works only for the assignment's map.
            //Draws comb 
            for (int drawComb = 0; drawComb <= 4; drawComb++) {
                Lab2.turnRight();
                
                //Draws the individual prong (Draws line and heads back)
                for (int prong =0; prong <=1; prong++) {
                    
                    //Draws a line to the end
                    for (int line = 0; line <= 6; line++) { 
                        Lab2.moveWithCondition();
                        Lab2.changeToDark();
                    }
                    Lab2.turnAround();
                }
                
                //Colors in the ridge of the comb.
                Robot.turnLeft();
                Lab2.moveWithCondition();
                Lab2.changeToDark();
                Lab2.moveWithCondition();
                Lab2.changeToDark();
            };
            */
           
    }; 
        
        
        public static void makeCheckered()
        {
            Robot.load("blank.txt");
            Robot.setDelay(0.05);
            // NEW CODE : Infinitely large checkerboards.
            
            boolean needMoreCheckers = true; 
            // Stops the robot when the boar is complete
            int yTotalDimension = 1;
            // Calculates how tall the checkerboard is.
            int yCurrent = 1;
            // Calculates where the robot is.
            boolean goingUp = true; 
            // Tests if the robot is going up.
            boolean isPlacingDark = true;
            // Tests if the next block is going to be dark.
            
            // This loop calculates how tall the checkerboard is.
            while (Robot.frontIsClear()){
                Robot.move();
                yCurrent++;
            }
            yTotalDimension = yCurrent;
            
            // This loop brings the robot back to its starting position.
            Lab2.turnAround();
            while (Robot.frontIsClear()){
                Robot.move();
            }
            Lab2.turnAround();
            yCurrent = 1;
            
            while (needMoreCheckers == true) {
                // This loop continuously places down an alternating
                // pattern of dark->light->dark->... until it is obstructed.
                while (yCurrent < yTotalDimension) {
                    if (isPlacingDark == true) {
                        Lab2.changeToDark();
                        Robot.move();
                        isPlacingDark = false;
                    } else {
                        Lab2.changeToLight();
                        Robot.move();
                        isPlacingDark = true;
                    } 
                    yCurrent++;
                }   
                yCurrent = 1;
                
                // Brings the robot to the next column.
                if (goingUp == true) {
                    //If the robot was moving upward, it will turn Right.
                    Lab2.turnRight();
                    //Then it checks if it can move foward. 
                    //If it can not move foward, that means it has reached
                    //the end of the map.
                    if (Robot.frontIsClear()) {
                        Robot.move();
                        Lab2.turnRight();
                        if (isPlacingDark == true) {
                        Lab2.changeToDark();
                        isPlacingDark = false;
                    } else {
                        Lab2.changeToLight();
                        isPlacingDark = true;
                        }
                        goingUp = false;
                    } else {
                        needMoreCheckers = false;
                    }
                } else {
                    //If the robot was moving downward, it will turn Left.
                    Robot.turnLeft();
                    //Then it checks if it can move foward. 
                    //If it can not move foward, that means it has reached
                    //the end of the map.
                    if (Robot.frontIsClear()) {
                        Robot.move();
                        Robot.turnLeft();
                        if (isPlacingDark == true) {
                            Lab2.changeToDark();
                            isPlacingDark = false;
                        } else {
                            Lab2.changeToLight();
                            isPlacingDark = true;
                        }
                        goingUp = true;
                    } else {
                        needMoreCheckers = false;
                    }
                }
            }
                

                /*
                // OLD CODE : Only works for the assignment's map.
                int upDown = 0;
                // 0 = Robot is going up : 1 = Robot is going down
            
                //This for loop calculates the amount of columns.
                for (int repeat = 0; repeat <= 7; repeat++) {
                  //This for loop calculates the amount of rows in the columns.
                  for (int move = 0; move <= 7; move++) {
                        if (move % 2 == 1) {
                            Lab2.changeToDark();
                            Lab2.moveWithCondition();
                        } else {
                            Lab2.changeToLight();
                            Lab2.moveWithCondition();
                        }
                  }
                    if (upDown == 0) {
                        Lab2.turnRight();
                        Lab2.moveWithCondition();
                        Lab2.turnRight();
                        upDown = 1;
                        
                    } else if (upDown == 1) { 
                        Robot.turnLeft();
                        Lab2.moveWithCondition();
                        Robot.turnLeft();
                        upDown = 0;
                    
                    }
                } */
        }
         
    
       //////////////////////////////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       ///////////////////////HEALPER METHODS ///////////////////////////////
       //////////////////////////////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////
       
      public static void turnRight() 
        {
            Robot.turnLeft();
            Robot.turnLeft();
            Robot.turnLeft();
        };
      public static void changeToLight() 
        {
            if (Robot.onDark() == true) {
                Robot.makeLight();
            }
        } 
      public static void changeToDark() 
        {
            if (Robot.onDark() != true) {
                Robot.makeDark();
            } 
        } 
      public static void moveWithCondition()
        { 
            if (Robot.frontIsClear() == true) {
                Robot.move();
          }
        };
      public static void turnAround() {
            Robot.turnLeft();
            Robot.turnLeft();
        };
      
        
    //////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    
}
