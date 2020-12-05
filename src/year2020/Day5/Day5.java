package year2020.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        try{

            Scanner reader = new Scanner(new File("src/year2020/Day5/passes.txt"));
            ArrayList<String> boardingPasses = new ArrayList<>();
            while(reader.hasNextLine()){
                boardingPasses.add(reader.nextLine());
            }

            ArrayList<Integer> allSeatIds = getAllSeatIds(boardingPasses);
            System.out.println("Highest seat ID " + allSeatIds.get(allSeatIds.size() - 1));
            System.out.println("My sear ID " + getMySeatId(allSeatIds));


        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }

    private static int getMySeatId(ArrayList<Integer> allSeatIds){
        for(int i = 1; i < allSeatIds.size(); i++){
            if(allSeatIds.get( i+1) != allSeatIds.get(i) + 1){
                return allSeatIds.get(i) + 1;
            }
        }
        return 0;
    }

    private static ArrayList<Integer> getAllSeatIds(ArrayList<String> boardingPasses){
        ArrayList<Integer> allSeatIds = new ArrayList<>();
        ArrayList<Integer> rows;
        ArrayList<Integer> columns;
        for(String boardingPass: boardingPasses){
            rows = populateArray(127);
            columns = populateArray( 7);
            for (int i = 0; i < boardingPass.length(); i++){
                if( String.valueOf(boardingPass.charAt(i)).equals("F")){
                    removeBetween(rows, (rows.size() / 2), rows.size() - 1);
                }else if( String.valueOf(boardingPass.charAt(i)).equals("B")){
                    removeBetween(rows, 0, rows.size() / 2 - 1);
                }else if( String.valueOf(boardingPass.charAt(i)).equals("L")){
                    removeBetween(columns, (columns.size() / 2)  , columns.size() -1 );
                }else if( String.valueOf(boardingPass.charAt(i)).equals("R")){
                    removeBetween(columns, 0, columns.size()/2 -1);
                }
            }
            allSeatIds.add(getSeatId(rows.get(0), columns.get(0)));
        }
        Collections.sort(allSeatIds);
        return allSeatIds;
    }

    private static ArrayList<Integer> populateArray(int max){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i <= max; i++){
            numbers.add(i);
        }
        return numbers;
    }

    private static void removeBetween(ArrayList<Integer> numbers, int from, int to){
        for(int i = to; i >= from; i--){
            numbers.remove(i);
        }
    }

    private static int getSeatId(int row, int column){
        return row * 8 + column;
    }
}
