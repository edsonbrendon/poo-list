package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Unit;

public class MyFile {
	
	String path = "data.ser";
	
	// Salva lista de unidades no arquivo
	public void save(List<Unit> unit) throws Exception {
		
		FileOutputStream f = new FileOutputStream(path);
		ObjectOutputStream write = new ObjectOutputStream(f);
		
		write.writeObject(unit);
		write.close();
	}
	
	// Carrega a lista de unidades do arquivo
	@SuppressWarnings("unchecked")
	public List<Unit> load() throws Exception {
		
		FileInputStream f = new FileInputStream(path);
		ObjectInputStream read = new ObjectInputStream(f);
		
		List<Unit> unit = (List<Unit>) read.readObject();
		read.close();
		
		return unit;
	}
}