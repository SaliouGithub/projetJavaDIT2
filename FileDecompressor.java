import java.io.*;
import java.util.zip.*;

public class FileDecompressor {
    public void decompress(String fichierZip) {
        // Décompression du fichier zip
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(fichierZip))) {
            ZipEntry entry;
            byte[] buffer = new byte[1024];
            int length;

            while ((entry = zip.getNextEntry()) != null) {
                String fileName = entry.getName();
                FileOutputStream output = new FileOutputStream(fileName);

                while ((length = zip.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                output.close();
                zip.closeEntry();

                // Message de confirmation
                System.out.println(fileName + " a été décompressé.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






