# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

### Individual Mid Assignment

## Student Information

**Name:** Hansa Fawzer  
**Student ID:** 23DA2-0480

---

## Project Description

This project is a Java-based Mini Hospital Emergency Management System.

The system manages patient records, emergency patients, completed treatments, and patient visit history using different data structures.

The system is implemented as a console-based Java application.

---

# Data Structures Used

## 1. Binary Search Tree (BST)

The Binary Search Tree is used to store patient records.

Patient ID is used as the key.

The system supports:

- Insert a new patient
- Search for a patient
- Delete a patient
- Display patients using in-order traversal

In-order traversal displays patients in ascending order of Patient ID.

---

## 2. Queue

The Queue is used to manage patients waiting for emergency treatment.

The queue follows the FIFO principle.

**FIFO means: First In, First Out**

The system supports:

- Enqueue a patient
- Dequeue the next patient
- Display waiting patients
- Handle an empty queue

---

## 3. Stack

The Stack is used to store completed treatment records.

The stack follows the LIFO principle.

**LIFO means: Last In, First Out**

The system supports:

- Push a treatment record
- Pop the latest treatment record
- Display treatment history
- Handle an empty stack

---

## 4. Singly Linked List

Each patient has a visit history stored using a Singly Linked List.

Each visit contains:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

The system supports:

- Add a visit
- Remove a visit
- Search for a visit
- Display visit history

---

# Project Structure

```text
MiniHospitalEmergencySystem
│
├── src
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── VisitLinkedList.java
│   └── TestPatient.java
│
├── Screenshots
│
└── README.md
```

---

# How to Run the Project

Open a terminal inside the `src` folder.

Compile the Java files:

```bash
javac *.java
```

Run the program:

```bash
java Main
```

---

# Main System Features

1. Register New Patient
2. Search Patient
3. Delete Patient
4. Display All Patients
5. Add Patient to Emergency Queue
6. Treat Next Patient
7. Display Emergency Queue
8. Add Treatment Record
9. Remove Latest Treatment Record
10. Display Treatment History
11. Add Patient Visit
12. Remove Patient Visit
13. Search Patient Visit
14. Display Patient Visit History
0. Exit

---

# Important Concepts Demonstrated

## Binary Search Tree

Patients are organized according to Patient ID.

Smaller Patient IDs are stored in the left subtree, while larger Patient IDs are stored in the right subtree.

In-order traversal displays patients in ascending order of Patient ID.

## Queue

The emergency queue follows FIFO - First In, First Out.

The first patient added to the queue is the first patient removed for treatment.

## Stack

The treatment history follows LIFO - Last In, First Out.

The latest treatment record is removed first.

## Singly Linked List

Each patient's visit history is stored as connected nodes.

Each node contains a visit record and a reference to the next visit.

---

# Testing

The following operations were tested:

- Patient registration
- BST insertion
- BST search
- BST deletion
- BST in-order traversal
- Queue enqueue
- Queue dequeue
- Queue display
- Empty queue handling
- Stack push
- Stack pop
- Stack display
- Empty stack handling
- Add patient visit
- Search patient visit
- Remove patient visit
- Display patient visit history

---

# Learning Outcomes

Through this project, I learned how different data structures can be used to solve real-world problems.

I gained practical experience with:

- Binary Search Trees
- Queue operations
- Stack operations
- Singly Linked Lists
- Java classes and objects
- Nodes and references
- Menu-driven applications
- Testing and debugging
- GitHub version control

---

# Author

**Hansa Fawzer**  
**23DA2-0480**

CIT300 - Data Structures and Algorithms