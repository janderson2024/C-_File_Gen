package cpp_Gen;

import java.util.ArrayList;

public class Constructor extends Function{

	public Constructor(String name, ArrayList<Var> atri) {
		super("", name, name);
		variables = atri;
	}
	
	private String functTop() {
		String start = name + "(";
		String varList = "";
		for(int i = 0; i < variables.size(); i++) {
			varList += variables.get(i).print(true);
			if(i+1 < variables.size()) {
				varList += ", ";
			}
		}
		String end = ")";
		return start + varList + end;
	}
	
	public String printH() {
		return functTop() + ";";
	}
	
	public String printCpp() {
		String start = className + "::" + functTop() + "{\n";
		String setters = "";
		for(var v : variables) {
			setters += "\t" + v.print(false) + " = " + v.print(true) + ";\n";
		}
		return start + setters + "}";
	}

}
