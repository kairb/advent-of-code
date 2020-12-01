package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        try{

            File expenseReport = new File ("src/Day1/ExpenseReport.txt");
            Scanner reader = new Scanner(expenseReport);
            ArrayList<Integer> expenses = new ArrayList<>();
            while(reader.hasNextInt()){
                expenses.add(reader.nextInt());
            }
            System.out.println("Answer part 1: " + getAnswer(expenses, 2020));
            System.out.println("Answer part 2: " + getAnswerPart2(expenses, 2020));

        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }

    private static int getAnswer(ArrayList<Integer> expenses, int sum){
        for(int i = 0; i < expenses.size(); i++){
            for (int j = i; j < expenses.size(); j++){
                if(expenses.get(i) + expenses.get(j) == sum){
                    return expenses.get(i) * expenses.get(j);
                }
            }
        }
        return 0;
    }

    private static int getAnswerPart2(ArrayList<Integer> expenses, int sum){
        for(int i = 0; i < expenses.size(); i++){
            for (int j = i; j < expenses.size(); j++){
                for (int k = 0; k < expenses.size(); k++){
                    if(expenses.get(i) + expenses.get(j) + expenses.get(k) == sum){
                        return expenses.get(i) * expenses.get(j) * expenses.get(k);
                    }
                }
            }
        }
        return 0;
    }
}
