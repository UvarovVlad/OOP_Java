package com.tasks5.command;

public class Help implements Command{
  public void execute() {
	   System.out.println("Help executed");
   }
}
package com.tasks5.command;
public class Echo implements Command{
	
	private String text;
	
	Echo(String text){
		this.text=text;
			}
	public void execute() {
		System.out.println(text);
	}

}
package com.tasks5.command;
public class Date implements Command {
	public void execute() {
		System.out.println(System.currentTimeMillis());
	}

}
package com.tasks5.command;
public class Exit implements Command{
	public void execute() {
		System.out.println("Goodbye!");
	}

}
package com.tasks5.command;

public class Application {

	public static void main(String[] args) {
		if(args==null || args.length>2 || args.length==0) {
			System.out.println("Error");
			return;
		}
		if("help".equals(args[0]) && args.length==1){
			Help nano=new Help();
			nano.execute();
		}
		else if("echo".equals(args[0]) && args.length==2) {
			Echo nano=new Echo(args[1]) ;
			nano.execute();
		}
		else if(args.length==2 && "date".equals(args[0]) && "now".equals(args[1])){
			Date nano=new Date();
			nano.execute();
		}
		else if(args.length==1 && "exit".equals(args[0])) {
			Exit nano=new Exit();
			nano.execute();
			
		}
		else {
			System.out.println("Error");
		}
		
	}
}