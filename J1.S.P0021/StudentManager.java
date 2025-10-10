/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21_duc;
import java.util.*;
/**
 *
 * @author DELL
 */
public class StudentManager {
    
    private static ArrayList<Student> studentList = new ArrayList<>();
    public static void option(){
        int choice;
        while (true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Validation.checkInt(1, 5);
            
            switch(choice){
                case 1:
                    create();
                    break;
                case 2:
                    findAndSort(studentList);
                    break;
                case 3:
                    updateOrDelete(studentList);
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    System.out.println("Exit........");
                    return;
            }
        }
    }
    
    private static void inputStu(){
        System.out.print("ID: ");
        String id = Validation.checkInput();
        System.out.print("Name: ");
        String name = Validation.checkInput();
        System.out.print("Semester: ");
        int semester = Validation.checkInt(1, 20);
        System.out.print("Course name: ");
        String courseName = Validation.checkCourseName();
        if (Validation.checkDuplicatedStudent(studentList, id, name, semester, courseName)){
            Student newStu = new Student(id,name,semester,courseName);
            studentList.add(newStu);
        }
    }
    
    private static void create(){
        System.out.print("Enter number of student input: ");
        int numStu = Validation.checkInt(1, Integer.MAX_VALUE);
        if (numStu > 10){
            if (!Validation.checkYN()){
                return;
            }
            
        }
        while (numStu != 0){
            inputStu();
            numStu--;
        }
    }
    
    private static ArrayList<Student> filterStu (ArrayList<Student> studentList){
        System.out.print("Name find: ");
        String nameFind = Validation.checkInput();
        ArrayList<Student> listFilter = new ArrayList<>();
        
        for (Student stu : studentList){
            if (stu.getName().toLowerCase().contains(nameFind.toLowerCase())){
                listFilter.add(stu);
            }
        }
        return listFilter;
    }
    
    public static void findAndSort(ArrayList<Student> studentList){
        ArrayList<Student> listStudentFindByName = filterStu(studentList);
        if (listStudentFindByName.isEmpty()){
            System.err.println("No name matched");
        } else {
            Collections.sort(listStudentFindByName, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getName().compareToIgnoreCase(s2.getName());
                }
            });
        }
        for (Student student : listStudentFindByName){
            student.print();
        }
    }
    
    public static void updateOrDelete(ArrayList<Student> ls){
        System.out.print("Enter student ID: ");
        String id = Validation.checkInput();
        boolean checkHave = false;
        for (Student student : ls){
            if (student.getId().equalsIgnoreCase(id)){
                checkHave = true;
                System.out.print("Do you want to update (U) or delete (D) student: ");
                if (Validation.checkUD()){
                    System.out.print("Enter student id: ");
                    String studentID = Validation.checkInput();
                    System.out.print("Enter student name: ");
                    String studentName = Validation.checkInput();
                    System.out.print("Enter semester: ");
                    int semester = Integer.parseInt(Validation.checkInput());
                    System.out.print("Enter student course name: ");
                    String courseName = Validation.checkInput();                 
                    if (!Validation.checkDuplicatedStudent(ls, studentID, studentName, semester, courseName)){
                        student.setCourseName(courseName);
                        student.setName(studentName);
                        student.setId(studentID);
                        student.setSemester(semester);
                        System.out.println("Update successfully");
                        return;
                    } 
                } else {
                    ls.remove(student);
                    System.out.println("Delete successfully");
                    return;
                }
            } 
            if (!checkHave){
                System.out.println("No student ID matched");
            }
        }
    }
    
    public static void report(){
        HashMap<String, Integer> reportStu = new HashMap<>();
        for (Student stu : studentList){
            String key = stu.getId() + "|" + stu.getName() + "|" + stu.getCourseName();
            if (reportStu.containsKey(key)){
                int value = reportStu.get(key);
                reportStu.put(key, value+1);
            } else {
                reportStu.put(key, 1);
            }
        }
        
        for (String key : reportStu.keySet()){
            System.out.println(key + "|" + reportStu.get(key));
        }
    }
}
