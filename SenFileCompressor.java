import java.io.IOException;
public class SenFileCompressor{

    public static void main(String[] args)  throws IOException {
        if (args.length == 0 || args[0].equals("-h") ||  args[0].equals("--help")) {
            Aide();
            return;
        }
        String option = args[0];
        switch (option) {
            case "-c":
            
            if (args.length < 2 ) {
                System.out.println("Erreur : spécifiez au moins un fichier à compresser.");
                Aide();
                return;
            }     
            String nomArchive = "archive.sfc";
            Compression.compresserFichiers(nomArchive, args);
        
            System.out.println("Les fichiers ont été archivés dans " + nomArchive);

            // else if (args.length >= 2) {
            //     String optionR = args[1];
            //     if(optionR.equals("-r")){
            //         String chemin = args[2];
            //         System.out.println("option r");
            //         System.out.println("chemin: " + chemin);
            //     }

            //     }

                break;

            case "-d":
                if (args.length != 2) {
                    System.out.println("Erreur : spécifiez le fichier à décompresser.");
                    Aide();
                    return;
                }

                if (args.length != 2) {
                    System.out.println("Usage: java DecompressionFile fichierZip");
                    return;
                }
                String fichierZip = args[1];
                FileDecompressor decompressor = new FileDecompressor();
                decompressor.decompress(fichierZip);
             
                break;

            default:
                System.out.println("Error");
                Aide();
        }



        // String optionR = args[1];
        // if(optionR.equals("-r")){
        //     String chemin = args[2];
        //     System.out.println("chemin :"+chemin);

        // }else

        // if(args.length == 2){
        //     System.out.println("args.length = 2");
        // }
        // else if(args.length == 1){
        //     // if(option.equals("-h") || option.equals("--help")){
        //     //     System.out.println("Compression     : java SenFileCompressor –c <liste fichier à compresser>");   
        //     //     System.out.println("Decompression   : java SenFileCompressor –d fichierADecompresser.sfc");   
        //     //     System.out.println("Help            : java SenFileCompressor –h");   
        //     // }else{
        //     //     System.out.println("autre option");
        //     // }
        // }
    }

    private static void Aide() {
        System.out.println("Utilisation : java SenFileCompressor [-h | -c files... | -d archive.zip]");
        System.out.println("-h : Affiche l'aide.");
        System.out.println("-c files... : Compresse les fichiers donnés en entrée.");
        System.out.println("-d archive : Décompresse l'archive donnée en entrée.");
        System.out.println("-r chemin : spécifier le chemin (absolu ou relatif) vers le répertoire de stockage des fichiers (ou du fichier).");
    }

}




