package com.hcp.datastructrue.sort;

/**
 * 对象排序（采用插入排序算法）
 * Created by Administrator on 2016/5/24.
 */

class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void displayPerson(){
        System.out.println(" Last name:" + lastName + ", First name:" + firstName + ", Age:" + age);
    }

    public String getLastName() {
        return lastName;
    }
}

class ArrayInsertObj{
    private Person[] a;
    private int nElems;

    public ArrayInsertObj(int max){
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age){
        a[nElems] = new Person(first, last, age);
        nElems ++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            a[i].displayPerson();
        }
        System.out.println();
    }

    public void insertionSort(){
        int in;
        for (int out = 1; out < nElems; out++) {
            Person p = a[out];
            in = out;
            // 用Person对象的LastName属性值按字母顺序排序
            while (in > 0 && a[in - 1].getLastName().compareTo(p.getLastName() ) > 0){
                a[in] = a[in - 1];
                -- in;
            }
            a[in] = p;

        }
    }
}

public class ObjectSort {
    public static void main(String[] args) {
        ArrayInsertObj arrObj = new ArrayInsertObj(10);
        arrObj.insert("A", "C", 12);
        arrObj.insert("E", "F", 12);
        arrObj.insert("B", "A", 12);
        arrObj.insert("AB", "W", 12);
        arrObj.insert("C", "A", 12);
        arrObj.insert("D", "ER", 12);
        arrObj.insert("F", "A", 12);
        arrObj.insert("Q", "DF", 12);
        arrObj.insert("W", "DF", 12);
        arrObj.insert("T", "DWF", 12);

        arrObj.display();

        arrObj.insertionSort();
        arrObj.display();
    }


}
