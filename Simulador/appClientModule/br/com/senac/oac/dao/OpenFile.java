package br.com.senac.oac.dao;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.senac.oac.business.ProcessesFile;


@SuppressWarnings("serial")
public class OpenFile extends JFrame {

	private JTextArea outputArea;//para sa�da
	private JScrollPane scrollPane;//rolagem sa�da
	
	public OpenFile(){
		super("Simulador Assembly");
		
		outputArea = new JTextArea();
		
		scrollPane = new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		
		processs();
	}
	
	private File getFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		File fileName = fileChooser.getSelectedFile();
		
		if( (fileName == null) || (fileName.getName().equals("")) ){
			JOptionPane.showMessageDialog(this, "Nome inv�lido", "Nome inv�lido", JOptionPane.ERROR_MESSAGE);
			
			System.exit(1);
		}
		
		//valid type file (somente arquivos .lmq)
		if(!fileName.getName().substring(fileName.getName().length() - 4, fileName.getName().length()).equals(".lmq")){
			JOptionPane.showMessageDialog(
					this, "O arquivo "+ fileName.getName() 
					+" n�o � valido!", "Arquivo inv�lido", JOptionPane.ERROR_MESSAGE);
		
			System.exit(1);	
		}
		
		return fileName;
		
	}
	
	@SuppressWarnings("deprecation")
	private void processs(){
		File file = getFile();
		ProcessesFile proces = new ProcessesFile();
		
		proces.processaFile(file);
		System.exit(1);
	}
}
