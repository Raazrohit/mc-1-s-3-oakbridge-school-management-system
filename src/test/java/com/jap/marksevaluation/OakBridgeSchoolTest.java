package com.jap.marksevaluation;

import com.jap.marksevaluation.OakBridgeSchool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OakBridgeSchoolTest

{
    int [] math;
    int [] science;
    int [] social;
    int noOfSubjects;
    String[] studentNames;
    int [] rollNos;
    OakBridgeSchool oakBridgeSchool;
    @Before
    public void setUp(){
        oakBridgeSchool = new OakBridgeSchool();
        math  = new int[]{88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        science = new int[]{80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        social = new int[]{90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        noOfSubjects = 3;
        studentNames = new String[]{"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        rollNos = new int[]{102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
    }
    @After
    public void tearDown(){
        math  = null;
        science = null;
        social = null;
        noOfSubjects = 0;
        studentNames = null;
        rollNos = null;
        oakBridgeSchool = null;
    }
    @Test
    public  void givenMarksCalculateTotalAndReturnAnArraySuccess(){
        int[] expectedTotal = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertArrayEquals(expectedTotal,oakBridgeSchool.calculateTotalMarks(math,science,social));

    }
    @Test
    public  void givenMarksCalculateTotalAndReturnAnArrayFailure(){
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],science,social));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,science,new int[0]));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,new int[0],social));
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],new int[0],new int[0]));
    }

    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArraySuccess(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedAverage = {86, 90, 99, 67, 56, 82, 37, 8, 34, 62};
        assertArrayEquals(expectedAverage,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,noOfSubjects));
    }

    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArrayFailure(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,0));
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],3));
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],0));
    }
    @Test
    public  void givenMathMarksArrayOfClassReturnAverageSuccess(){
        int expectedMathAverage = 60;
        assertEquals(expectedMathAverage,oakBridgeSchool.calculateAverageMathMarks(math));
    }
    @Test
    public  void givenMathMarksArrayOfClassReturnAverageFailure(){
        int expectedMathAverage = -1;
        assertEquals(expectedMathAverage,oakBridgeSchool.calculateAverageMathMarks(new int[0]));
    }
    @Test
    public  void givenScienceMarksArrayOfClassReturnAverageSuccess(){
        int expectedScienceAverage = 61;
        assertEquals(expectedScienceAverage,oakBridgeSchool.calculateAverageMathMarks(science));
    }
    @Test
    public  void givenScienceMarksArrayOfClassReturnAverageFailure(){
        int expectedScienceAverage = -1;
        assertEquals(expectedScienceAverage,oakBridgeSchool.calculateAverageMathMarks(new int[0]));
    }
    @Test
    public  void givenSocialMarksArrayOfClassReturnAverageSuccess(){
        int expectedSocialAverage = 65;
        assertEquals(expectedSocialAverage,oakBridgeSchool.calculateAverageMathMarks(social));
    }
    @Test
    public  void givenSocialMarksArrayOfClassReturnAverageFailure(){
        int expectedSocialAverage = -1;
        assertEquals(expectedSocialAverage,oakBridgeSchool.calculateAverageMathMarks(new int[0]));
    }

    @Test
    public void givenAverageMarksCalculateGradesReturnACharArrayWithGradesSuccess(){
        char[] expectedGrades = {'B','A','A','D','E','B','F','F','F','D'};
        int[] averageMarks = {86, 90, 99, 67, 56, 82, 37, 8, 34, 62};
        assertArrayEquals(expectedGrades,oakBridgeSchool.calculateGrades(averageMarks));
    }
    @Test
    public void givenAverageMarksCalculateGradesReturnACharArrayWithGradesFailure(){
        assertNull(oakBridgeSchool.calculateGrades(new int[0]));
    }

    @Test
    public void givenSubjectMarksInArraysCheckIfPassedSuccess(){
        int[] expectedIsPassed = {1,1,1,1,1,1,1,0,0,1};
        assertArrayEquals(expectedIsPassed,oakBridgeSchool.isPassed(math,science,social));
    }
    @Test
    public void givenSubjectMarksInArraysCheckIfPassedFailure(){
        assertNull(oakBridgeSchool.isPassed(new int[0],science,social));
        assertNull(oakBridgeSchool.isPassed(math,new int[0],social));
        assertNull(oakBridgeSchool.isPassed(math,science,new int[0]));
        assertNull(oakBridgeSchool.isPassed(new int[0],new int[0],new int[0]));
    }

    @Test
    public void givenTotalMarksInArraysSortInAscendingOrder(){
        int[] totalMarks = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedSortedTotalMarksOfClass = {25,102,113,170,188,202,246,258,270,299};
        assertArrayEquals(expectedSortedTotalMarksOfClass,oakBridgeSchool.sortByTotalMarks(totalMarks));

    }
    @Test
    public void givenGradesSortNamesInAscendingOrder(){
        char[] grades = {'B','A','A','D','E','B','F','F','F','D'};
        String[] expectedSortedTotalMarksOfClassNames = {"Kate","Ann","Michelle","Sam","Tina","Leo","Tom","Ria","Pam","Leena"};
        assertArrayEquals(expectedSortedTotalMarksOfClassNames,oakBridgeSchool.sortByGrades(grades,expectedSortedTotalMarksOfClassNames));
        }
}
