package com.cyh.movie2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a menu system and stores movies in a file
 *
 * @author Yinhe Chen
 * @version 2.0
 */

public class MovieCollection {
    static Scanner sc = new Scanner(System.in);

    /**
     * Removes the movie you want to modify and adds a new one
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void modify() throws IOException, ClassNotFoundException {
        File f = new File("d:\\movie.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList arr = (ArrayList) ois.readObject();
        System.out.println("Choose the number of movie which you want to modify:");
        int bNum2 = sc.nextInt();
        for (Object o : arr) {
            Movie m = (Movie) o;
            if (m.getmNum() == bNum2) {
                System.out.println("The number of movie:");
                int mNum;
                int rTime;
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
                        break;
                    } else {
                        sc = new Scanner(System.in);
                        System.out.println("Wrong Input!");
                        System.out.println("Please input again");
                    }
                }
                m.setmNum(mNum);
                m.setmTitle(mName);
                m.setmDirector(mDirector);
                m.setrTime(rTime);
                if (f.exists()) {
                    arr.add(m);
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(arr);
                    oos.close();
                    System.out.println("Success!");
                    System.out.println();
                    break;
                } else {
                    arr.add(m);
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(arr);
                    oos.close();
                    System.out.println("Success!");
                    System.out.println();
                    break;
                }


            }
        }
    }

    /**
     * Adds all the value together
     *
     * @return the value of sum as a double
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static double sum() throws IOException, ClassNotFoundException {
        File f = new File("d:\\movie.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList arr = (ArrayList) ois.readObject();
        double sum = 0.0;
        for (int i = 0; i <= arr.size() - 1; i++) {
            Movie m = (Movie) (arr.get(i));
            sum = sum + m.getPurchaseCost();
        }
        System.out.println("The total value of your movie is($): " + sum);
        System.out.println();
        return sum;
    }

    /**
     * Tells the program to start here
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //create a menu:
        while (true) {
            System.out.println("Welcome to [MovieCollection]!");
            System.out.println("1.Display all movies");
            System.out.println("2.Add one movie");
            System.out.println("3.Modify details");
            System.out.println("4.Search movie");
            System.out.println("5.Calculate cost");
            System.out.println("6.Exit");
            System.out.println("Choose a function you want to use");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("[MovieCollection]>>>>>>>>1.Display all movies]");
                Movie m = new Movie();
                m.display();
            }
            if (choice == 2) {
                System.out.println("[MovieCollection]>>>>>>>>2.Add a movie");
                Movie m = new Movie();
                m.add();
            }
            if (choice == 3) {
                System.out.println("[MovieCollection]>>>>>>>>3.Modify details");
                modify();
            }
            if (choice == 4) {
                sc.nextLine();
                System.out.println("[MovieCollection]>>>>>>>>4.Search movie");
                File f = new File("d:\\movie.txt");
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ArrayList arr;
                arr = (ArrayList) (ois.readObject());
                System.out.println("Input the title:");
                String mTitle = sc.nextLine();
                for (int i = 0; i <= arr.size() - 1; i++) {
                    Movie m = (Movie) (arr.get(i));
                    if (m.getmTitle().equals(mTitle)) {
                        System.out.println(m.getmNum() + "---" + m.getmTitle() + "---" + m.getmDirector() + "---" + m.getrTime() + "---" + m.getPurchaseCost());
                    } else {
                        System.out.println("There is no match!");
                    }
                }

            }
            if (choice == 5) {
                System.out.println("[MovieCollection]>>>>>>>>5.Calculate cost of all movies");
                sum();
            }
            if (choice == 6) {
                System.out.println("[MovieCollection]>>>>>>>>6.Exit");
                break;
            }
        }
    }
}
