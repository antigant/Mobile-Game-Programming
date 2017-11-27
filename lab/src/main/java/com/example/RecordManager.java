package com.example;
import java.util.HashMap;

/**
 * Created by 160324T on 10/30/2017.
 */

public class RecordManager
{
    HashMap<String, Student> students = new HashMap<>(); // Using register number
    FileManager fileManager = new FileManager();

    String GetStudentList()
    {
        String List = "Student List:\n";
        int i = 0;

        if(students.size() <= 0)
            return "The list is empty";

        for(String key : students.keySet())
        {
            ++i;
            List += i + ") Name: " + students.get(key).Name + ", Admin Number: " + students.get(key).RegistrationNum
                    + ", Gender: " + students.get(key).Gender + ", GPA: " + students.get(key).GPA + '\n';
        }

        return List;
    }

    void AddStudent(Student newRecord)
    {
        students.put(newRecord.RegistrationNum, newRecord);
    }

    void SaveStudentData()
    {
        fileManager.Save(students);
    }

    void LoadStudentData()
    {
        students = fileManager.Load();
    }

    void RemoveStudent(String registrationNumToRemove)
    {
        students.remove(registrationNumToRemove);
    }

    int GetNumStudents()
    {
        return students.size();
    }

    int GetNumMaleStudents()
    {
        int total = 0;
        for(String key : students.keySet())
        {
            if(students.get(key).Gender == 'M' || students.get(key).Gender == 'm')
                ++total;
        }
        return total;
    }

    int GetNumFemaleStudents()
    {
        int total = 0;
        for(String key : students.keySet())
        {
            if(students.get(key).Gender == 'F' || students.get(key).Gender == 'f')
                ++total;
        }
        return total;
    }

    float GetAverageGPA()
    {
        float averageGPA = 0.f;

        for(String key : students.keySet())
            averageGPA += students.get(key).GPA;

        return averageGPA /= students.size();
    }

    boolean ExistingRegistrationNumber(String registrationNumber)
    {
        for(String key : students.keySet())
        {
            if(students.get(key).RegistrationNum.equals(registrationNumber))
                return true;
        }
        return false;
    }
}
