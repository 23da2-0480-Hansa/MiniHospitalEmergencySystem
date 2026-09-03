public class TreatmentStack {

    // Node for Stack
    private class Node {
        Patient patient;
        String treatment;
        Node next;

        Node(Patient patient, String treatment) {
            this.patient = patient;
            this.treatment = treatment;
            this.next = null;
        }
    }

    private Node top;

    // Constructor
    public TreatmentStack() {
        top = null;
    }

    // Push a completed treatment
    public void push(Patient patient, String treatment) {

        Node newNode = new Node(patient, treatment);

        newNode.next = top;
        top = newNode;

        System.out.println(
                "Treatment record added for Patient "
                + patient.getPatientId()
        );
    }

    // Pop the most recent treatment
    public Patient pop() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        Patient patient = top.patient;

        System.out.println(
                "Latest treatment removed for Patient "
                + patient.getPatientId()
        );

        top = top.next;

        return patient;
    }

    // Display treatment history
    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\n===== TREATMENT HISTORY =====");

        Node current = top;

        while (current != null) {

            System.out.println(
                    "Patient ID : "
                    + current.patient.getPatientId()
            );

            System.out.println(
                    "Patient Name : "
                    + current.patient.getPatientName()
            );

            System.out.println(
                    "Treatment : "
                    + current.treatment
            );

            System.out.println("----------------------------");

            current = current.next;
        }
    }
}