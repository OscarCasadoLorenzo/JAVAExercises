package ExerciseOne;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ExerciseOne {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\oscar.clorenzo\\IdeaProjects\\Exercises\\src\\ExerciseOne\\inputFile.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            List<Person> personList = new ArrayList< >();

            while (scanner.hasNextLine()){
                String fileLine = scanner.nextLine();
                String fileData[];
                //Overload split function with a negative limit makes function doesnt discard empty values
                fileData = fileLine.split(":", -1);

                Person auxPerson;
                switch (fileData.length){
                    case 1: auxPerson = new Person(fileData[0], null, null);
                        break;
                    case 2: auxPerson = new Person(fileData[0], fileData[1], null);
                        break;
                    default: auxPerson = new Person(fileData[0], fileData[1], fileData[2]);
                }




                System.out.println(auxPerson.toString());
                personList.add(auxPerson);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
