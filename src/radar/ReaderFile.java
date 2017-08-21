package radar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReaderFile {

	private static Map<String, Object> dataCamp;
	private static ArrayList<Integer> minePosX;
	private static ArrayList<Integer> minePosY;
	
	public static Map<String, Object> read(String file){
		dataCamp = new HashMap<>();
		minePosX = new ArrayList<>();
		minePosY = new ArrayList<>();
		
		Path path = Paths.get(file);  
		
		try(Scanner sc = new Scanner(Files.newBufferedReader(path))){
		    sc.useDelimiter("[ \n]");
			
		    dataCamp.put("weight", sc.nextInt());
		    dataCamp.put("height", sc.nextInt());
		    dataCamp.put("totalMines", sc.nextInt());

			while(sc.hasNext()){
				minePosX.add(sc.nextInt());
				minePosY.add(sc.nextInt());
			}

			dataCamp.put("mineX", minePosX);
			dataCamp.put("mineY", minePosY);

			return dataCamp;
		} catch(IOException e){
			System.out.println(e.toString());
			System.out.println("CAUSED BY: \n"+e.getCause());
			return null;
		}
	}

}
