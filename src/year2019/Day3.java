package year2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        try{
            Scanner reader = new Scanner(new File("src/year2019/directions.txt"));
            ArrayList<String> directions = new ArrayList<>();

            while(reader.hasNextLine()){
                directions.add(reader.nextLine());
            }

            int[][] board = createBoard(directions);
//            for(int[] row: board){
//                System.out.println(row);
//            }



        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }

    }

    private static int[][]createBoard(ArrayList<String> directions){
        int maxX, maxY;
        maxX = maxY = 0;
        String[] wire1 = directions.get(0).split(",");
        String[] wire2 = directions.get(1).split(",");
        for(String instruction: wire1){
            if(String.valueOf(instruction.charAt(0)).equals("U") || String.valueOf(instruction.charAt(0)).equals("D")){
                maxX += Integer.parseInt(instruction.substring(1));
            }else{
                maxY += Integer.parseInt(instruction.substring(1));
            }
        }

        for(String instruction: wire2) {
            if (String.valueOf(instruction.charAt(0)).equals("U") || String.valueOf(instruction.charAt(0)).equals("D")) {
                maxX += Integer.parseInt(instruction.substring(1));
            } else {
                maxY += Integer.parseInt(instruction.substring(1));
            }
        }
        System.out.println(maxX + " " + maxY);
        return new int[maxY][maxX];
    }
}
