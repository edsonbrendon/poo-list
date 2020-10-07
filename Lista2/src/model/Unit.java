package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Unit implements Serializable{
	
	public String name;
	public List<Client> contacts = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}