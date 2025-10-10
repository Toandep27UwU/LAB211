/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg22;

import java.util.*;

/**
 *
 * @author DELL
 */
public class CandidateManager {

    private static ArrayList<Candidate> candidateList = new ArrayList<>();

    public static void option() {
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    addYesNo(0);
                    displayAllCandidates(candidateList);
                    break;
                case 2:
                    addYesNo(1);
                    displayAllCandidates(candidateList);
                    break;
                case 3:
                    addYesNo(2);
                    displayAllCandidates(candidateList);
                    break;
                case 4:
                    searching(candidateList);
                    break;
                case 5:
                    System.out.println("Exit....");
                    return;
            }
        } while (true);

    }

    public static void createCandidate(ArrayList<Candidate> candidateList, int type) {
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        System.out.print("Enter first name: ");
        String firstName = Validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = Validation.checkInputString();
        System.out.print("Enter birth date: ");
        int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter address: ");
        String address = Validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = Validation.checkInputPhone();
        System.out.print("Enter email: ");
        String email = Validation.checkInputEmail();
        if (Validation.checkIdExist(candidateList, id)) {
            switch (type) {
                case 1:
                    int expInYear = Validation.checkInputIntLimit(0, Calendar.getInstance().get(Calendar.YEAR));
                    String proSkill = Validation.checkInputString();
                    Experience experience = new Experience(expInYear, proSkill, id, firstName, lastName, birthDate, address, phone, email, type);
                    candidateList.add(experience);
                    break;
                case 2:
                    String graduationDate = Validation.checkInputString();
                    String rank = Validation.checkInputGraduationRank();
                    Fresher fresher = new Fresher(graduationDate, rank, id, firstName, lastName, birthDate, address, phone, email, type);
                    candidateList.add(fresher);
                    break;
                case 3:
                    String majors = Validation.checkInputString();
                    int semester = Validation.checkInputIntLimit(1, 20);
                    String universityName = Validation.checkInputString();
                    Internship intern = new Internship(majors, semester, universityName, id, firstName, lastName, birthDate, address, phone, email, type);
                    candidateList.add(intern);
                    break;
            }
            System.out.println("Add successfully");
        } else {
            System.out.println("ID exists");
        }
    }

    public static void addYesNo(int type) {
        do {
            createCandidate(candidateList, type);
            System.out.print("Do you want to continue (Y/N)? ");
        } while (Validation.checkInputYN());
    }

    public static void displayAllCandidates(ArrayList<Candidate> candidateList) {
        for (Candidate candidate : candidateList) {
            System.out.println(candidate);
        }
    }

    public static void searching(ArrayList<Candidate> candidateList) {
        System.out.println("=== EXPERIENCE ===");
        displayName(candidateList,0);
        System.out.println("=== FRESHER ===");
        displayName(candidateList,1);
        System.out.println("=== INTERNSHIP ===");
        displayName(candidateList,2);
        
        System.out.println("Enter name: ");
        String findName = Validation.checkInputString();
        System.out.println("Enter type: ");
        int findType = Validation.checkInputIntLimit(0, 2);
        
        for (Candidate candidate : candidateList){
            if ((candidate.getFirstName().contains(findName) || candidate.getLastName().contains(findName)) && candidate.getType() == findType){
                System.out.println(candidate);
            }
        }
    }

    public static void displayName(ArrayList<Candidate> candidateList, int type) {
        for (Candidate candidate : candidateList) {
            if (candidate.getType() == type) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

}

