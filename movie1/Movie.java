package com.cyh.movie1;

import java.util.Scanner;

/**
 * Represents details of a movie
 *
 * @author Yinhe Chen
 * @version 1.0
 */

public class Movie {
    private String mTitle;
    private String mDirector;
    private int rTime;
    private double cost;

    /**
     * Gets the movie title
     *
     * @return the mTitle as a string
     */
    public String getmTitle() {
        return mTitle;
    }

    /**
     * Sets the value of movie title
     *
     * @param mTitle
     */
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /**
     * Gets the movie director
     *
     * @return the value of movie director as a string
     */
    public String getmDirector() {
        return mDirector;
    }

    /**
     * Sets the value of movie director
     *
     * @param mDirector
     */
    public void setmDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    /**
     * Gets the running time of movie
     *
     * @return teh value of running time as an int
     */
    public int getrTime() {
        return rTime;
    }

    /**
     * Setss the value of running time of movie
     *
     * @param rTime
     */
    public void setrTime(int rTime) {
        this.rTime = rTime;
    }

    /**
     * Gets the cost of movie
     *
     * @return the value of cost as a double
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the value of cost of movie
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    //create a movie constructor
    public Movie() {
    }

    public Movie(String mTitle, String mDirector, int rTime, double cost) {
        this.mTitle = mTitle;
        this.mDirector = mDirector;
        this.rTime = rTime;
        this.cost = cost;
    }

    /**
     * Display all the details of a movie
     */
    public void display() {
        System.out.println("Title:" + getmTitle());
        System.out.println("Director:" + getmDirector());
        System.out.println("Running Time:" + getrTime());
        System.out.println("Cost($):" + getCost());
        System.out.println();

    }

    /**
     * Set all the details od a movie
     */
    public void set() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please set details of your movies(You should totally set 3)");
        System.out.println("Set the movie title:");
        setmTitle(sc.nextLine());
        System.out.println("Set the director of movie:");
        setmDirector(sc.nextLine());
        System.out.println("Set the running time(in minutes):");
        while (true) {
            try {
                setrTime(sc.nextInt());
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong input!");
                System.out.println("Please input again!");
            }
        }
        System.out.println("Set the cost of movie:");
        while (true) {
            try {
                setCost(sc.nextDouble());
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong input!");
                System.out.println("Please input again!");
            }
        }
        System.out.println("Success!");
        System.out.println();

    }
}
