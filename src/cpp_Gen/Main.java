package cpp_Gen;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
	public static String className = "Cat";
	public static String AuthorName = "Joshua Anderson";
	public static final String topComment = "/*\n* THIS FILE WAS GENERATED BY JOSHUA ANDERSON's AUTO CPP GEN APP\n* Author: " + AuthorName + "\n* Date Created: " + LocalDate.now().toString() + "\n" + "*/ \n";
	
	
	public static void main(String[] args) {
		ArrayList<Var> AttributeList = new ArrayList<Var>();
		ArrayList<Function> Functions = new ArrayList<Function>();
		
		AttributeList.add(new Var("std::string", "name"));
		AttributeList.add(new Var("int", "age"));
		AttributeList.add(new Var("std::string", "owner"));
		
		Functions.add(new Constructor(className, AttributeList));
		Functions.add(new Function("void", "eat", className));
		Functions.get(1).addVar(new Var("int", "timeToEat"));
		Functions.get(1).addVar(new Var("std::string", "foodType"));

		writeToCpp(className, Functions);
		writeToH(className, AttributeList, Functions);
		
		//TODO: INCLUDES LIST

	}
	
	public static void writeToCpp(String className, ArrayList<Function> functions) {
		String content = "";
		content += topComment;
		content += "#include \"" + className + ".h\" \n\n\n";
		
		for(Function f : functions) {
			content += f.printCpp() + "\n\n";
		}
		
		content += "\n\n //Check out the code at: https://github.com/janderson2024/C-_File_Gen.git";
		write(className + ".cpp", content);
	}
	public static void writeToH(String className, ArrayList<Var> attributes, ArrayList<Function> funct) {
		String content = "";
		content += topComment;
		content += "#ifndef " + className + "_h\n#define " + className + "_h\n\n";
		content += "#include <iostream>\n#include <string>\n\n";
		content += "class " + className + " {\n";
		
		content += "\tprotected:\n";
		
		for(Var v : attributes) {
			content += "\t\t" + v.print(false) + ";\n";
		}
		
		content +="\tpublic:\n";
		
		for(Function f : funct) {
			content += "\t\t" + f.printH() + "\n";
		}
		
		
		content += "};\n#endif";
		content += "\n\n Check out the code at: https://github.com/janderson2024/C-_File_Gen.git";
		write(className + ".h", content);
	}
	
	public static void write(String destination, String content) {
		try {
			FileWriter writer = new FileWriter(destination);
			writer.write(content);
			writer.close();
			System.out.println("Wrote to: " + destination);
		} catch (IOException e) {
			System.out.println("Couldn't write");
		}
		
	}

}
