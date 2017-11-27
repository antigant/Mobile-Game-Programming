package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Jadelays on 8/11/2017.
 */

/*This class will manage reading and writing*/

public class FileManager
{
    void Save(HashMap<String, Student> students)
    {
        try
        {
            FileWriter fw = new FileWriter("Records.txt");
            PrintWriter pw = new PrintWriter(fw);

            for(String key : students.keySet())
                pw.println(students.get(key).Name + "," + students.get(key).RegistrationNum + "," + students.get(key).Gender + "," + students.get(key).GPA);

            pw.close();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    HashMap<String, Student> Load()
    {
        HashMap<String, Student> hashStudent = new HashMap<>();
        try{
            FileReader fr = new FileReader("Records.txt");
            BufferedReader br = new BufferedReader(fr);
            String line, DataSplitBy = ",";

            while((line = br.readLine()) != null)
            {
                Student s = new Student();

                // use comma as a separator
                String[] data = line.split(DataSplitBy);

                s.Name = data[0];
                s.RegistrationNum = data[1];
                s.Gender = data[2].charAt(0);
                s.GPA = Float.parseFloat(data[3]);
                hashStudent.put(s.RegistrationNum, s);
            }
            br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return hashStudent;
    }
}
