package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Client implements Serializable, Comparable<Client> {
    
	// Atributos
	public String name;
	public String telephone;
	public String date;
	public String gender;
	public List<String> services = new ArrayList<>();
	
	// Metódos
	
    // Nome
    public String getName(){ return name;}
    public void setName(String name){this.name = name;}
    
    // Telefone
    public String getTelephone(){return telephone;}
    public void setTelephone(String telephone){this.telephone = telephone;}
    
    // Data de Nascimento
    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}
    
    // Gênero
    public String getGender(){return gender;}
    public void setGender(String gender){this.gender = gender;}
    
	@Override
	public String toString() {
		return "Nome: " + name + 
				"\nTelefone: " + telephone + 
				"\nData de Nascimento: " + date + 
				"\nGênero: " + gender + 
				"\nServiços utilizados: " + services;
	}
	
	public int compareTo(Client other) {
		
		return name.compareTo(other.name);
	}
}
