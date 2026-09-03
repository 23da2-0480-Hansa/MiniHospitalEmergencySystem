public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Constructor
    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Add patient to the queue
    public void enqueue(Patient patient) {

        Node newNode = new Node(patient);

        // Queue is empty
        if (rear == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(
                "Patient " + patient.getPatientId()
                + " added to emergency queue."
        );
    }

    // Remove the first patient
    public Patient dequeue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        System.out.println(
                "Patient " + patient.getPatientId()
                + " removed for treatment."
        );

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n===== EMERGENCY WAITING QUEUE =====");

        Node current = front;

        while (current != null) {

            System.out.println(
                    "Patient ID: "
                    + current.patient.getPatientId()
                    + " | Name: "
                    + current.patient.getPatientName()
            );

            current = current.next;
        }

        System.out.println("===================================");
    }
}