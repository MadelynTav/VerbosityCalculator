package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args)
    {

        // An abstract representation of a File
        
        File MobyD = new File(
                "/Users/c4q-madelyntavarez/Desktop/VerbosityCalculator/src/nyc/c4q/ac21/MobyD");
        File Dickens = new File(
                "/Users/c4q-madelyntavarez/Desktop/VerbosityCalculator/src/nyc/c4q/ac21/Dickens");

        verbosity(MobyD);
        verbosity(Dickens);

        if (verbosity(MobyD)>verbosity(Dickens))
        {
            System.out.println(
                    "Moby Dick is more Verbose with an average number of words of " + verbosity(
                            MobyD));
        }
        else if(verbosity(Dickens) > verbosity(MobyD))
        {
            System.out.println(
                    "Charles Dickens is more verbose with an average number of words of" + verbosity(
                            Dickens));
        }
        else
        {
            System.out.println("Charles Dickens and Moby Dick are verbosity Twins!");
        }
        }



    public static double verbosity(File myFile){
        DecimalFormat format = new DecimalFormat();
        double totalWords=0.0;
        double totalSentences=0.0;
        double verbosity=0.0;

        try{
            Scanner sc = new Scanner(myFile);
            while (sc.hasNext())
            {
                String newFile = sc.next();
                totalWords++;

                if(newFile.contains("Mr.") || newFile.contains("Mrs.") || newFile.contains("Dr."))
                    continue;

                else if(newFile.contains(".")||newFile.contains("!")|| newFile.contains("?"))
                    totalSentences++;
            }

            verbosity= totalWords/totalSentences;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    return verbosity;
    }

}
