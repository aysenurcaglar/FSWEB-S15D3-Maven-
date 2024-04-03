package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Michael", "Jordan"));
        employees.add(new Employee(2, "LeBron", "James"));
        employees.add(new Employee(3, "Stephen", "Curry"));
        employees.add(new Employee(4, "Kevin", "Durant"));
        employees.add(new Employee(3, "Stephen", "Curry"));
        employees.add(new Employee(5, "Kobe", "Bryant"));
        employees.add(new Employee(2, "LeBron", "James"));

        System.out.println("Original list:");
        printList(employees);


        HashMap<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nList with duplicates removed:");
        printMap(uniques);

        List<Employee> uniqueList = removeDuplicates(employees);
        System.out.println("\nUnique map:");
        printList(uniqueList);


        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("\nDuplicate list:");
        printList(duplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> duplicateList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employeeMap.containsKey(employee.getId())) {
                duplicateList.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        return duplicateList;
    }

    public static HashMap<Integer, Employee> findUniques(List<Employee> list) {
        HashMap<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : list) {
            uniqueMap.put(employee.getId(), employee);
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> uniqueList = new LinkedList<>();
        HashMap<Integer, Employee> uniqueMap = findUniques(employees);
        List<Employee> duplicateList = findDuplicates(employees);

        for (Employee employee : uniqueMap.values()) {
            if (!duplicateList.contains(employee)) {
                uniqueList.add(employee);
            }
        }

        return uniqueList;
    }

    public static void printList(List<Employee> list) {
        for (Employee employee : list) {
            System.out.println(employee.getId() + " - " + employee.getFirstname() + " " + employee.getLastname());
        }
    }

    public static void printMap(Map<Integer, Employee> map) {
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getFirstname() + " " + entry.getValue().getLastname());
        }
    }
}