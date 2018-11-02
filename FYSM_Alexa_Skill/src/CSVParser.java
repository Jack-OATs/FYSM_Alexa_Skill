import java.util.*;
import java.io.*;

public class CSVParser{
   public static void main(String[] args) throws FileNotFoundException{
//      String building = args[0];
//      System.out.println(building);
      String delimiter = " ; ";
      String inputFileName = "C:\\Users\\Emman\\IdeaProjects\\FYSM_Alexa_Skill\\src\\FYSM AI Buildings Project.csv";
      Scanner fin = new Scanner(new File(inputFileName));
      String[] lines = new String[100];
      int cnt = 0;
      while(fin.hasNextLine()){
         lines[cnt] = fin.nextLine();
         cnt++;
      }
      String[] info = new String[cnt];
      for(int i=0; i<info.length; i++){
         info[i] = lines[i];
      }
      // printArray(info);
      int l = info[0].split(delimiter).length;
      String[][] csvInfo = new String[info.length][l];
      cnt=0;
      for(int i=0; i<info.length; i++){
         csvInfo[cnt] = info[i].split(delimiter);
         cnt++;
      }
       print2DArray(csvInfo);
      System.out.println(findBuilding(csvInfo, "Anderson Hall"));
      //Converting String to int
//      String s = "1991 ";
//      int year = Integer.parseInt(s.trim());
//      System.out.println(year);
   }
   
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
   
   public static void printArray(String[] a){
      System.out.println("[");
      for(int i=0; i<a.length; i++){
         System.out.println("  "+a[i]);
      }
      System.out.println("]");
   }

    public static int findBuilding(String[][] file, String building){
        //String currString = file[0][0];
        int cnt = 0;
        for(int r = 0; r < file.length; r++) {
            cnt++;
            for(int c = 0; c < file[r].length; c++) {
                if(building == file[r][c]) {
                    return cnt;
                }
            }
        }
        return -1;
    }

//    public static String findFeature(String buildingName, int row){
//
//    // }
//
//    // public static String findFeatureReason(String buildingName, int row){
//
//    // }
//
//    // public static String findBuilding(String feature, int row){
//
//    // }
//
//    // public static String findPurpose(String buildingName, int row){
//
//    // }
//
//    // public static int findNumOfPurposes(String buildingName, int row){
//
//    // }
//
//    // public static int findEstablishmentYear(String buildingName, int row){
//
//    // }
//
//    // public static String findNamesake(String buildingName, int row){
//
//    // }
//
//    // public static String findNamesakeReason(String buildingName, int row){
//
//    // }
}
