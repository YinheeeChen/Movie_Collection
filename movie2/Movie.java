package com.cyh.movie2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents all details of a movie
 *
 * @author Yinhe Chen
 * @version 2.0
 */

public class Movie implements Serializable {
    private static final long serialVersionUID = -6488212697549708540L;
    //create fields:
    private int mNum;
    private String mTitle;
    private String mDirector;
    private int rTime;
    private double purchaseCost;

    /**
     * Gets the number of movie
     *
     * @return the value of number as an int
     */
    public int getmNum() {
        return mNum;
    }

    /**
     * Sets the number of movie
     *
     * @param mNum
     */
    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

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
     * Stes the value of running time of movie
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
    public double getPurchaseCost() {
        return purchaseCost;
    }

    /**
     * Sets the value of cost of movie
     *
     * @param purchaseCost
     */
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    /**
     * Adds one movie and sets all details
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void add() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("The number of movie:");
        int mNum;
        int rTime;
        double purchaseCost;
        while (true) {
            if (sc.hasNextInt()) {
                mNum = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                sc = new Scanner(System.in);
                System.out.println("Wrong Input!");
                System.out.println("Please input again");
            }
        }
        System.out.println("The title of movie:");
        String mName = sc.nextLine();
        System.out.println("The director of movie:");
        String mDirector = sc.nextLine();
        System.out.println("The runningtime of movie:");
        while (true) {
            if (sc.hasNextInt()) {
                rTime = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                sc = new Scanner(System.in);
                System.out.println("Wrong Input!");
                System.out.println("Please input again");
            }
        }
        System.out.println("The purchase cost of movie($):");
        while (true) {
            if (sc.hasNextDouble()) {
                purchaseCost = sc.nextDouble();
                break;
            } else {
                sc = new Scanner(System.in);
                System.out.println("Wrong Input!");
                System.out.println("Please input again");
            }
        }
        System.out.println("Success!");
        System.out.println();
        Movie m = new Movie();
        m.setmNum(mNum);
        m.setmTitle(mName);
        m.setmDirector(mDirector);
        m.setrTime(rTime);
        m.setPurchaseCost(purchaseCost);
        File f = new File("d:\\movie.txt");
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList arr = (ArrayList) (ois.readObject());
            arr.add(m);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
            oos.close();

        } else {
            ArrayList arr = new ArrayList();
            arr.add(m);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
            oos.close();
        }
    }

    /**
     * Display all details of movies
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void display() throws IOException, ClassNotFoundException {
        File f = new File("d:\\movie.txt");
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList arr = (ArrayList) (ois.readObject());
            for (int i = 0; i <= arr.size() - 1; i++) {
                Movie m = (Movie) (arr.get(i));
                System.out.println(m.getmNum() + "---" + m.getmTitle() + "---" + m.getmDirector() + "---" + m.getrTime() + "---" + m.getPurchaseCost());
                System.out.println();
            }
        } else {
            System.out.println("There is no movie now");
            System.out.println();
        }
    }

    //create a constructor:
    public Movie() {
    }
}
