package story;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DocToDocxConverter {

    public static void main(String[] args) {
        String folderPath = "/Users/vah/Documents/小说/创作技巧/写作素材"; // 替换成你的起始目录
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("目录不存在或不是文件夹: " + folderPath);
            return;
        }

        processDirectory(folder);
    }

    // 递归处理目录下所有文件和子目录
    private static void processDirectory(File dir) {
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                processDirectory(file); // 递归子目录
            } else if (file.isFile() && file.getName().endsWith(".doc") && !file.getName().endsWith(".docx")) {
                convertToDocx(file);
            }
        }
    }

    private static void convertToDocx(File docFile) {
        String filePath = docFile.getAbsolutePath();
        System.out.println("转换: " + filePath);

        try {
            Process process = new ProcessBuilder(
                    "/Applications/LibreOffice.app/Contents/MacOS/soffice",
                    "--headless",
                    "--convert-to", "docx",
                    "--outdir", docFile.getParent(),
                    filePath
            ).start();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // 删除原始 .doc 文件
                if (docFile.delete()) {
                    System.out.println("已覆盖原文件: " + docFile.getName());
                } else {
                    System.err.println("无法删除原始文件: " + docFile.getName());
                }
            } else {
                System.err.println("转换失败: " + docFile.getName());
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("转换过程中出错: " + e.getMessage());
        }
    }
}
