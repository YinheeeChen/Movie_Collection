package com.cyh.movie1;

import java.util.Scanner;

/**
 * Holds and represents a collection of 3 movies
 *
 * @author Yinhe Chen
 * @version 1.0
 */
public class MovieCollection {
    Movie movie1 = new Movie();
    Movie movie2 = new Movie();
    Movie movie3 = new Movie();

    public MovieCollection() {
    }

    public MovieCollection(Movie movie1, Movie movie2, Movie movie3) {
        this.movie1 = movie1;
        this.movie2 = movie2;
        this.movie3 = movie3;
    }

    /**
     * Sets all the details of 3 movies at a time
     *
     * @param mc
     */
    public static void setAll(MovieCollection mc) {
        mc.movie1.set();
        mc.movie2.set();
        mc.movie3.set();
        Scanner sc = new Scanner(System.in);
    }

    /**
     * Displays all the details of 3 movies at a time
     *
     * @param mc
     */
    public static void displayAll(MovieCollection mc) {
        mc.movie1.display();
        mc.movie2.display();
        mc.movie3.display();
        System.out.println();
    }

    /**
     * Check whether there is the same title as entered and then display it.If not,tell user the result.
     *
     * @param mc
     */
    public static void search(MovieCollection mc) {
        System.out.println("Please input  the movie title which you want to search: ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String movieTitle = sc.nextLine();
            if (movieTitle.equals(mc.movie1.getmTitle())) {
                mc.movie1.display();
            } else if (movieTitle.equals(mc.movie2.getmTitle())) {
                mc.movie2.display();
            } else if (movieTitle.equals(mc.movie3.getmTitle())) {
                mc.movie3.display();
            } else if (movieTitle.equals("exit")) {
                break;
            } else {
                System.out.println("There is no matching movies, please search another or input 'exit' to get out.");
            }
            System.out.println("You can continue your searching or input 'exit' to get out");
        }
    }

    /**
     * Displays the sum of cost of 3 movies
     *
     * @param mc
     */
    public static void calculate(MovieCollection mc) {
        System.out.println("The total value of your movies is($): " + (mc.movie1.getCost() + mc.movie2.getCost() + mc.movie3.getCost()));
        System.out.println();
    }

    /**
     * Tells the program to start here
     *
     * @param args
     */
    public static void main(String[] args) {
        MovieCollection mc = new MovieCollection();

        o:
        while (true) {
            System.out.println("Welcome to [MovieCollection]!!!");
            System.out.println("Here are some features you can choose:");
            System.out.println("1.First set or set all again");
            System.out.println("2.Display all movies");
            System.out.println("3.Search for one movie");
            System.out.println("4.Calculate all the value");
            System.out.println("5.Exit");
            System.out.println("---------------------------------");
            System.out.println("Choose a feature you want to use(tips: You must firstly choose 1 to set your movies):");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("[MovieCollection]>>>>>>>>>>>>>>>>>>>>1.First set or set all again");
                    setAll(mc);
                    break;
                case 2:
                    System.out.println("[MovieCollection]>>>>>>>>>>>>>>>>>>>>2.Display all movies");
                    displayAll(mc);
                    break;
                case 3:
                    System.out.println("[MovieCollection]>>>>>>>>>>>>>>>>>>>>3.Search for one movie");
                    search(mc);
                    break;
                case 4:
                    System.out.println("[MovieCollection]>>>>>>>>>>>>>>>>>>>>4.Calculate all the value");
                    calculate(mc);
                    break;
                case 5:
                    System.out.println("[MovieCollection]>>>>>>>>>>>>>>>>>>>>5.Exit");
                    break o;
                default:
                    System.out.println("Wrong choice! Please choose again！");
                    System.out.println();
            }
        }
    }
}
