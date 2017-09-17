package radar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ReaderFile {

	private static Map<String, Object> dataCamp;
	private static Map<Integer, Integer> mines;
	
	public static Map<String, Object> read(String file){
		dataCamp = new HashMap<>();
		mines = new TreeMap<>();
		int x, y;
		Path path = Paths.get(file);
		
		try(Scanner sc = new Scanner(Files.newBufferedReader(path))) {
		    sc.useDelimiter("[ \n]");

		    dataCamp.put("weight", sc.nextInt());
		    dataCamp.put("height", sc.nextInt());
		    dataCamp.put("totalMines", sc.nextInt());

			while(sc.hasNext()){
				x = sc.nextInt();
				y = sc.nextInt();
				mines.put(x, y);
			}

			dataCamp.put("mines", mines);

			return dataCamp;
		} catch(IOException e){
			System.out.println(e.toString());
			System.out.println("CAUSED BY: \n"+e.getCause());
			return null;
		}
	}

}