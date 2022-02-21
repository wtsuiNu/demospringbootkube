package com.nuvalence.demospringbootkube.rectangle;


import com.nuvalence.demospringbootkube.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    private int corAX;
    private int corAY;
    private int corBX;
    private int corBY;
    private int width;
    private int tall;

    Rectangle(int corAX,
              int corAY,
              int corBX,
              int corBY,
              int width,
              int tall) {
        this.corAX = corAX;
        this.corAY = corAY;
        this.corBX = corBX;
        this.corBY = corBY;
        this.width = width;
        this.tall = tall;
        logger.info("Rectangle: Rectangle created - [" + corAX + ", " + corAY + "], [" + corBX + ", " + corBY + "] width: " + width + " tall: "+ tall);
    }

    Rectangle(int corAX,
              int corAY,
              int corBX,
              int corBY) {

        this(Math.min( corAX, corBX),
                Math.max( corAY, corBY),
                Math.max( corAX, corBX),
                Math.min( corAY, corBY),
                Math.abs(Math.min( corAX, corBX) - Math.max( corAX, corBX)),
                Math.abs(Math.max( corAY, corBY) - Math.min( corAY, corBY)));
    }

    Rectangle(Integer[] coordinates){
        this(coordinates[0],
                coordinates[1],
                coordinates[2],
                coordinates[3]);
    }

    public static Rectangle getRectangle(Integer[] coordinates) throws Exception{

        if(coordinates == null || coordinates.length != 4){
            throw new IllegalArgumentException();
        }

        if(coordinates[0] == null
                || coordinates[1] == null
                || coordinates[2] == null
                || coordinates[3] == null ) {
            throw new IllegalArgumentException();
        }

        if(coordinates[0] == coordinates[2] || coordinates[1] == coordinates[3]){
            throw new IllegalArgumentException();
        }

        return new Rectangle(coordinates);
    }

    /* method to check if two rectangles have intersection */
    public boolean isIntersections (Rectangle recB){

        /* intersection on X level */
        if(this.getCorAX() < recB.getCorBX() && recB.getCorAX() < this.getCorBX()){

            /* intersection on Y level as well */
            if(this.getCorAY() > recB.getCorBY() && recB.getCorAY() > this.getCorBY()){

                /* there is at least one edge rec A is outreach rec B */
                if((this.getCorAX() < recB.getCorAX()  && recB.getCorAX() < this.getCorBX()) ||
                        (this.getCorBX() > recB.getCorBX() && recB.getCorBX() > this.getCorAX())||
                        (this.getCorAY() > recB.getCorAY() && recB.getCorAY() > this.getCorBY())||
                        (this.getCorBY() < recB.getCorBY() && recB.getCorBY() < this.getCorAY())){

                    /* there is at least one edge rec B is outreach rec A */
                    if((recB.getCorAX() < this.getCorAX() && this.getCorAX() < recB.getCorBX()) ||
                            (recB.getCorBX() > this.getCorBX() && this.getCorBX() > recB.getCorAX())||
                            (recB.getCorAY() > this.getCorAY() && this.getCorAY() > recB.getCorBY())||
                            (recB.getCorBY() < this.getCorBY() && this.getCorBY() < recB.getCorAY())){
                        logger.info("Intersection: intersection found");
                        return true;
                    }
                }
            }
        }

        logger.info("Intersection: intersection not found");
        return false;
    }

    /* method to find all the coordinates on the lines of intersection */
    public List<int[]> getIntersections (Rectangle recB){

        List<int[]> intersectPoints = new ArrayList<>();
        List<int[]> linesA = getAllCoordinates();
        List<int[]> linesB = recB.getAllCoordinates();

        for(int[]lineA : linesA){
            for(int[]lineB : linesB){
                if(lineA[0] == lineB[0] && lineA[1] == lineB[1]){
                    intersectPoints.add(lineA);
                }
            }
        }

        logger.info("Intersection: intersection points found: " + intersectPoints.size());
        return intersectPoints;
    }

    /* method to get all coordinates of a rectangle */
    public List<int[]> getAllCoordinates(){

        List<int[]> coordinates = new ArrayList<>();
        List<int[]> XAcisUpper = new ArrayList<>();
        List<int[]> XAcisLower = new ArrayList<>();

        for(int i = this.getCorAX(), j = 0; i<= this.getCorBX(); i++, j++){
            int[] upperPos = {i, this.getCorAY()};
            int[] lowerPos = {i, this.getCorBY()};
            XAcisUpper.add(upperPos);
            XAcisLower.add(lowerPos);
        }

        List<int[]> YAcisLeft = new ArrayList<>();
        List<int[]> YAcisRight = new ArrayList<>();

        for(int i = this.getCorBY()+1, j = 0; i< this.getCorAY(); i++, j++){
            int[] leftPos = {this.getCorAX(), i};
            int[] rightPos = {this.getCorBX(), i};
            YAcisLeft.add(leftPos);
            YAcisRight.add(rightPos);
        }
        coordinates.addAll(XAcisUpper);
        coordinates.addAll(XAcisLower);
        coordinates.addAll(YAcisLeft);
        coordinates.addAll(YAcisRight);
        return coordinates;
    }

    /* method to check if one rectangle contains the other */
    public boolean isContainment(Rectangle recB){

        int widthDiff = this.getWidth() - recB.getWidth();
        int tallDiff = this.getTall() - recB.getTall();

        if(widthDiff == 0 && tallDiff == 0){
            /* equal rectangle */
            logger.info("Containment: containment not found ");
            return false;
        }

        /* either one is containing another */
        if(widthDiff >= 0 && tallDiff >= 0){
            if(this.getCorAX() <= recB.getCorAX() &&
                    this.getCorBX() >= recB.getCorBX() &&
                    this.getCorAY() >= recB.getCorAY() &&
                    this.getCorBY() <= recB.getCorBY() ){
                logger.info("Containment: containment found, rectangle A is containing rectangle B ");
                return true;
            }
        }else if(widthDiff <= 0 && tallDiff <= 0){
            if(recB.getCorAX() <= this.getCorAX() &&
                    recB.getCorBX() >= this.getCorBX() &&
                    recB.getCorAY() >= this.getCorAY() &&
                    recB.getCorBY() <= this.getCorBY() ){
                logger.info("Containment: containment found, rectangle B is containing rectangle A ");
                return true;
            }

        }

        /* neither equal or containment */
        logger.info("Containment: containment not found ");
        return false;
    }

    /* method to check whether two rectangles are adjacent */
    public boolean isAdjacent(Rectangle recB){

        /* horizontally adjacent */
        if(this.getCorAX() == recB.getCorBX() || this.getCorBX() == recB.getCorAX()){
            if(this.getCorAY() >= recB.getCorBY() && this.getCorBY() <= recB.getCorAY()){
                logger.info("Adjacent: adjacent found ");
                return true;
            }
        }

        /* vertically adjacent*/
        if(this.getCorAY() == recB.getCorBY() || this.getCorBY() == recB.getCorAY()){
            if(this.getCorAX() <= recB.getCorBX() && this.getCorBX() >= recB.getCorAX()){
                logger.info("Adjacent: adjacent found ");
                return true;
            }
        }
        logger.info("Adjacent: adjacent not found ");
        return false;
    }


    /* method to check the relationship of two rectangles */
    public String checkRectangleRelationship(Rectangle recB){

        if(checkOverlap(recB)){
            return rectangleOverlap;
        }

        int conditionMatch = 0;
        boolean isIntersection = isIntersections(recB);
        boolean isContainment = isContainment(recB);
        boolean isAdjacent = isAdjacent(recB);
        if(isIntersection){ conditionMatch ++; }
        if(isContainment){ conditionMatch ++; }
        if(isAdjacent){ conditionMatch ++; }

        if(conditionMatch == 1){
            if(isIntersection){ return Rectangle.isIntersection; }
            if(isContainment){ return Rectangle.isContainment; }
            if(isAdjacent){ return Rectangle.isAdjacent; }
        }else{
            logger.error(relationshipFail);
        }

        return relationshipFail;
    }

    /* method to transfer array input and call checkRectangleRelationship */
    public static String checkRectangleRelationship(Integer[][] coordinateSets){
        try{
            Rectangle recA = getRectangle(coordinateSets[0]);
            Rectangle recB = getRectangle(coordinateSets[1]);
            if(recA != null && recB != null){
                return recA.checkRectangleRelationship(recB);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return Rectangle.invalidInput;
    }

    /* method to check if two rectangles are overlapping */
    boolean checkOverlap(Rectangle recB){
        if(corAX == recB.corAX &&
                corAY == recB.corAY &&
                corBX == recB.corBX &&
                corBY == recB.corBY){
            return true;
        }else{
            return false;
        }
    }

    public static String invalidInput = "invalid input";
    public static String isIntersection = "isIntersection";
    public static String isContainment = "isContainment";
    public static String isAdjacent = "isAdjacent";
    public static String relationshipFail = "System failed, no or more than one rectangle relationship found";
    public static String rectangleOverlap = "the two rectangles are overlapped";

    public int getCorAX() {
        return corAX;
    }

    public int getCorAY() {
        return corAY;
    }

    public int getCorBX() {
        return corBX;
    }

    public int getCorBY() {
        return corBY;
    }

    public int getWidth() {
        return width;
    }

    public int getTall() {
        return tall;
    }

}
