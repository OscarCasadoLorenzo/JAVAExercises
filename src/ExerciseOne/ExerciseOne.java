package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\oscar.clorenzo\\IdeaProjects\\Exercises\\src\\ExerciseOne\\inputFile.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            List<Person> personList = new ArrayList< >();

            while (scanner.hasNextLine()){
                String fileLine = scanner.nextLine();
                String fileData[] = {null, null, null} ;
                fileData = fileLine.split(":");
                System.out.println(Arrays.toString(fileData));

                Person auxPerson = new Person(fileData[0], fileData[1], fileData[2]);
                personList.add(auxPerson);
            }

            personList.stream().filter( l -> l.getAge() > 25);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
