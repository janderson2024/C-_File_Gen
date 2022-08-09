# C++_File_Gen

I made this project during my Comp Sci class to help speed up the repeative nature of creating new class .cpp and .h files. 

There are three main parts: The Attribute List, the Function List, and the calls to "writeToCpp" and "writeToH"

Attribute List is a list of Var's. A Var is a wrapper class that takes in a type and a name (both strings). 

In main is the code for a Cat class. it has 3 attributes: name of type std::string, age of type int, and owner of type std::string

Next is the Function Lists. This a list of Functions. A function is either a Constructor or a Function.
  * A constructor takes in the class name (string) and the Atrribute list
  * A function takes in the return type (string), the name of the function (string), and the  class name (string)
    * functions have their own Attribute list. You can add a function input variable by calling addVar(Var)
    
Finally writeToCpp handles writing the .cpp file and writeToH writes the .h file. 

Both will create their files in the cpp_Gen folder.
