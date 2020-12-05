package year2020.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        try{
            Scanner reader = new Scanner(new File ("src/year2020/Day3/map.txt"));
            ArrayList<String> map = new ArrayList<>();
            String[] slopes = {"1,1","3,1","5,1","7,1","1,2"};

            while(reader.hasNextLine()){
                map.add(reader.nextLine());
            }

            System.out.println("Total trees " + traverseForest(map));
            System.out.println("Total trees " + traverseForestPart2(map, slopes));

        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    private static int traverseForest(ArrayList<String> map){
        int yPointer = 0;
        int trees = 0;
        for(String row: map){
            if(row.charAt(yPointer) == '#'){
                trees ++;
            }
            yPointer+=3;
            if(yPointer >= row.length()) {
                yPointer = yPointer - row.length();
            }

        }
        return trees;
    }

    private static int traverseForestPart2(ArrayList<String> map, String[] slopes){
        int treeProduct = 1;
        for(String slope: slopes) {
            int trees = 0;
            int yPointer = 0;
            for (int i = 0; i < map.size(); i+= Integer.parseInt(slope.split(",")[1])) {
                if (map.get(i).charAt(yPointer) == '#') {
                    trees++;
                }
                yPointer += Integer.parseInt(slope.split(",")[0]);
                if (yPointer >= map.get(i).length()) {
                    yPointer = yPointer - map.get(i).length();
                }
            }
            treeProduct *= trees;
        }
        return treeProduct;
    }

}
