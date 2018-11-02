import java.util.*;
import java.io.*;

public class ParseCSV {
    public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
        String csv = "C:\\Users\\Emman\\IdeaProjects\\FYSM_Alexa_Skill\\src\\FYSM AI Buildings Project.csv";
        Scanner csvFile = new Scanner(new File(csv));
        String currString = "";
        String[][] csvInfo = new String[33][8];
        int cnt = 0, cnt1 = 0;
        //String nexLine = "";

        while(csvFile.hasNext()) {
            //nexLine = csvFile.nextLine();
            cnt1 = 0;
            while(cnt1 < csvInfo[cnt].length - 1){
                if(csvFile.next() != " | ") {
                    currString += csvFile.next();
                }
                else {
                    csvInfo[cnt][cnt1] = currString;
                    currString = "";
                    cnt1++;
                }
            }
            cnt++;
        }

        System.out.println(csvFile);
    }
}