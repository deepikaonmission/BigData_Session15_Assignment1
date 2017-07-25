//<<<<<<<-------------------- TASK 1 -------------------->>>>>>>

//Write a simple program to show inheritance in scala.

/*Note:- Hierarchical Inheritance is used as an example (one base class and multiple sub-classes)
1. An abstract class "Employee" is created which contains three data members (fields) and two methods without definition
Abstract class is created because there is no need to create object of such class.
2. Two sub-classes of abstract class "Employee" are created "FullTimeEmployee" and "PartTimeEmployee"
3. Here both subclasses need to override methods of Employee (Abstract) class else error is thrown at run-time
4. The differences between two subclasses are as follows:
FullTimeEmployee subclass:
-> It inherits all fields and methods of base class as they all are public by default in base class, and it has its own
data member (field) i.e. "salary" which is paid on monthly basis
-> Full Time employees are provided other perks like health insurance, paid-time off etc.
PartTimeEmployee subclass:
-> It inherits all fields of base class, and it has its own data member (field) i.e. "wages" which is paid on hour basis
-> Part Time employees are not provided any perks

 */

import scala.io.StdIn._         //since readLine(), readInt() methods are used so this import statement is required
abstract class Employee {      //Base Abstract Class
  var ename:String = ""          //Initialized to empty string
  var eid: Int = 0               //Initialized to Integer value 0
  var dept:String = ""           //Initialized to empty string
  def getDetails()               //method declaration, definition must be provided by subclass
  def showDetails()              //method declaration, definition must be provided by subclass
}

class FullTimeEmployee extends Employee{      //Subclass extends superclass
  var salary:Int = 0                          //subclass's own data member
  override def getDetails() ={                //overrides method of super class by specifying keyword "override" else error is thrown
    println("Enter name : ")
    ename = readLine()                        //Prompts user for input String, readLine() method takes whole line as input
    println("Enter employee id : ")
    eid = readInt()                            //Prompts user for input integer
    println("Enter department : ")
    dept = readLine()
    println("Enter salary : ")
    salary = readInt()
  }
  override def showDetails() ={               //overrides method of super class by specifying keyword "override" else error is thrown
    println("Name : " + ename)
    println("Employee ID : " + eid)
    println("Department : " + dept)
    println("Salary  : " + salary)
    println("Other perks offered to full time employee are as follows : \n->>Health Insurance\n->>Paid-Time off\n->>Other Reimbursement (Childcare, Fitness")
  }
}

class PartTimeEmployee extends Employee{          //other subclass extends super class
  var wages:Int = 0                               //subclass's own data member
  override def getDetails() ={                  //overrides method of super class by specifying keyword "override" else error is thrown
    println("Enter name : ")
    ename = readLine()
    println("Enter employee id : ")
    eid = readInt()
    println("Enter department : ")
    dept = readLine()
    println("Enter wages received per hour : ")
    wages = readInt()
  }
  override def showDetails() ={                  //overrides method of super class by specifying keyword "override" else error is thrown
    println("Name : " + ename)
    println("Employee ID : " + eid)
    println("Department : " + dept)
    println("Wages per hour  : " + wages)
    println("No other perks are offered to part time employee")
  }
}

object InheritanceExample extends App{          //singleton object class is created which extends App trait and inherits main() method
  var obFT = new Array[FullTimeEmployee](2)      //array of objects of size 2 is created of type FullTimeEmployee
  for(ob <- 0 until obFT.length){                //for loop is used to initialize and access methods of each object of FullTimeEmployee class
    obFT(ob) = new FullTimeEmployee        //if obFT(0) and obFT(1) are not initialized then NullPointerException is thrown at run time
    println(s"\n<<<<<<<------ Please enter following details for full time employee $ob----->>>>>>")
    obFT(ob).getDetails()                  //in first loop obFT(0) is used to call getDetails method for 0th object and in second loop obFT(1) is used to call getDetails method for 1st object
    println(s"<<<<<<<------ Details of Full-Time employee $ob are as follows ----->>>>>>")
    obFT(ob).showDetails()         //in first loop obFT(0) is used to call showDetails method for 0th object and in second loop obFT(1) is used to call showDetails method for 1st object
    ob+1           //val variable ob is added with 1 to access other object
  }

  var obPT = new Array[PartTimeEmployee](2)      //Same description as done for FullTimeEmployee
  println(obPT.length)
  for(ob <- 0 to (obPT.length-1)){               //from 0 to 1 less than length of obPT for loop will run
    obPT(ob) = new PartTimeEmployee        //if obPT(0) and obPT(1) are not initialized then NullPointerException is thrown at run time
    println(s"\n<<<<<<<------ Please enter following details for part time employee $ob----->>>>>>")
    obPT(ob).getDetails()
    println(s"<<<<<<<------ Details of Part-Time employee $ob are as follows ----->>>>>>")
    obPT(ob).showDetails()
    ob+1
  }


}


/*        no array of object is created, each object is created per line
object InheritanceExample extends App{
  var ob1 = new FullTimeEmployee
  var ob2 = new FullTimeEmployee

  ob1.getDetails()
  ob1.showDetails()

  ob2.getDetails()
  ob2.showDetails()

  var ob3 = new PartTimeEmployee
  var ob4 = new PartTimeEmployee

  ob3.getDetails()
  ob3.showDetails()

  ob4.getDetails()
  ob4.showDetails()

}*/
