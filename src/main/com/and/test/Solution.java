package com.and.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */



    public static String solution(String input) throws NumberFormatException {

        int []numbers = sanatiseInput(input);
        List<List<Integer>> results = combination(numbers);

        return translateResulstToString(results);
    }



    private  static List<List<Integer>> combination(int []numbers){
        if(numbers == null || numbers.length == 0)
            return new ArrayList<>();

        List<List<Integer>> listOfPermutations = new ArrayList<>();

        List<Integer> currentResult = new ArrayList<>();
        boolean[] usedNumbers = new boolean[numbers.length];

        combineRecursive(numbers,listOfPermutations,currentResult,usedNumbers);

        return listOfPermutations;
    }

    private static void combineRecursive(int[] numbers, List<List<Integer>> listOfPermutations, List<Integer> currentResult, boolean[] usedNumbers) {
            if(currentResult.size() == numbers.length){
                listOfPermutations.add(new ArrayList<>(currentResult));
                return;
            }
            for (int i = 0; i < numbers.length; i++){
                if(usedNumbers[i])
                    continue;
                currentResult.add(numbers[i]);
                usedNumbers[i] = true;
                combineRecursive(numbers,listOfPermutations,currentResult,usedNumbers);
                usedNumbers[i] = false;
                currentResult.remove(currentResult.size() - 1);
        }
    }

    private static int[] sanatiseInput(String input){
        String stringNumber = input.replaceAll("[^\\d]","");
        int[] numbers = new int[stringNumber.length()];
        int index = 0;
        for (char c :
                stringNumber.toCharArray()) {
            numbers[index] = Character.getNumericValue(c);
            index++;
        }
        return numbers;

    }
    private static String  translateResulstToString(List<List<Integer>> results){
        StringBuilder result = new StringBuilder();
        
        for (List<Integer> permutation:
        results){
            for (Integer element :
                    permutation) {
                result.append(element);
            }
            result.append(",");
        }
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }

    public static void main(String args[]) {
        System.out.println(solution("236"));
    }

}
