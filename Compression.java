import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.IOException;

public class Compression {
public static void compresserFichiers(String nomArchive, String[] fichiers) throws IOException {
byte[] buffer = new byte[1024];
int length;
try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(nomArchive))) {
    for (int i = 1; i < fichiers.length; i++) {
        String fichier = fichiers[i];
        FileInputStream input = new FileInputStream(fichier);
        ZipEntry entry = new ZipEntry(fichier);
        zip.putNextEntry(entry);
        while ((length = input.read(buffer)) > 0) {
            zip.write(buffer, 0, length);
        }
        zip.closeEntry();
        input.close();
    }
}
}
}
