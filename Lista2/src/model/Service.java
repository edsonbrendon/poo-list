package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Service implements Serializable{
	
	// Atributos
	public String name;
	public String date;
	public String hour;
	
	// Metódos
	
	// Data
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Data
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	// Hora
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
}
