package app;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Client;
import model.Unit;

public class App {

	public static void main(String[] args) throws Exception  {
		
		// Instancia uma lista de unidades
		List<Unit> units = new ArrayList<>();
		
		// Instância a classe MyFile
		MyFile file = new MyFile();
		
		// Pega a data e hora do sistema
        Date data = new Date(System.currentTimeMillis()); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
        
        // Pega o arquivo .ser
		File f = new File("data.ser");
		
		// Verifica se existe. se existir ele apenas carrega os dados.
		if(f.exists()) {
			units = file.load();
		}
       
        System.out.println("Grupo World Beauty (WB) " + formatarDate.format(data));
        
        while(true)
        {   
        	System.out.println("");
	        System.out.println("[1] Cadastrar unidade");
	        System.out.println("[2] Listar unidades");
	        System.out.println("[3] Acessar uma unidade");
	        System.out.println("[4] Sair");
        
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in); 
	        System.out.printf("\nSelecione uma opção: ");
	        String option = scan.next();  
	        
	        switch(option)
	        {
	        	// Cadastrar unidades
				case "1":
				{
					Unit u = new Unit();
					System.out.printf("Nome da unidade: ");
					u.name = scan.next().toLowerCase(); 
					
					units.add(u);
					file.save(units);
				}break;
				
				// Listar unidades
				case "2": 
				{					
					if(units.isEmpty()) {
						System.out.println("Nenhuma unidade encontrada.");
					}
					else {
						units.forEach(u -> System.out.println(u));
					}
				}break;
				
				// Acessar uma unidade
	            case "3":
	            {
	            	if(units.isEmpty()) 
	            	{
						System.out.println("Nenhuma unidade encontrada, por favor cadastre uma unidade para continuar.");
					}
					else 
					{
		            	System.out.println("Insira a unidade:");
						String unit = scan.next().toLowerCase();
						
						for(int i = 0; i < units.size(); i++) {
							
							Unit u = units.get(i);
	
							if(u.getName().toLowerCase().equals(unit)) {
								
						        while(true)
						        {  
				                
									System.out.println("");
									System.out.println("Acessando com a unidade: " + u.getName());
					                System.out.println("Você possui " + u.contacts.size() + " cliente(s). \n");
							        
					                System.out.println("[1] Cadastrar cliente");
							        System.out.println("[2] Editar cliente");
							        System.out.println("[3] Remover cliente");
							        System.out.println("[4] Adicionar serviço");
							        System.out.println("[5] Listagem de todos os clientes em ordem alfabética");        
							        System.out.println("[6] Listar clientes por gênero");
							        System.out.println("[7] Idade média dos clientes.");
							        System.out.println("[8] Idade média para um determinado gênero.");
							        System.out.println("[9] Serviço mais procurado para todo o público");
							        System.out.println("[10] Serviço mais procurado para um determinado gênero");
							        System.out.println("[0] Sair");			        
	      
							        System.out.printf("\nSelecione uma opção: ");
							        String option2 = scan.next(); 
							        
							        switch(option2)
							        {
							        	// Adicionar cliente
							            case "1": 
							            {    
							            	Client contact = new Client();
							            	
							            	System.out.println("Nome: ");
											contact.name = scan.next();  
											
											System.out.println("Telefone: ");
											contact.telephone = scan.next();
											
											System.out.println("Data de nascimento (dd/mm/aaaa): ");
											contact.date = scan.next();
											
											do 
											{
												System.out.println("Gênero: \n [1] Masculiuno \n [2] Feminino");
												contact.gender = scan.next();	
											} while(Integer.parseInt(contact.gender) < 1 || Integer.parseInt(contact.gender) > 2);
											
											u.contacts.add(contact);    										
											file.save(units);
							                
							                System.out.println("Contato adicionado com sucesso!");
							            }break;
							            
							            // Editar cliente
							            case "2": 
							            {
							            	String name;
											String nameClient = "";
											
							            	System.out.println("Nome: ");
											name = scan.next();
											
											for(Client client: u.contacts) 
											{
												nameClient = client.getName();	
												
												if(nameClient.equals(name)) 
												{
													System.out.println(client);
													System.out.println("");
													System.out.println("Alterar este cliente?");
													System.out.println("[1] Sim");
													System.out.println("[2] Não");
													int resp = scan.nextInt();
													
													if (resp == 1) 
													{		
														System.out.println("[1] Editar nome.");
														System.out.println("[2] Editar telefone.");
														System.out.println("[3] Editar data de nascimento.");
														System.out.println("[4] Editar gênero.");
														System.out.println("[0] Sair");
														
														System.out.printf("Selecione uma opção:");
														String option3 = scan.next(); 
														
														switch(option3) 
														{
														
															case "1": 
															{
																System.out.println("Nome: ");
																client.name = scan.next();
															}break;
																
															case "2": 
															{
																System.out.println("Telefone: ");
																client.telephone = scan.next();
															}break;
																
															case "3":
															{
																System.out.println("Data de nascimento (dd/mm/aaaa): ");
																client.date = scan.next();
															}break;
																
															case "4": 
															{
																do 
																{
																	System.out.println("Gênero: \n [1] Masculiuno \n [2] Feminino");
																	client.gender = scan.next();	
																} while(Integer.parseInt(client.gender) < 1 || Integer.parseInt(client.gender) > 2);
															}break;
																
															case "0": break;
															
															default: System.out.println("Opção inválida!");
														}
														file.save(units);
													}
												}
											}
							            }break;
							            
							            // Remover cliente
							            case "3": 
							            {  					
											System.out.println("Nome: ");
											String name = scan.next();
											
											for(int y=0; y < u.contacts.size(); y++){
												Client client = u.contacts.get(y);
												
												if(client.getName().equals(name)) {
													u.contacts.remove(client);
													System.out.println("Contato '" + name + "' removido com sucesso."); 
													break;
												}
											}               
											file.save(units);
							            }break;
							            
							            // Adicionar serviço
										case "4": 
										{
											String name = "";
											
											// Solicitando nome do cliente para adicionar o serviço
											System.out.println("Nome do cliente: ");
											name = scan.next().toLowerCase();
											
											// Percorrendo todos os clientes
											for(i=0; i < u.contacts.size(); i++){
												Client client = u.contacts.get(i);
												
												// Se o cliente foi o mesmo inserido pelo usuário ele adiona o serviço
												if(client.getName().toLowerCase().equals(name)) {
													System.out.println("Serviço: ");
													String service = scan.next();
													
													// Salvando alterações
													client.services.add(service);
													file.save(units);
												}
											}
										}break;
							            
										// Listagem de todos os clientes em ordem alfabética
							            case "5": 
							            {	            	
							        		if(u.contacts.isEmpty()) {
							        			System.out.println("Nenhum cliente cadastrato.");
							        		}
							        		else {
							        			Collections.sort(u.contacts);
							        			for(int x = 0; x < u.contacts.size(); x++) {
							        				System.out.println(u.contacts.get(x));
							        			}
							        		}
							            }break;       
							            
							            // Listar clientes por gênero
							            case "6": 
							            { 
							            	if(u.contacts.isEmpty()) {
							            		System.out.println("Nenhum cliente cadastrato.");
							            	}
											else {
												String gender = "";
												
												do 
												{
													// Pegando o genero dos clientes
													System.out.println("Gênero: \n [1] Masculiuno \n [2] Feminino");
													gender = scan.next();	
												} while(Integer.parseInt(gender) < 1 || Integer.parseInt(gender) > 2);
												
												// Percorrendo todos os clientes
												for(i=0; i < u.contacts.size(); i++){
													Client client = u.contacts.get(i);
													
													// Se for o mesmo genero escolhido pelo usuário ele imprime
													if(client.getGender().equals(gender)) {
														System.out.println(client.getName());
													}
												}
											}
							            }break;
							            
							            // Idade média dos clientes
							            case "7": 
							            { 
							            	int average = 0;
							            	Client client = new Client();
							            	
											if(u.contacts.isEmpty()) {
												System.out.println("Nenhum cliente cadastrato.");
											}
											else {
												// Percorrendo todos os clientes cadastrados
												for(i = 0; i < u.contacts.size(); i++) {
													client = u.contacts.get(i);
													
													// Pegando a idade dos clientes e somando
													int age = Component.getAge(client.date);
													average += age;
												}
												// Realizando o calculo da média
												average = average / (u.contacts.size());
												System.out.println("Idade  média dos clientes: " + average);
											}
							            }break;
							            
							            // Idade média para um determinado gênero
							            case "8": 
							            { 
							            	int cont = 0;
							            	String gender = "";
							            	Client client = new Client();
							            	
											do 
											{
												// Pegando o gênero dos clientes
												System.out.println("Gênero: \n [1] Masculiuno \n [2] Feminino");
												gender = scan.next();	
											} while(Integer.parseInt(gender) < 1 || Integer.parseInt(gender) > 2);
											
											int average = 0;
											
											// Percorrendo todos os clientes
											for(i = 0; i < u.contacts.size(); i++) {
												client = u.contacts.get(i);
												
												// Se o gênero do cliente for o mesmo do inserido pelo usuário ele seleciona
												if(client.getGender().toLowerCase().equals(gender)) {
													int idade = Component.getAge(client.date);
													
													average += idade;
													cont++;
												}
											}
											if(cont == 0) {
												System.out.println("Nenhum cliente encontrado.");
											}
											else {
												// Calculando a média 
												average = average / cont;
												String genderType = "";
												
												if (Integer.parseInt(gender) == 1) {
													genderType = "Masculino";
												}
												else {
													genderType = "Feminino";
												}
												System.out.println("Média para gênero " + genderType + ": " + average);
											}
							            }break;
							            
							            // Serviço mais procurado para todo o público
							            case "9": 
							            { 
							            	int cont = 0;
							            	int contBefore = 0;
							            	Client client = new Client();
											List<String> list = new ArrayList<>();
											String serviceClient = "";
											
											// Pega todos os serviços
											for(i = 0; i < u.contacts.size(); i++) {
												client = u.contacts.get(i);
												
												list.addAll(client.services);
											}											
											Collections.sort(list);
											
											for(i = 0; i < list.size(); i++) {
												cont = Collections.frequency(list, list.get(i));	
												if(cont > contBefore) {
													serviceClient = list.get(i);
													contBefore = cont;
												}
											}
											System.out.println("Serviço mais procurado: " + serviceClient);											
							            }break;
							            
							            // Serviço mais procurado para um determinado gênero 
							            case "10": 
							            { 
											String gender = "";
											int cont = 0;
							            	int contBefore = 0;
							            	Client client = new Client();
											List<String> list = new ArrayList<>();
											String serviceClient = "";
											
											do 
											{
												System.out.println("Gênero: \n [1] Masculiuno \n [2] Feminino");
												gender = scan.next();	
											} while(Integer.parseInt(gender) < 1 || Integer.parseInt(gender) > 2);
											
											// Pega todos os serviços
											for(i = 0; i < u.contacts.size(); i++) {
												client = u.contacts.get(i);
												
												if(client.getGender().equals(gender)) {
													list.addAll(client.services);
												}
											}											
											Collections.sort(list);
											
											for(i = 0; i < list.size(); i++) {
												cont = Collections.frequency(list, list.get(i));	
												if(cont > contBefore) {
													serviceClient = list.get(i);
													contBefore = cont;
												}
											}
											System.out.println("Serviço mais procurado: " + serviceClient);	
											
							            }break;
							           
							            // Sair
							            case "0": 
							            {   
							                System.out.println("\nPrograma encerrado."); 
							                System.exit(0);
							                
							            }break;
							            
							            default:{System.out.println("Opção Incorreta, por favor seleciona uma opção valida.");}
							        }
						        }
							}
						}
		            }
	            }break;
	            
	        	// Sair
				case "4":
				{
					System.out.println("\nPrograma encerrado."); 
	                System.exit(0);
				}break;
				
				default:{System.out.println("Opção Incorreta, por favor seleciona uma opção valida.");}
	        }
        }
	}
}
