package story;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Objects;

import org.mozilla.universalchardet.UniversalDetector;

/**
 * 文件编码转换
 */
public class TxtEncodingConverter {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/Users/vah/Documents/小说/创作技巧/高速下载- 【595】写作素材"; // 替换为你的路径
        convertFolderTxtFilesToUtf8(directoryPath);
    }

    public static void convertFolderTxtFilesToUtf8(String folderPath) throws IOException {
        Files.walk(Paths.get(folderPath))
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(TxtEncodingConverter::convertIfNotUtf8);
    }

    private static void convertIfNotUtf8(Path filePath) {
        try {
            String detectedEncoding = detectEncoding(filePath);
            if (!"UTF-8".equalsIgnoreCase(detectedEncoding)) {
                System.out.println("Converting file: " + filePath + " from " + detectedEncoding + " to UTF-8");
                // 读取原内容
                String content = readFile(filePath, detectedEncoding);
                // 写回 UTF-8
                writeFile(filePath, content, StandardCharsets.UTF_8);
            } else {
                System.out.println("Already UTF-8: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Error processing file " + filePath + ": " + e.getMessage());
        }
    }

    private static String detectEncoding(Path filePath) throws IOException {
        byte[] buf = Files.readAllBytes(filePath);
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(buf, 0, buf.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        return encoding != null ? encoding : "UTF-8"; // fallback
    }

    private static String readFile(Path path, String encoding) throws IOException {
        return new String(Files.readAllBytes(path), Charset.forName(encoding));
    }

    private static void writeFile(Path path, String content, Charset charset) throws IOException {
        Files.write(path, content.getBytes(charset), StandardOpenOption.TRUNCATE_EXISTING);
    }
}
