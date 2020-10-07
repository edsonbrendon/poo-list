package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Vehicle implements Serializable{
	
	// Atributos
	public String board;
	public String model;
	public String yearManufacture;
	public String price;
	public List<Service> services = new ArrayList<>();
	
	// Met�dos
	
	// Placa
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	
	// Modelo
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	// Ano de fabrica��o
	public String getYearManufacture() {
		return yearManufacture;
	}
	public void setYearManufacture(String yearManufacture) {
		this.yearManufacture = yearManufacture;
	}
	
	// Pre�o
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return  "Placa: " + board + 
				"\nModelo: " + model + 
				"\nAno de fabrica��o: " + yearManufacture + 
				"\nPre�o: " + price;
	}
}
