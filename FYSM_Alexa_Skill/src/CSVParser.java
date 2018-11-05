import java.util.*;
import java.io.*;

public class CSVParser{

    public static void main(String[] args) throws FileNotFoundException{
//      String building = args[0];
//      System.out.println(building);
        String delimiter = " ; ";
        String inputFileName = "C:\\Users\\Emman\\IdeaProjects\\FYSM_Alexa_Skill\\src\\FYSM AI Buildings Project.csv";  //Path to the .csv file
        Scanner fin = new Scanner(new File(inputFileName));
        Scanner kbIn1 = new Scanner(System.in);
        Scanner kbIn2 = new Scanner(System.in);
        Scanner kbIn3 = new Scanner(System.in);
        Scanner kbIn4 = new Scanner(System.in);

        System.out.println("What is your primary intent as in what do you want to know?");
        System.out.println("List of intents to choose from: \n \t feature\n \t purpose\n \t establishment\n \t namesake");
        System.out.print("--> ");
        String primeIntent = kbIn1.nextLine();

        System.out.println("\nWhat is your secondary intent?");
        System.out.println("List of intents to choose from: \n \t reason (as to why there is a feature or why a building" +
                "has a particular name)\n \t number (If you want to know about how many " +
                "purposes there are or how many buildings there were in a year) \n \t the word null if you do not have a second intent.");
        System.out.print("--> ");
        String secondIntent = kbIn2.nextLine();

        System.out.println("\nWhat year are you interested in? If none input the number 0");
        System.out.print("--> ");
        int year = kbIn3.nextInt();

        System.out.println("\nWhat building are you interested in?");
        System.out.println("If you are interested in the amount of buildings on campus during a certain year, input null.");
        System.out.print("List of buildings to choose from: \n \t Anderson Hall\n" +
                "\t Guy Caldewell Western Heritage Memorial Room\n" +
                "\t Grape Street Athletic Complex\n" +
                "\t Woodwards-dellis Recital Hall\n" +
                "\t Smith Music Library \n" +
                "\t Holland Health Science Academy\n" +
                "\t Richardson Library \n" +
                "\t Sid Richardson Science Center \n" +
                "\t Taylor Rankin Greenhouse\n" +
                "\t Caldwell Music Hall\n" +
                "\t Cowboy Band Hall\n" +
                "\t Fletcher Fitness Center\n" +
                "\t Mabee Complex\n" +
                "\t Behrens Chapel-Auditorium\n" +
                "\t Van Ellis Theatre\n" +
                "\t Connally Missions Center\n" +
                "\t Johnson Building\n" +
                "\t Mabee Hall\n" +
                "\t Moody Center\n" +
                "\t Dyess Welcome Center\n" +
                "\t Frost center for Visual Arts\n" +
                "\t Logsdon School of Theology\n" +
                "\t Skiles building\n" +
                "\t Sandefer Memorial \n" +
                "\t Aileen Cullpepper Apartments\n" +
                "\t Alline F. Brown Apartments\n" +
                "\t Behrens Hall\n" +
                "\t Family Psychology Annex\n" +
                "\t Ferguson Hall\n" +
                "\t Lange Hall\n" +
                "\t Nix Hall\n" +
                "\t Abilene Hall\n");
        System.out.print("--> ");
        String building = kbIn4.nextLine();

        /*
         * counts the lines in inputFileName
         */
        String[] lines = new String[100];
        int cnt = 0;
        while(fin.hasNextLine()){
            lines[cnt] = fin.nextLine();
            cnt++;
        }

        /*
         * transfers all the lines in lines[] to info[]
         */
        String[] info = new String[cnt];
        for(int i=0; i<info.length; i++){
            info[i] = lines[i];
        }
        // printArray(info);

        int l = info[0].split(delimiter).length;
        String[][] csvInfo = new String[info.length][l];  //New 2d array based of the size of the array info[]
        cnt=0;                                           //reset cnt variable
        for(int i=0; i<info.length; i++){             //as long as i is less the size - 1 of info[]
            csvInfo[cnt] = info[i].toLowerCase().split(delimiter);   //put each value in info[i] into csvInfo[cnt]
            cnt++;                                     //increase cnt by 1
        }
        //print2DArray(csvInfo);
//       System.out.println(findBuilding(csvInfo, "Johnson Building")); //prints out the row that Johnson Building is supposed to be on
//       System.out.println(findFeature(csvInfo, "Johnson Building"));
//       System.out.println(findFeatureReason(csvInfo, "Johnson Building"));
//       System.out.println(findPurpose(csvInfo, "Johnson Building"));
//       System.out.println(findNumOfPurposes(csvInfo, "Johnson Building"));
//       System.out.println(findEstablishmentYear(csvInfo, "Johnson Building"));
//       System.out.println(findNamesake(csvInfo, "Johnson Building"));
//       System.out.println(findNamesakeReason(csvInfo, "Johnson Building"));


        whatIsIntent(primeIntent, secondIntent, year, csvInfo,building);

       /*
        * ignore below

      //Converting String to int
//      String s = "1991 ";
//      int year = Integer.parseInt(s.trim());
//      System.out.println(year);
        */
    }

    /**
     *
     * @param a -> 2d array that is to be printed
     * prints out a 2d array in a structured and organized manner
     */
    public static void print2DArray(String[][] a){
        System.out.println("[");
        for(int i=0; i<a.length; i++){
            System.out.print("  [");
            for(int j=0; j<a[i].length-1; j++){
                System.out.print(a[i][j]+" | ");
            }
            System.out.println(a[i][a[i].length-1]+"]");
        }
        System.out.println("]");
    }

