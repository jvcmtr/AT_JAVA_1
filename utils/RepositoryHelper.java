package combat;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class RepositoryHelper {
    static private String BasePath = "temp";

    static void Save(String info, String filename){
        Path path = Paths.get(BasePath, filename).toAbsolutePath();
        

        if(Files.exists(path)){
            try{
                Files.write(path, info.getBytes(), StandardOpenOption.APPEND);
            } catch(Exception e){
                System.out.println(" ### ERRO !!!");
                System.out.println(e.getMessage());
            }
        }
        else{
            try{
                Files.write(path, "".getBytes(), StandardOpenOption.CREATE);
            } catch (Exception e){
                
                System.out.println(" # ERRO !!!");
                System.out.println(e);
            }

            Save(info, filename);
        }
        
    }
}
