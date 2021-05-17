package com.automation.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.automation.CustomisedExceptions.FrameworkExceptions;

public class TextReader {
	
	private String filepath;
	private File file;
	private FileWriter FW;
	private BufferedWriter BW;
	private FileReader FR;
	private BufferedReader BR;
	
	
	public TextReader(String filepath) throws IOException
	{
		this.filepath=filepath;
		file = new File(filepath);
		FW= new FileWriter(file);
		BW= new BufferedWriter(FW);
		FR= new FileReader(file);
		BR= new BufferedReader(FR);
	}
	
	public String getText() throws IOException, FrameworkExceptions {

		String TXT;
		if(BR!=null)
		{
			 TXT=BR.readLine();
		}
		else
		{
			FrameworkExceptions FW= new FrameworkExceptions("Text File is Null");
			throw FW;
		}
		return TXT;
	}
	
	public List<String> GetTotalData() throws IOException
	{
		List<String> Data= new ArrayList<String>();
		if(BR!=null)
		{
		while(BR.ready())
			{
			String DATA =BR.readLine();
			Data.add(DATA);
			}
		}
		return Data;
		
	}
	
	
	
	
	
}
