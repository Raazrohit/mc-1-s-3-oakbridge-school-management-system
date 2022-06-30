package com.jap.marksevaluation;

import com.jap.marksevaluation.OakBridgeSchool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OakBridgeSchoolTest {
    int [] math;
    int [] science;
    int [] english;
    String[] studentNames;
    int [] rollNos;
    OakBridgeSchool oakBridgeSchool;
    @Before
    public void setUp(){
        oakBridgeSchool = new OakBridgeSchool();
        math  = new int[]{88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        science = new int[]{80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        english = new int[]{90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        studentNames = new String[]{"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        rollNos = new int[]{102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
    }
    @After
    public void tearDown(){
        math  = null;
        science = null;
        english = null;
        studentNames = null;
        rollNos = null;
        oakBridgeSchool = null;
    }

    @Test
    public  void givenMarksCalculateTotalAndReturnAnArraySuccess(){
        int[] expectedTotal = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertArrayEquals(expectedTotal,oakBridgeSchool.calculateTotalMarks(math,science,english));

    }
    @Test
    public  void givenMarksCalculateTotalAndReturnAnArrayFailure(){
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],science,english));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,science,new int[0]));
        assertNull(oakBridgeSchool.calculateTotalMarks(math,new int[0],english));
        assertNull(oakBridgeSchool.calculateTotalMarks(new int[0],new int[0],new int[0]));
    }

    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArraySuccess(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedAverage = {86, 90, 99, 67, 56, 82, 37, 8, 34, 62};
        assertArrayEquals(expectedAverage,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,3));
    }

    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArrayFailure(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,0));
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],3));
        assertNull(oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],0));
    }
    @Test
    public void givenTotalMarksInArraysSortInAscendingOrder(){
        int[] totalMarks = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedSortedTotalMarksOfClass = {25,102,113,170,188,202,246,258,270,299};
        assertArrayEquals(expectedSortedTotalMarksOfClass,oakBridgeSchool.sortByTotalMarks(totalMarks));
    }
    @Test
    public void givenMathMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInMath(99));
        assertEquals('B',oakBridgeSchool.findGradeInMath(81));
        assertEquals('C',oakBridgeSchool.findGradeInMath(73));
        assertEquals('D',oakBridgeSchool.findGradeInMath(64));
        assertEquals('F',oakBridgeSchool.findGradeInMath(54));
        assertEquals('F',oakBridgeSchool.findGradeInMath(44));
        assertEquals('F',oakBridgeSchool.findGradeInMath(13));
    }
    @Test
    public void givenScienceMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInScience(90));
        assertEquals('B',oakBridgeSchool.findGradeInScience(80));
        assertEquals('C',oakBridgeSchool.findGradeInScience(70));
        assertEquals('D',oakBridgeSchool.findGradeInScience(60));
        assertEquals('F',oakBridgeSchool.findGradeInScience(50));
        assertEquals('F',oakBridgeSchool.findGradeInScience(40));
        assertEquals('F',oakBridgeSchool.findGradeInScience(20));
    }
    @Test
    public void givenEnglishMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInEnglish(100));
        assertEquals('B',oakBridgeSchool.findGradeInEnglish(88));
        assertEquals('C',oakBridgeSchool.findGradeInEnglish(77));
        assertEquals('D',oakBridgeSchool.findGradeInEnglish(64));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(51));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(48));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(34));
    }

}
