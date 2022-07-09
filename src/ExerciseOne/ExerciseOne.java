package ExerciseOne;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ExerciseOne {
    private static ArrayList<Person> importDataFile (String filePath) {
        File inputFile = new File(filePath);

        ArrayList<Person> personList;
        try {
            Scanner scanner = new Scanner(inputFile);
            personList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String fileLine = scanner.nextLine();
                String fileData[];
                //Overload split function with a negative limit makes function doesnt discard empty values
                fileData = fileLine.split(":", -1);

                Person auxPerson;
                //This switch would be unnecessary if file syntax always contains :: delimiters
                switch (fileData.length) {
                    case 1:
                        auxPerson = new Person(fileData[0], "",  "");
                        break;
                    case 2:
                        auxPerson = new Person(fileData[0], fileData[1],  "");
                        break;
                    default:
                        auxPerson = new Person(fileData[0], fileData[1], fileData[2]);
                }

                personList.add(auxPerson);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\oscar.clorenzo\\IdeaProjects\\Exercises\\src\\ExerciseOne\\inputFile.txt";
        ArrayList<Person> personList = importDataFile(filePath);
        personList.stream().filter(p -> p.getAge() != null && Integer.parseInt(p.getAge()) < 25).forEach(p -> System.out.println(p.toString()));

    }
}
