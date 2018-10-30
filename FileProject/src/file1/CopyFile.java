package file1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
	
	
	public static void main(String[] args) throws Exception {
		findFile("D:\\Java\\JavaWorkspace\\JavaBasicWorkspace","D:\\testFile\\");
	}
	
	
	
	public static void findFile(String path,String newPath) throws Exception {
		File file = new File(path);
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File f:files) {
				findFile(f.getAbsolutePath(),newPath);
			}
		}else if(file.getName().endsWith(".java")) {
			copy(file.getAbsolutePath(),newPath);
		}
	}
	
	
	public static void copy(String oldPath,String newPath) throws Exception {
		File oldFile = new File(oldPath);
		System.out.println(oldFile.getPath());
		System.out.println(oldFile.getName());
		File dir = new File(newPath);
		File newFile = new File(newPath+oldFile.getName());
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(oldFile.exists()) {
			InputStream in = new FileInputStream(oldFile);
			OutputStream out = new FileOutputStream(newFile,true);
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length=in.read(buffer))!=-1) {
				out.write(buffer,0,length);
			}
			in.close();
			out.close();
		}
	}
}
