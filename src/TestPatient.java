public class TestPatient {

    public static void main(String[] args) {

        // ==============================
        // BST - PATIENT RECORDS
        // ==============================

        PatientBST bst = new PatientBST();

        Patient p1 = new Patient(
                105,
                "Ahmed",
                25,
                "0771234567",
                "Fever"
        );

        Patient p2 = new Patient(
                101,
                "Hansa",
                22,
                "0712345678",
                "Headache"
        );

        Patient p3 = new Patient(
                120,
                "Sara",
                30,
                "0756789012",
                "Accident"
        );

        Patient p4 = new Patient(
                99,
                "Nimal",
                40,
                "0763456789",
                "Diabetes"
        );

        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);
        bst.insert(p4);

        System.out.println("===== ALL PATIENTS =====");

        bst.inOrder();


        // ==============================
        // BST SEARCH
        // ==============================

        System.out.println("\n===== SEARCH PATIENT =====");

        Patient result = bst.search(101);

        if (result != null) {
            System.out.println("Patient Found:");
            result.displayPatient();
        }
        else {
            System.out.println("Patient not found.");
        }


        // ==============================
        // BST DELETE
        // ==============================

        System.out.println("\n===== DELETE PATIENT =====");

        bst.delete(101);

        System.out.println("\n===== PATIENTS AFTER DELETE =====");

        bst.inOrder();


        // ==============================
        // EMERGENCY QUEUE
        // ==============================

        System.out.println("\n===== EMERGENCY QUEUE TEST =====");

        EmergencyQueue queue = new EmergencyQueue();

        Patient p5 = new Patient(
                130,
                "Kamal",
                35,
                "0771111111",
                "Injury"
        );

        Patient p6 = new Patient(
                140,
                "Fathima",
                28,
                "0772222222",
                "Chest Pain"
        );

        Patient p7 = new Patient(
                150,
                "Nimal",
                45,
                "0773333333",
                "Accident"
        );

        // Add patients to queue
        queue.enqueue(p5);
        queue.enqueue(p6);
        queue.enqueue(p7);

        // Display waiting patients
        queue.displayQueue();

        // Remove first patient
        System.out.println("\n===== DEQUEUE =====");

        queue.dequeue();

        // Display queue after dequeue
        queue.displayQueue();


        // ==============================
        // EMPTY QUEUE TEST
        // ==============================

        System.out.println("\n===== EMPTY QUEUE TEST =====");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();


        // ==============================
        // TREATMENT STACK
        // ==============================

        System.out.println("\n===== TREATMENT STACK TEST =====");

        TreatmentStack stack = new TreatmentStack();

        // Add completed treatments
        stack.push(
                p5,
                "Wound dressing and medication"
        );

        stack.push(
                p6,
                "ECG test and medication"
        );

        stack.push(
                p7,
                "Emergency surgery"
        );

        // Display treatment history
        stack.displayStack();


        // ==============================
        // POP TEST
        // ==============================

        System.out.println("\n===== POP LATEST TREATMENT =====");

        stack.pop();

        // Display stack after pop
        stack.displayStack();


        // ==============================
        // EMPTY STACK TEST
        // ==============================

        System.out.println("\n===== EMPTY STACK TEST =====");

        stack.pop();
        stack.pop();
        stack.pop();


        // ==============================
        // PATIENT VISIT HISTORY
        // SINGLY LINKED LIST
        // ==============================

        System.out.println("\n===== PATIENT VISIT HISTORY TEST =====");

        VisitLinkedList visitHistory = new VisitLinkedList();

        Visit v1 = new Visit(
                1,
                "2026-08-01",
                "Dr. Perera",
                "Fever",
                "Medicine and rest"
        );

        Visit v2 = new Visit(
                2,
                "2026-08-10",
                "Dr. Silva",
                "Headache",
                "Pain relief medicine"
        );

        Visit v3 = new Visit(
                3,
                "2026-08-20",
                "Dr. Fernando",
                "Injury",
                "Wound dressing"
        );


        // Add visits
        visitHistory.addVisit(v1);
        visitHistory.addVisit(v2);
        visitHistory.addVisit(v3);


        // Display visit history
        visitHistory.displayVisits();


        // ==============================
        // SEARCH VISIT
        // ==============================

        System.out.println("\n===== SEARCH VISIT =====");

        Visit visitResult = visitHistory.searchVisit(2);

        if (visitResult != null) {

            System.out.println("Visit Found:");

            visitResult.displayVisit();

        }
        else {

            System.out.println("Visit not found.");
        }


        // ==============================
        // REMOVE VISIT
        // ==============================

        System.out.println("\n===== REMOVE VISIT =====");

        visitHistory.removeVisit(2);


        // Display after removing
        visitHistory.displayVisits();


        // ==============================
        // EMPTY / NOT FOUND TEST
        // ==============================

        System.out.println("\n===== SEARCH REMOVED VISIT =====");

        Visit removedVisit = visitHistory.searchVisit(2);

        if (removedVisit != null) {

            removedVisit.displayVisit();

        }
        else {

            System.out.println("Visit 2 not found.");
        }
    }
}