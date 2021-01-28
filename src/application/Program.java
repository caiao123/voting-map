package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Integer> record = new LinkedHashMap<>();
		String path = ".\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if (record.containsKey(name)) {
					int votesSoFar = record.get(name);
					record.put(name, count + votesSoFar);
				}
				else {
					record.put(name, count);
				}
				
				line = br.readLine();
			}
			
			//System.out.println(record.size());
			
			for (String key : record.keySet()) {
				System.out.println(key + ": " + record.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
