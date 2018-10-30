package file1;

import java.io.File;

public class FindFile {
	
	
	public static void main(String[] args) {
		File file = new File("D:\\Java\\JavaWorkspace\\JavaBasicWorkspace");
		findFile(file);
	}
	
	public static void findFile(File file) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File f:files) {
				findFile(f);
			}
		}else if(file.getName().endsWith(".java")) {
			System.out.println(file.getName());
		}
	}
	
}
