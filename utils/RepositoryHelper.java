package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class RepositoryHelper {
    static private String BasePath = "temp";

    public static void Save(String info, String filename){
        Path path = Paths.get(BasePath, filename).toAbsolutePath();

        if(Files.exists(path)){
            info += "\n";
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

    public static String[] Load(String filename){
        filename += ".csv";
        Path path = Paths.get(BasePath, filename).toAbsolutePath();
        ArrayList<String> lines = new ArrayList<>();

        try{		
            InputStream stream = Files.newInputStream( path );			
            InputStreamReader ireader = new InputStreamReader(stream);		
            BufferedReader reader = new BufferedReader( ireader );				
                
                reader.lines().forEach((s)->{
                    lines.add(s);
                });									
                									
            stream.close();										
            ireader.close();											
            reader.close();	
        } catch (Exception e){
            return new String[]{};
        }

        return lines.toArray(new String[lines.size()]);
    }
}
