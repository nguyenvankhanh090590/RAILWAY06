package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileManager {
	public static final String FILE_EXISTS = "File Exists!";
	public static final String FILE_NOT_EXISTS = "Error! File Does Not Exist";
	public static final String FOLDER_EXISTS = "Folder Exits!";
	public static final String FOLDER_NOT_EXISTS = "Folder Does Not Exist!";
	public static final String PATH_NOT_FOLDER = "Error! Path Is Not A Folder";
	public static final String SOURCE_FILE_NOT_EXISTS = "Source File Does Not Exist!";
	public static final String DESTINATION_FILE_EXISTS = "Destination File Exists!";
	public static final String NEW_FILE_EXISTS = "Error! New File Exists";
	public static final String CREATE_FILE_SUCCESS = "Create File Successfully!";
	public static final String CREATE_FILE_FAIL = "Fail To Create File !";
	public static final String DELETE_FILE_SUCCESS = "Delete File Successfully!";
	public static final String DELETE_FILE_FAIL = "Fail To Delete File!";

	// Check file if exists
	public static boolean isFileExists(String pathFile) {
		if (new File(pathFile).exists()) {
			return new File(pathFile).isDirectory() ? false : true;
		} else {
			return false;
		}
	}
	
	// Check folder if exists
	public static boolean isFolderExists(String pathFolder) {
		return new File(pathFolder).isDirectory() ? true : false;
	}

	// Create file
	public static void createNewFile(String pathFile) throws Exception {
		if (isFileExists(pathFile)) {
			throw new Exception(FILE_EXISTS);
		}
		boolean result = new File(pathFile).createNewFile();
		System.out.println(result ? CREATE_FILE_SUCCESS : CREATE_FILE_FAIL);
	}

	public static void createNewFile(String path, String fileName) throws Exception {
		String pathFile = path + "//" + fileName;
		createNewFile(pathFile);
	}
	
	// Delete file
	public static void deleteFile(String pathFile) throws Exception {
		if (!isFileExists(pathFile)) {
			throw new Exception(FILE_NOT_EXISTS);
		}
		boolean result = new File(pathFile).delete();
		System.out.println(result ? DELETE_FILE_SUCCESS : DELETE_FILE_FAIL);
	}

	// Check path is File or Folder
	public static String FolderOrFile(String pathFile) {
		boolean bl = new File(pathFile).isDirectory();
		return bl ? "Folder":"File";
	}
		
	// Check is Folder
	public static boolean isFolder(String pathFile) {
		return new File(pathFile).isDirectory();
	}
		
	// Get all file name of folder
	public static List<String> getAllFileName(String path) throws Exception {
		File file = new File(path);
		if (!isFolder(path)) {
			throw new Exception(PATH_NOT_FOLDER);
		}
		return Arrays.asList(file.list());
	}

	// Copy File
	public static void copyFile(String sourceFile, String destinationPath) throws Exception {
		File source = new File(sourceFile);
		File dest = new File(destinationPath);
		try {
			Path result = Files.copy(source.toPath(), dest.toPath());
			System.out.println(result.toString());
		} catch (Exception e) {
			System.out.println("Copy Fail");
		}
	}
	
	// Copy File
	public static void copyFile(String sourceFile, String destinationPath, String newName) throws Exception {
		File source = new File(sourceFile);
		File dest = new File(destinationPath + "//" + newName);
		try {
			Path result = Files.copy(source.toPath(), dest.toPath());
			System.out.println(result.toString());
		} catch (Exception e) {
			System.out.println("Copy Fail");
		}
	}
	
	// Moving file
	public static void moveFile(String sourceFile, String destinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		File source = new File(sourceFile);
		File dest = new File(destinationPath);
		Files.move(source.toPath(), dest.toPath());
		System.out.println("success");
	}
	
	// Rename File
	public static void renameFile(String pathFile, String newName) throws Exception {
		if (!isFileExists(pathFile)) {
			throw new Exception(FILE_NOT_EXISTS);
		}
		if (isFileExists(newName)) {
			throw new Exception(NEW_FILE_EXISTS);
		}
		File oldFile = new File(pathFile);
		File newFile = new File(newName);
		oldFile.renameTo(newFile);
		System.out.println("success");
	}
	
	// Create New Folder
	public static void createNewFolder(String newPathFolder) throws Exception {
		if (isFolderExists(newPathFolder)) {
			throw new Exception(FOLDER_EXISTS);
		} else {
		new File(newPathFolder).mkdir();
		}
	}
	
	// Download file
	public static void downloadFile(String fileLink, String pathFolder) throws Exception {
		if (!isFolderExists(pathFolder)) {
			createNewFolder(pathFolder);
		}
		// get name file
		String s[] = fileLink.split("/");
		String name = s[s.length - 1];
		String pathFile = pathFolder + "/" + name;
		// connect to URL
		URL url = new URL(fileLink);
		URLConnection connection = url.openConnection();
		// get size of file
		int size = connection.getContentLength();
		// read file from internet
		InputStream inputStream = connection.getInputStream();
		// save file
		FileOutputStream output = new FileOutputStream(pathFile);
		int byteDownload = 0;
		byte[] b = new byte[1024];
		// get length
		int length = inputStream.read(b);
		while (length != -1) {
			byteDownload += length;
			System.out.println(byteDownload * 100f / size + "%");
			// write content downloaded from 0 -> length to ouput
			output.write(b, 0, length);
			length = inputStream.read(b);
		}
		// close
		output.close();
		inputStream.close();
		System.out.println("Download success");
	}
}
