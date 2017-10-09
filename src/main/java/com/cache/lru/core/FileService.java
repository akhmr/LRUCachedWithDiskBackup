package com.cache.lru.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

	private final static String DEFAULT_DIR_PATH = "opt/cache/";

	public FileService(String filePath) {

		if (filePath == null || "".equalsIgnoreCase(filePath)) {
			filePath = DEFAULT_DIR_PATH;
		}

		Path path = Paths.get(filePath);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean writeBytesToFile(byte[] bFile, String fileName) {
        try {
            Path path = Paths.get(buildFilePath(fileName));
            Files.write(path, bFile);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

	private static String buildFilePath(String fileName) {
		StringBuilder sb= new StringBuilder(DEFAULT_DIR_PATH);
		sb.append(fileName);
		return sb.toString();
	}

}
