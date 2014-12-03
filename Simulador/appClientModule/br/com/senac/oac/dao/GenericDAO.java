/**
 * 
 */
package br.com.senac.oac.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Acessa o arquivo .lmq
 */
public class GenericDAO {

	/**
	 * @category GenericDAO
	 * @deprecated Acessa o arquivo e recupera as informações gravadas no mesmo.
	 * @code public List<String> readFile(){}
	 * @return List<String>
	 */
	public List<String> readFile(File file){
		
		BufferedReader br;
		List<String> list = new ArrayList<String>();
		
		try{
			br = new BufferedReader(new FileReader(file));
			//percorre o arquivo e injeta no List
			while (br.ready())
				list.add(br.readLine());
				
			br.close();//close leitura file
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
