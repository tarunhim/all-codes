/*
 * On an infinite plane, a robot intitially stands (0,0) and faces north. The robot
 * can receive one of three instructions:
 * "G": go strainght 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right;
 * 
 * the robot performs the instuctions given in order and repeats then forever
 * 
 * return true only if there exists a circle in the plane such that the 
 * robot never leaves the circle.
 */

import java.util.*;
import java.io.*;

class Main1 {
    public static void main(String[] args) {
    String str = "GGLGRGRGLGL";
    int[] currLoc = {0,0};
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    int curr = 0;
    for(int i = 0; i < str.length(); ++i) {
        if(str.charAt(i) == 'L') {
            curr = curr == 0 ? 3 : curr-1;
        } else if(str.charAt(i) == 'R') {
            curr = curr == 3 ? 0 : curr+1;
        } else {
            currLoc[0] += dir[curr][0];
            currLoc[1] += dir[curr][1];
        }
    }
    if(curr != 0 || (currLoc[0] == 0 && currLoc[1] == 0)) {
        System.out.print("circle");
    } else System.out.print("Not circle");
    
    }
    
}