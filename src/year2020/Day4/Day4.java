package year2020.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        try{

            String content = new Scanner(new File("src/year2020/Day4/passports.txt")).useDelimiter("\\Z").next();
            String[] passports = content.split("\\n\\n");
            String[] requiredKeys = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
            System.out.println("Valid passports: " + getValidPassports(passports, requiredKeys));


        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }

    private static int getValidPassports(String[] passports, String[] requiredKeys){
        int validPassports = 0;
        for(String passport: passports){
            boolean containsAllRequiredFields = true;
            for(String requiredKey: requiredKeys){
                if (!passport.contains(requiredKey)){
                    containsAllRequiredFields = false;
                    break;
                }
            }
            if(containsAllRequiredFields){
                validPassports +=1;
            }
        }
        return validPassports;
    }


//    private static int getValidPassportsPart2(String[] passports, String[] requiredKeys){
//        int validPassports = 0;
//        for(String passport: passports){
//            boolean containsAllRequiredFields = true;
//            boolean valid = true;
//            for(String requiredKey: requiredKeys){
//                if (!passport.contains(requiredKey)){
//                    containsAllRequiredFields = false;
//                    break;
//                }
//
//                if(requiredKey.equals("byr")){
//                    String info = passport.("byr: \\d{4}")
//                    String date = str.replaceAll("\\D+","");
//
//
//                }else if(requiredKey.equals("iyr")){
//
//                }else if(requiredKey.equals("eyr")){
//
//                }else if(requiredKey.equals("hgt")){
//
//                }else if(requiredKey.equals("hcl")){
//
//                }else if(requiredKey.equals("ecl")){
//
//                }else if(requiredKey.equals("pid")){
//
//                }
//            }
//            if(containsAllRequiredFields && valid){
//                validPassports +=1;
//            }
//        }
//        return validPassports;
//    }
}
