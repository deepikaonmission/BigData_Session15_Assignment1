//<<<<<<<-------------------- TASK 2 -------------------->>>>>>>

//Write a simple program to show multiple inheritance in scala.

/* NOTE:-
1. class Student
 data member: rollno
 methods: get_rollno(), show_rollno()
2. trait Test
 data members: sub1, sub2
 methods: get_marks(), show_marks()
3. trait Sports
 data member: score
 methods: get_score(), show_score()
4. class Result extends Student with Test with Sports
 data member: total
 methods: get_details, cal_result(), show_details()

->> In multiple inheritance atleast a class needs to be extended and then multiple traits can be inherited with "with" clause
->> If a class tries to inherit multiple traits with "with" clause without extending a class then compiler won't allow this
->> here all fields and methods of Student class and Test and Sports Traits are public by default, therefore can be accessed inside sub-class

->> In this program only one object is created, array of objects can be created in the same way as created in Task1 program of this assignment
 */


import scala.io.StdIn._       //as readInt() and readFloat() methods are used in this program, so import of this statement is required

class Student{                //Student class gets rollno and shows rollno
  var rollno:Int = 0
  def get_rollno() ={
    println("Enter your roll no : ")
    rollno = readInt()          //prompts user for input at run time
  }
  def show_rollno()={
    println("Roll No : " +rollno)
  }
}

trait Test{                 //Test trait gets marks and shows marks
  var sub1:Float = 0.0f
  var sub2:Float = 0.0f
  def get_marks()={
    println("Enter your marks in Subject 1 : ")
    sub1 = readFloat()           //prompts user for input at run time
    println("Enter your marks in Subject 2 : ")
    sub2 = readFloat()          //prompts user for input at run time
  }
  def show_marks()={
    println("Marks in Subject 1 : " + sub1)
    println("Marks in Subject 2 : " + sub2)
  }
}

trait Sports{                      //Sports trait gets score and shows score
  var score:Float = 0.0f
  def get_score()={
    println("Enter your marks in Sports Subject : ")
    score = readFloat()          //prompts user for input at run time
  }
  def show_score()={
    println("Marks in Sports : " + score)
  }
}

class Result extends Student with Test with Sports{     //Result class extends and inherits Student class and inherits the features of Test and Sports Trait with "with" clause
  var total:Float = 0.0f
  def get_details()={         //get method calls get methods of Student Class, Test and Sports traits
    get_rollno()
    get_marks()
    get_score()
  }
  def cal_result()={
    total = sub1 + sub2 +score      //total marks are calculated
  }
  def show_details()={       //this method calls show methods of Student class and Test, Sports Traits
    show_rollno()
    show_marks()
    show_score()
    cal_result()            //calls cal_result() method
    println("Your total score is : "+total)
  }
}

object ResultCalculation extends App{       //singleton class is created which extends App trait so inherits main() method
  var ob = new Result    //Object of Result class is created
  ob.get_details()      //get_details method of Result class is called
  println("\n<<<<<<<------ Your details are as follows ------>>>>>>>\n")
  ob.show_details()     //show_details method of Result class is called
}