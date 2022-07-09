package ExerciseOne;

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
                System.out.println("Longitud de datos: " + fileData.length);

                String nameData = Optional.of(fileData[0]).orElse("Desconocido");
                String cityData = Optional.of(fileData[1]).orElse("Desconocido");
                String age = Optional.of(fileData[2]).orElse("Desconocido");

                Person auxPerson = new Person(nameData, cityData, age);
                System.out.println(auxPerson.toString());
                personList.add(auxPerson);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
