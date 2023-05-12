package guiJAVA.srcCsv.csvConverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import guiJAVA.srcCsv.Classes.Student;

public class CsvToJsonTest {
    String file = "guiJAVA/srcCsv/csvConverter/StudentsTest.csv";
    Student stu;
    BufferedReader reader;
    String line = "";

    public ArrayList<Student> run() {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            reader = new BufferedReader(new FileReader(file)); // reads the file
            while ((line = reader.readLine()) != null) { // keeps reading till the end of the document

                String[] row = line.split(";"); // splits the string on " ; " and store in an array
                
                String name = row[0];
                int grade = Integer.parseInt(row[1]);
                String result = row[2];

                students.add(new Student(name, grade, result));

                // for (String index : row) {
                //     students.add(index);
                //     System.out.printf("%-10s", index);
                // } System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return students;

    }

    public static void main(String[] args) {
        new CsvToJsonTest().run();
    }

}