    /**
     *
     * @param a -> array that is to be printed
     * prints an Array in a structured and organized manner
     */
    public static void printArray(String[] a){
        System.out.println("[");
        for(int i=0; i<a.length; i++){
            System.out.println("  "+a[i]);
        }
        System.out.println("]");
    }

    /**
     *
     * @param file -> a 2d array that contains String values
     * @param building -> String that is building name of what user wants
     * @return int cnt: row that building is on
     * searches each index of file to see where building is at
     */

    public static int findBuilding(String[][] file, String building){
        //String currString = file[0][0];
        int cnt = 0;
        for(int r = 0; r < file.length; r++) {
            cnt++;
            for(int c = 0; c < file[r].length; c++) {
                if(building.toLowerCase().equals(file[r][c])) {
                    return cnt;
                }
            }
        }
        return -1;
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return String that contains feature of buildingName
     */
    public static String findFeature(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return file[row - 1][1];                                                //returns whatever is in the index of [row - 1][1] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return String that contains reason for the feature of buildingName
     */
    public static String findFeatureReason(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return file[row - 1][2];                                                //returns whatever is in the index of [row - 1][2] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return String that contains purpose of buildingName
     */
    public static String findPurpose(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return file[row - 1][4];                                                //returns whatever is in the index of [row - 1][4] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return int that contains number of purposes for buildingName
     */
    public static int findNumOfPurposes(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return Integer.parseInt(file[row - 1][5].trim());                       //returns whatever is in the index of [row - 1][5] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return int that contains year buildingName was established
     */
    public static int findEstablishmentYear(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                                //calls findBuilding() method in order to find row that building is on
        return Integer.parseInt(file[row - 1][3].trim());                          //returns whatever is in the index of [row - 1][3] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return String that contains who buildingName was named after
     */
    public static String findNamesake(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return file[row - 1][6];                                                //returns whatever is in the index of [row - 1][6] in the file[][]
    }

    /**
     * @param file -> a 2d array of String values
     * @param buildingName -> a String that is the building name of what the user wants
     * @return String that contains the reason for the name of buildingName
     */
    public static String findNamesakeReason(String[][] file, String buildingName){
        int row = findBuilding(file, buildingName);                             //calls findBuilding() method in order to find row that building is on
        return file[row - 1][7];                                                //returns whatever is in the index of [row - 1][7] in the file[][]
    }

    /**
     *
     * @param primaryIntent -> the primary intent of the user's question
     * @param secondaryIntent -> the second intent, if any, of the user's question
     * @param num -> the year, if any, that the user is questioning
     * @param file -> 2d array of data or answers
     * @param name -> building name user is curious about
     */
    public static void whatIsIntent(String primaryIntent, String secondaryIntent, int num, String[][] file, String name){
        try {   //try everything in this block
        int cnt = 0;    //counter used for year related logic statements
        /*
        Below searches for the feature as well as the reason for a feature of the building the user wants to know about.
         */
        if (primaryIntent.toLowerCase().trim().equals("feature")) {
            if (secondaryIntent.toLowerCase().trim().equals("reason")) {
                if(findFeatureReason(file, name).trim().toLowerCase().equals("na")) {
                    System.out.println("404: Information not found");
                } else {
                    System.out.println("The reason for feature of the " + name + " is the " + findFeatureReason(file, name));
                }
            } else {
                if(findFeature(file, name).trim().toLowerCase().equals("na")) {
                    System.out.println("404: Information not found");
                } else {
                    System.out.println("The feature in the " + name + " is the " + findFeature(file, name));
                }
            }
            /*
        Below searches for the purpose as well as the number of purposes of a building the user wants to know about.
         */
        } else if (primaryIntent.toLowerCase().trim().equals("purpose")) {
            if (secondaryIntent.toLowerCase().trim().equals("number")) {
                if (findNumOfPurposes(file, name) > 1) {
                    System.out.println("There are " + findNumOfPurposes(file, name) + " purposes in the " + name);
                } else {
                    System.out.println("There is " + findNumOfPurposes(file, name) + " purpose in " + name);
                }
            } else {
                System.out.println("The purpose of the " + name + " is to " + findPurpose(file, name));
            }
            /*
        Below searches for the establishment year for a building the user wants to know about as well as the number of buildings
        on campus during a certain year.
         */
        } else if (primaryIntent.toLowerCase().trim().equals("establishment")) {
            if (secondaryIntent.toLowerCase().trim().equals("number")) {
                for (int i = 0; i < file.length - 1; i++) {
                    if (Integer.parseInt(file[i + 1][3]) <= num) {
                        cnt++;
                    }
                }
                System.out.println("There were " + cnt + " buildings in the year " + num);
            } else {
                System.out.println(name + " was established in the year " + findEstablishmentYear(file, name));
            }
            /*
        Below searches for the namesake as well as the reason for the namesake of a building that the user wants.
         */
        } else if (primaryIntent.toLowerCase().trim().equals("namesake")) {
            if (secondaryIntent.toLowerCase().trim().equals("reason")) {
                if(findNamesakeReason(file, name).trim().toLowerCase().equals("na")) {
                    System.out.println("404: Information not found");
                } else {
                    System.out.println("The reason for the name of " + name + " is because " + findNamesakeReason(file, name));
                }
            } else {
                if(findNamesake(file, name).trim().toLowerCase().equals("na")) {
                    System.out.println("404: Information not found");
                } else {
                    System.out.println("The " + name + " was named after " + findNamesake(file, name));
                }
            }
        }
    }
        catch(Exception e) { //catch all errors and return error message.
            System.out.println("You may have spelled the something wrong or input an incorrect value. " +
                    "Please fix mistake immediately.");
        }
    }
}
