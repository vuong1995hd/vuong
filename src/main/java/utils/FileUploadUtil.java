package utils;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

public class FileUploadUtil {
    public static String uploadFile(Part filePart, String uploadPath) throws IOException {
        String fileName = extractFileName(filePart);
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
        return fileName;
    }

    private static String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String content : contentDisposition.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
