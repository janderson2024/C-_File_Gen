package cpp_Gen;

public class Var {
	String type;
	String name;
	
	public Var(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	
	public String print(boolean isConstruct) {
		if(isConstruct) {
			return type + " n_" + name;
		}else {
			return type + " " + name;
		}
	}
}
