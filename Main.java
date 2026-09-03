import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    static HashMap<Integer, VisitLinkedList> patientVisitHistories =
            new HashMap<>();


    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayAllPatients();
                    break;

                case 5:
                    addToEmergencyQueue();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    displayEmergencyQueue();
                    break;

                case 8:
                    addTreatmentRecord();
                    break;

                case 9:
                    removeLatestTreatment();
                    break;

                case 10:
                    displayTreatmentHistory();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    removePatientVisit();
                    break;

                case 13:
                    searchPatientVisit();
                    break;

                case 14:
                    displayPatientVisitHistory();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Thank you for using");
                    System.out.println("Mini Hospital Emergency Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void displayMenu() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("     MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("==============================================");

        System.out.println();
        System.out.println("----- PATIENT RECORDS - BST -----");
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println();
        System.out.println("----- EMERGENCY QUEUE -----");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");

        System.out.println();
        System.out.println("----- TREATMENT HISTORY - STACK -----");
        System.out.println("8. Add Treatment Record");
        System.out.println("9. Remove Latest Treatment Record");
        System.out.println("10. Display Treatment History");

        System.out.println();
        System.out.println("----- PATIENT VISIT HISTORY - LINKED LIST -----");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Patient Visit History");

        System.out.println();
        System.out.println("0. Exit");

        System.out.println("==============================================");
    }

    public static void registerPatient() {

        System.out.println();
        System.out.println("===== REGISTER NEW PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        if (patientBST.search(patientId) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                patientId,
                name,
                age,
                contact,
                condition
        );

        // Insert patient into BST
        patientBST.insert(patient);

        // Create visit history for this patient
        patientVisitHistories.put(
                patientId,
                new VisitLinkedList()
        );

        System.out.println();
        System.out.println("Patient registered successfully.");
    }


    public static void searchPatient() {

        System.out.println();
        System.out.println("===== SEARCH PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient != null) {

            System.out.println();
            System.out.println("Patient Found:");
            System.out.println("----------------------------");

            patient.displayPatient();

        }
        else {

            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        System.out.println();
        System.out.println("===== DELETE PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        patientBST.delete(patientId);

        // Remove patient's visit history
        patientVisitHistories.remove(patientId);

        System.out.println("Patient deleted successfully.");
    }


    public static void displayAllPatients() {

        System.out.println();
        System.out.println("===== ALL PATIENTS =====");

        patientBST.inOrder();
    }

    public static void addToEmergencyQueue() {

        System.out.println();
        System.out.println("===== ADD TO EMERGENCY QUEUE =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            System.out.println(
                    "Please register the patient first."
            );

            return;
        }

        emergencyQueue.enqueue(patient);
    }


    public static void treatNextPatient() {

        System.out.println();
        System.out.println("===== TREAT NEXT PATIENT =====");

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            return;
        }

        System.out.println();
        System.out.println("Patient selected for treatment:");

        patient.displayPatient();

        System.out.println();
        System.out.print("Enter completed treatment: ");

        String treatment = scanner.nextLine();

        // Store completed treatment in Stack
        treatmentStack.push(patient, treatment);
    }


    // ==========================================
    // 7. DISPLAY EMERGENCY QUEUE
    // ==========================================

    public static void displayEmergencyQueue() {

        System.out.println();
        System.out.println("===== EMERGENCY WAITING QUEUE =====");

        emergencyQueue.displayQueue();
    }


    public static void addTreatmentRecord() {

        System.out.println();
        System.out.println("===== ADD TREATMENT RECORD =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter treatment completed: ");
        String treatment = scanner.nextLine();

        treatmentStack.push(patient, treatment);
    }

    public static void removeLatestTreatment() {

        System.out.println();
        System.out.println("===== REMOVE LATEST TREATMENT =====");

        Patient patient = treatmentStack.pop();

        if (patient != null) {

            System.out.println(
                    "Treatment record removed for Patient "
                    + patient.getPatientId()
            );
        }
    }

    public static void displayTreatmentHistory() {

        System.out.println();
        System.out.println("===== TREATMENT HISTORY =====");

        treatmentStack.displayStack();
    }

    public static void addPatientVisit() {

        System.out.println();
        System.out.println("===== ADD PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        VisitLinkedList history =
                patientVisitHistories.get(patientId);

        history.addVisit(visit);
    }

    public static void removePatientVisit() {

        System.out.println();
        System.out.println("===== REMOVE PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history =
                patientVisitHistories.get(patientId);

        System.out.print("Enter Visit ID to remove: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        history.removeVisit(visitId);
    }

    public static void searchPatientVisit() {

        System.out.println();
        System.out.println("===== SEARCH PATIENT VISIT =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history =
                patientVisitHistories.get(patientId);

        System.out.print("Enter Visit ID to search: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        Visit visit = history.searchVisit(visitId);

        if (visit != null) {

            System.out.println();
            System.out.println("Visit Found:");
            System.out.println("----------------------------");

            visit.displayVisit();

        }
        else {

            System.out.println("Visit not found.");
        }
    }

    public static void displayPatientVisitHistory() {

        System.out.println();
        System.out.println("===== PATIENT VISIT HISTORY =====");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.println();
        System.out.println(
                "Visit History for Patient: "
                + patient.getPatientName()
        );

        VisitLinkedList history =
                patientVisitHistories.get(patientId);

        history.displayVisits();
    }
}