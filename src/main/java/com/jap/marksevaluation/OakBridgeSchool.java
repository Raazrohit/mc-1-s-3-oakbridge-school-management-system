package com.jap.marksevaluation;
public class OakBridgeSchool {

    public int[] calculateTotalMarks(int [] math,int science[],int[] english)
    {
        if(math.length == 0 || science.length == 0 || english.length == 0){
            return null;
        }
        else {
            int[] totalMarks = new int[math.length];
            for (int i = 0; i < math.length; i++) {
                totalMarks[i] = math[i] + science[i] + english[i];
            }
            return totalMarks;
        }
    }

    public int[] calculateTotalAverageMarksForEachStudent(int [] totalMarks, int noOfSubjects)
    {
        if(totalMarks.length == 0 || noOfSubjects == 0){
            return null;
        }
        else {
            int[] averageMarks = new int[totalMarks.length];
            for (int i = 0; i < totalMarks.length; i++) {
                averageMarks[i] = totalMarks[i] / noOfSubjects;
            }
            return averageMarks;
        }
    }

   // Write the logic inside the method to calculate the grade based on the math mark of the student
    public char findGradeInMath(int math)
    {
        char mathGrade = '\u0000';
             if(math >= 90){
                 return 'A';
             }
             else if(math >= 80 && math <= 89){
                 return 'B';
             }
             else if(math >= 70 && math <= 79){
                 return 'C';
             }
             else if(math >= 60 && math <= 69){
                 return 'D';
             }
             else if(math <= 59){
                 return 'F';
             }
        return mathGrade;
    }
    // Write the logic inside the method to calculate the grade based on the science mark of the student
    public char findGradeInScience(int science){
        char scienceGrade = '\u0000';
        if(science >= 90){
            return 'A';
        }
        else if(science >= 80 && science <= 89){
            return 'B';
        }
        else if(science >= 70 && science <= 79){
            return 'C';
        }
        else if(science >= 60 && science <= 69){
            return 'D';
        }
        else if(science <= 59){
            return 'F';
        }
        return scienceGrade;
    }
    // Write the logic inside the method to calculate the grade based on the english mark of the student
    public char findGradeInEnglish(int english){
        char englishGrade = '\u0000';
        if(english >= 90){
            return 'A';
        }
        else if(english >= 80 && english <= 89){
            return 'B';
        }
        else if(english >= 70 && english <= 79){
            return 'C';
        }
        else if(english >= 60 && english <= 69){
            return 'D';
        }
        else if(english <= 59){
            return 'F';
        }
        return englishGrade;
    }

    // Write the logic to sort the total marks of the students of the class, use insertion-sort

    public int[] sortByTotalMarks(int[] totalMarks)
    {
        for (int i = 0; i < totalMarks.length; i++) {
            int key = totalMarks[i];
            int j = i - 1;
            while (j >= 0 && totalMarks[j] > key){
                totalMarks[j+1] = totalMarks[j];
                j = j - 1;
            }
            totalMarks[j+1] = key;
        }
        return totalMarks;
    }

public void displayDetails(int totalMark, int averageMark, char mathGrade, char scienceGrade, char englishGrade,String studentName, int rollNo ){
        System.out.println("Grading And Evaluation---->");
        System.out.println("--------------------------------------------------");
        System.out.println("Student Name" + "\t\t\t\t" + "Roll Number");
        System.out.println("--------------------------------------------------");
        System.out.println(studentName + "\t\t\t\t" + rollNo);
        System.out.println("The total marks scored   :" + totalMark);
        System.out.println("The average mark scored   :" + averageMark);
        System.out.println("--------------------------------------------------");


        System.out.println("Grade in Math :" + mathGrade);
        System.out.println("Grade in Science :" + scienceGrade);
        System.out.println("Grade in English :" + englishGrade);
        System.out.println("--------------------------------------------------");

        System.out.println("Report--->");

        System.out.println("The total marks of the class in sorted order");
    }

    public static void main(String[] args) {

        // Declare and Initialize the object of OakBridgeSchool
            OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();
        // Declare and Initialize values to the arrays to store marks of math, science, english
            int[] math = {88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
            int[] science = {80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
            int[] english = {90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        // Declare and Initialize a string array for storing student names
            String[] studentNames = {"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        // Declare and Initialize an int array for storing roll numbers
            int[] rollNo = {102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
        // Call the appropriate methods and display the results
            oakBridgeSchool.displayDetails(258,86,'B','B','A', "Michelle", 102);
            int[] totalMarks = oakBridgeSchool.calculateTotalMarks(math,science,english);
            for (int i = math.length - 1; i >= 0; i--) {
                int[] sorted = oakBridgeSchool.sortByTotalMarks(totalMarks);
            System.out.println(sorted[i]);
        }
    }
}