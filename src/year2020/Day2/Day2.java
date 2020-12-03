package year2020.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        try{
            File passwordPolicy = new File ("src/year2020/Day2/passwords.txt");
            Scanner reader = new Scanner(passwordPolicy);
            ArrayList<String> passwords = new ArrayList<>();

            while(reader.hasNextLine()){
                passwords.add(reader.nextLine());
            }

            System.out.println("Total valid passwords: " +findValidPasswordCount(passwords));
            System.out.println("Total valid passwords part 2: " +findValidPasswordCountPart2(passwords));

        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }


    private static int findValidPasswordCount(ArrayList<String> passwords){
        int validPasswords = 0;
        for(String password: passwords){
            int occs = 0;
            String[] data = password.split(" ");
            int minOccs = Integer.parseInt(data[0].split("-")[0]);
            int maxOccs = Integer.parseInt(data[0].split("-")[1]);
            char requiredChar = data[1].charAt(0);
            for(int i =0; i < data[2].length(); i ++){
                if(data[2].charAt(i) == requiredChar){
                    occs +=1;
                }
            }
            if (occs >= minOccs && occs<= maxOccs ){
                validPasswords +=1;
            }
        }
        return validPasswords;
    }

    private static int findValidPasswordCountPart2(ArrayList<String> passwords){
        int validPasswords = 0;
        for(String password: passwords){
            String[] data = password.split(" ");
            int firstIndex = Integer.parseInt(data[0].split("-")[0]) -1;
            int secondIndex = Integer.parseInt(data[0].split("-")[1]) -1;
            char requiredChar = data[1].charAt(0);
            if ((data[2].charAt(firstIndex) == requiredChar|| data[2].charAt(secondIndex) == requiredChar ) &&
                    data[2].charAt(firstIndex) != data[2].charAt(secondIndex)){
                validPasswords +=1;
            }
        }
        return validPasswords;
    }
}
