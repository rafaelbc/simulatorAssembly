import br.com.senac.oac.bean.MemoriaDeRegistradores;
import br.com.senac.oac.bean.Registrador;
import br.com.senac.oac.business.ALU;
import br.com.senac.oac.business.Convert;
import br.com.senac.oac.business.ProcessesFile;
import br.com.senac.oac.dao.GenericDAO;


public class Main {
	public static void main(String[] args) {
		
		ProcessesFile process = new ProcessesFile();
		
		process.processaFile();
		
		
		
//		MemoriaDeRegistradores mem = new MemoriaDeRegistradores();
//		
//		for(Registrador r : mem.getRegistrador()){
//			System.out.printf("Representação: %d\nValor: %s\nRegistrador: %s\n", r.getRepresentacao(), r.getValor(), r.getRegistrador() );
//		}
		
			
		
	}

}