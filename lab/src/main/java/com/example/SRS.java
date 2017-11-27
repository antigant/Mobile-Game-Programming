package com.example;
import java.util.Scanner;
import java.lang.Object.*;

/**
 * Created by 160324T on 10/30/2017.
 */

public class SRS
{
    public static boolean isFloat(String UserInput)
    {
        return UserInput.matches("[0-9.]+");
    }

    public static void main (String []args)
    {
        boolean Exit = false;
        String UserInput;
        char choice;
        RecordManager Manager = new RecordManager();
        Manager.LoadStudentData();

        do
        {
            System.out.println("[1] Print Student List");
            System.out.println("[2] Create Student List");
            System.out.println("[3] Delete Student List");
            System.out.println("[0] Exit");
            Scanner scanner = new Scanner(System.in);        // std::cin (in C++)
            UserInput = scanner.nextLine();                  // std::cin (in C++)

            if(UserInput.charAt(0) == '0')
            {
                System.out.println("See you again!");
                Manager.SaveStudentData();
                Exit = true;
            }

            if(UserInput.length() > 1)
            {
                System.out.println("Input too long");
                continue;
            }

            choice = UserInput.charAt(0);

            switch(choice)
            {
                case '1':
                    System.out.println(Manager.GetStudentList());
                    break;

                case '2':
                {
                    Student newStudent = new Student();

                    // Name of Student
                    System.out.println("Name of student:");
                    newStudent.Name = scanner.nextLine();

                    // Registration Number of student
                    System.out.println("Admin Number (3 characters):");
                    while(true)
                    {
                        newStudent.RegistrationNum = scanner.next();
                        if(newStudent.RegistrationNum.length() > 3)
                        {
                            System.out.println("Admin Number too long");
                            continue;
                        }
                        else if(newStudent.RegistrationNum.length() < 3)
                        {
                            System.out.println("Admin Number too short");
                            continue;
                        }
                        if(Manager.ExistingRegistrationNumber(newStudent.RegistrationNum))
                        {
                            System.out.println("Admin Number already exist, choose other admin number");
                            continue;
                        }
                        break;
                    }
                    // Gender of student
                    System.out.println("Gender of student (M/F):");
                    while(true)
                    {
                        newStudent.Gender = scanner.next().charAt(0);
                        if(newStudent.Gender != 'M' && newStudent.Gender != 'F' && newStudent.Gender != 'm' && newStudent.Gender != 'f')
                        {
                            System.out.println("Invalid Gender, choose Male(M) or Female(F)");
                            continue;
                        }
                        break;
                    }

                    // GPA of student
                    System.out.println("GPA of student:");
                    while(true)
                    {
                        UserInput = scanner.next();
                        if(!isFloat(UserInput))
                        {
                            System.out.println("GPA of student should not contain non-numeric characters.");
                            continue;
                        }
                        break;
                    }
                    newStudent.GPA = Float.parseFloat(UserInput);
                    Manager.AddStudent(newStudent);
                    break;
                }

                case '3':
                    System.out.println("Enter a admin number to delete a student's record");

                    while(true)
                    {
                        UserInput = scanner.next();
                        if(UserInput.length() != 3)
                        {
                            System.out.println("Invalid Admin Number");
                            continue;
                        }
                        else if(!Manager.ExistingRegistrationNumber(UserInput))
                        {
                            System.out.format("No such student with %s as their admin number", UserInput);
                            continue;
                        }
                        break;
                    }

                    Manager.RemoveStudent(UserInput);
                    System.out.format("Student with Admin Number %s has successfully been removed from the system.\n", UserInput);
                    break;
            }
        } while(!Exit);
    }
}
