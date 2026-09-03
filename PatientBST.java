public class PatientBST {

    // Node of the Binary Search Tree
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor
    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node current, Patient patient) {

        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);
        }
        else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRecursive(current.right, patient);
        }
        else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    // Search for a patient
    public Patient search(int patientId) {
        Node result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    // Delete a patient
public void delete(int patientId) {
    root = deleteRecursive(root, patientId);
}

private Node deleteRecursive(Node current, int patientId) {

    if (current == null) {
        System.out.println("Patient not found.");
        return null;
    }

    // Search in the left subtree
    if (patientId < current.patient.getPatientId()) {
        current.left = deleteRecursive(current.left, patientId);
    }

    // Search in the right subtree
    else if (patientId > current.patient.getPatientId()) {
        current.right = deleteRecursive(current.right, patientId);
    }

    // Patient found
    else {

        System.out.println("Patient " + patientId + " deleted successfully.");

        // Case 1: No child
        if (current.left == null && current.right == null) {
            return null;
        }

        // Case 2: Only right child
        if (current.left == null) {
            return current.right;
        }

        // Case 3: Only left child
        if (current.right == null) {
            return current.left;
        }

        // Case 4: Two children
        Node successor = findMinimum(current.right);

        current.patient = successor.patient;

        current.right =
                deleteRecursive(current.right,
                        successor.patient.getPatientId());
    }

    return current;
}

// Find the smallest node
private Node findMinimum(Node current) {

    while (current.left != null) {
        current = current.left;
    }

    return current;
}

    private Node searchRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    // Display patients in ascending order
    public void inOrder() {
        if (root == null) {
            System.out.println("No patients found.");
            return;
        }

        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {
            inOrderRecursive(current.left);

            current.patient.displayPatient();
            System.out.println("----------------------------");

            inOrderRecursive(current.right);
        }
    }
}