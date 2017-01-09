package com.tedneward.example;



import java.beans.*;

import java.util.*;



public class Person implements Comparable<Person> {

  private int age;

  private String name;

  private double salary;

  private String ssn;

  private boolean propertyChangeFired = false;

  private static int count;



  public static class AgeComparator implements Comparator<Person>{

    public int compare(Person p1,Person p2) {

      return p1.getAge() - p2.getAge();

    }

  }



  public Person() {

    this("", 0, 0.0d);

  }



  public Person(String n, int a, double s) {

    if(this.getClass() == Person.class) {

      count++;

    }

    name = n;

    age = a;

    salary = s;

    ssn ="";

  }



  public int getAge() {

    return age;

  }



  public void setAge(int age) {

    if(age < 0) {

      throw new IllegalArgumentException();

    }

    this.age = age;

  }





  public void setName(String name) {

    if(name == null) {

      throw new IllegalArgumentException();

    }

    this.name = name;

  }



  public void setSalary(double salary) {

    this.salary = salary;

  }



  public void setSsn(String value) {

    String old = ssn;

    ssn = value;



    this.pcs.firePropertyChange("ssn", old, value);

    propertyChangeFired = true;

  }

  public int count() {

    return count;

  }





  public void setPropertyChangeFired(boolean propertyChangeFired) {

    this.propertyChangeFired = propertyChangeFired;

  }



  @Override

  public int compareTo(Person o) {

    if(this.getSalary() > o.getSalary()) {

      return -1;

    } else if (this.getSalary() < o.getSalary()) {

      return  1;

    } else {

      return 0;

    }

  }



  public static ArrayList<Person> getNewardFamily() {

    ArrayList<Person> list = new ArrayList<Person>();

    list.add(new Person("Ted",41,250000.));

    list.add(new Person("Charlotte",43,150000.));

    list.add(new Person("Michael",22,10000.));

    list.add(new Person("Matthew",15,0.));

    return list;

  }







  public String getName() {

    return name;

  }



  public double getSalary() {

    return salary;

  }



  public String getSSN() {

    return ssn;

  }

  public void setSSN(String value) {

    String old = ssn;

    ssn = value;



    this.pcs.firePropertyChange("ssn", old, value);

    propertyChangeFired = true;

  }



  public boolean getPropertyChangeFired() {

    return propertyChangeFired;

  }



  public double calculateBonus() {

    return salary * 1.10;

  }



  public String becomeJudge() {

    return "The Honorable " + name;

  }



  public int timeWarp() {

    return age + 10;

  }





  @Override

  public boolean equals(Object o) {

    if (o != null && getClass() == o.getClass()) {

       Person other = (Person) o;

       return this.getName().equals(other.getName()) && this.getAge() == other.getAge();

    } else  {

       return  false;

    }





  }



  @Override

  public int hashCode() {

    int result = age;

    result = 31 * result + (name != null ? name.hashCode() : 0);

    return result;

  }



  @Override

  public String toString() {

    return new StringBuilder().append("[Person name:").append(getName()).append(" age:").append(getAge()).append(" salary:")

               .append(getSalary()).append("]").toString();

  }





  // PropertyChangeListener support; you shouldn't need to change any of

  // these two methods or the field

  //

  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public void addPropertyChangeListener(PropertyChangeListener listener) {

      this.pcs.addPropertyChangeListener(listener);

  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {

      this.pcs.removePropertyChangeListener(listener);

  }













}