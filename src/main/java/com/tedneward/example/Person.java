// Ethan McGregor
// 1/9/2017
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

  public Person() {
    this("", 0, 0.0d);
  }

  public Person(String n, int a, double s) {
	// adds count of person classes created
    if(this.getClass() == Person.class) {
      this.count++;
    }
	
    this.name = n;
    this.age = a;
    this.salary = s;
	this.ssn = "";
  }

  public int getAge() {
    return age;
  }
  
    public String getName() {
    return this.name;
  }

  public double getSalary() {
    return this.salary;
  }

  public String getSSN() {
    return this.ssn;
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
  
    public void setPropertyChangeFired(boolean propertyChangeFired) {
    this.propertyChangeFired = propertyChangeFired;
  }

  public int count() {
    return count;
  }

  @Override
  public int compareTo(Person anotherPerson) {
	  int compare = (int)this.salary - (int)anotherPerson.salary;
	  if(compare >= 1){
		  return -1;
	  }else if(compare == 0){
		  return 0;
	  }else{
		  return 1;
	  }
    
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> family = new ArrayList<Person>();
    family.add(new Person("Ted",41,250000.));
    family.add(new Person("Charlotte",43,150000.));
    family.add(new Person("Michael",22,10000.));
    family.add(new Person("Matthew",15,0.));
    return family;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return this.propertyChangeFired;

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
  public boolean equals(Object two) {
    if (two != null && getClass() == two.getClass()) {
       Person other = (Person) two;
       return this.getName().equals(other.getName()) && this.getAge() == other.getAge();
    } else  {
       return  false;
    }
  }

  @Override
public String toString() {
    return "[Person name:" + this.name + " age:" +this.age+ " salary:"+this.salary+"]";
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
  static class AgeComparator implements Comparator<Person>{
	public int compare(Person element1,Person element2){
		if(element1.getAge() < element2.getAge()){
			return -1;
		}
		else{
			if(element1.getAge() > element2.getAge()){
				return 1;
			}
			else{
				return 0;
			}
		} 
	}
}
}