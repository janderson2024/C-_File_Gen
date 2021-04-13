package cpp_Gen;


import java.util.ArrayList;

public class Function {
	String name;
	String returnType;
	String className;
	ArrayList<Var> variables;
	
	public Function(String returnType, String name, String className) {
		this.name = name;
		this.returnType = returnType;
		this.className = className;
		variables = new ArrayList<Var>();
	}
	
	public void addVar(Var var) {
		variables.add(var);
	}
	
	private String functTop() {
		String start = name + "(";
		String varList = "";
		for(int i = 0; i < variables.size(); i++) {
			varList += variables.get(i).print(false);
			if(i+1 < variables.size()) {
				varList += ", ";
			}
		}
		String end = ")";
		return start + varList + end;
	}
	
	public String printH() {
		return returnType + " " + functTop() + ";";
	}
	public String printCpp() {
		return returnType + " " + className + "::" + functTop() + "{\n\n}";
	}
}
