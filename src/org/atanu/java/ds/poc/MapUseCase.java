package org.atanu.java.ds.poc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapUseCase {


    public static void main(String[] args) {

        Map<Employee , String> map = new HashMap<>();
        Employee employeeA = new Employee(1, "A");
        System.out.println("employeeA "+ employeeA.hashCode());
        Employee employeeB = new Employee(1, "A");
        System.out.println("employeeB "+ employeeB.hashCode());

        map.put(employeeA, "employeeA");
        map.put(employeeB, "employeeB");

        System.out.println(map.size());
        System.out.println(map.get(employeeA));
        System.out.println(map.get(employeeB));

        System.out.println(getCode());
    }

    public static int  getCode(){

        try {
            return 0;
        }catch (Exception e) {
            return 2;
        }finally {
            System.out.println("Hello");
        }
    }
    private static class Employee {

        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && Objects.equals(name, employee.name);
        }
    }
}
