package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ahmet", "Ahm"));
        employees.add(new Employee(2, "Onur", "Onu"));
        employees.add(new Employee(3, "Ayşe", "Ays"));
        employees.add(new Employee(4, "Fatma", "Fat"));
        employees.add(new Employee(1, "Ahmet", "Ahm"));
        employees.add(new Employee(5, "Ali", "Ali"));
        employees.add(new Employee(3, "Ayşe", "Ays"));
        employees.add(new Employee(6, "Zeynep", "Zey"));
        employees.add(new Employee(2, "Onur", "Onu"));
        employees.add(new Employee(7, "Elif", "Eli"));
        System.out.println("Duplicates: ");
        findDuplicates(employees).forEach(System.out::println);
        System.out.println("Uniques: ");
        findUniques(employees).values().forEach(System.out::println);
        System.out.println("Removing Duplicates: ");
        removeDuplicates(employees).forEach(System.out::println);
        }
    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();
        Iterator<Employee> iter = employees.iterator();
        while(iter.hasNext()){
            Employee employee = iter.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicates.add(employee);
            }else{
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicates;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(duplicates);
        return onlyUniques;
    }
}