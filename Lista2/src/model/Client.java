package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Client implements Serializable{
	
	// Atributos
	public String name;
	public String telephone;
	public String address;
	public String cpf;
	public List<Vehicle> vehicles = new ArrayList<>();
	
	// Metódos
	
	// Nome
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// Telefone
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// Endereço
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	// CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return  "Nome: " + name + 
				"\nTelefone: " + telephone + 
				"\nEndereço: " + address + 
				"\nCPF: " + cpf +
				"\nVeiculos: " + vehicles;
	}
}


