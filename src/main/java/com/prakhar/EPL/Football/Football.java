package com.prakhar.EPL.Football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * program to print the name of the team with the smallest 
 * difference in ‘for’ and ‘against’ goals with enough ways 
 * to make sure the expected behaviour is achieved.
 *
 *@author Prakhar Srivastava
 *@version 1.0.0
 *
 */
public class Football 
{
	public static String line;

	/*private static void columnsToArrayList(String ForOrAgainst) {
		// TODO Auto-generated method stub
		List<String> FOR = new ArrayList();
		
	}*/

	@SuppressWarnings("unused")
	public static String readfile(String filename) throws IOException {

			/*FileReader file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);*/
		
		FileReader file = new FileReader(filename);
		BufferedReader br = new BufferedReader(file);
		
		
			String [] columns;
			List<String> f = new ArrayList<String>();
			List<String> a = new ArrayList<String>();
			Map<Integer,String> team = new HashMap<Integer,String>();
			List<String> nameOfTeam = new ArrayList<String>();
			
			
			//ignore Line 1 which has the headers
			br.readLine();
			
			//Loop to add the elements in an array.
			while ((line = br.readLine())!=null)
			//	while (sc.hasNext())
			{
			//creating consistency in the line
			line = line.replaceAll("  *", " ");
			//remove all whitespaces from front and end
			line = line.trim();
			//Save the elements into an array.
			columns = line.split(" ");
			//save the for number into arraylist
			f.add(columns[6]);
			//Save the against into arraylist
			a.add(columns[8]);
			//Save the team names into arrayList
			nameOfTeam.add(columns[1]);
			
			}
			br.close();
		
			//Call the method to find the min diff in for and against
			String teamname = Football.getTeamName(f,a,nameOfTeam,team);
			
		return teamname;
	}

	public static String getTeamName(List<String> f, List<String> a, List<String> nameOfTeam, Map<Integer,String> team) {
		int min = 1000,diff = 0;
		for (int i = 0 ;i < f.size();  i++){
			int fr = Integer.parseInt(f.get(i));
			int ag = Integer.parseInt(a.get(i));
			
			if (fr>ag)
				diff=fr-ag;
			else
				diff = ag-fr;
			
			if (min<diff)
				min=min;
			else min=diff;
			team.put(diff, nameOfTeam.get(i));			
		}
		
		return team.get(min);
	}
	
}

	
        
    

