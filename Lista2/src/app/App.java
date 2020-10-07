package app;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Client;
import model.Service;
import model.Unit;
import model.Vehicle;

public class App {

	public static void main(String[] args) throws Exception {
		
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
       
        System.out.println("Sistema de gerenciamento de revisões automotivas " + formatarDate.format(data));
        
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
	            	if(units.isEmpty()) {
						System.out.println("Nenhuma unidade encontrada, por favor cadastre uma unidade para continuar.\n");
					}
					else {
		            	System.out.println("Insira a unidade:");
						String unit = scan.next().toLowerCase();
						
						for(int i = 0; i < units.size(); i++) {
							
							Unit u = units.get(i);
		
							if(u.getName().toLowerCase().equals(unit)) {
								
						        while(true)
						        {  
						        	System.out.println(" ");
									System.out.println("Acessando com a unidade: " + u.getName());
					                System.out.println("Você possui " + u.contacts.size() + " cliente(s). \n");
					                
									System.out.println("[1] Adicionar cliente");
									System.out.println("[2] Listar clientes");
									System.out.println("[3] Acessar cadastro de um cliente");
									System.out.println("[4] Adicionar veículo");
									System.out.println("[5] Agendar serviço");
									System.out.println("[6] Alterar serviço");
									System.out.println("[7] Cancelar serviço");
									System.out.println("[8] Relatório de serviço");
									System.out.println("[0] Sair");
									
									System.out.printf("\nSelecione uma opção: ");
							        String option2 = scan.next(); 
							        
							        switch(option2)
							        {
							        	// Adicionar cliente
							            case "1": 
							            {    
											Client client = new Client();
											
											System.out.println("Nome: ");
											client.name = scan.next();
											
											System.out.println("Telefone: ");
											client.telephone = scan.next();
											
											System.out.println("Endereço: ");
											client.address = scan.next();
											
											System.out.println("CPF: ");
											client.cpf = scan.next();
											
											u.contacts.add(client);
											file.save(units);
											
											System.out.println("Cliente adicionado com sucesso!");
							            }break;
							            
										// Listar clientes
							            case "2": 
							            {	            	
											if(u.contacts.isEmpty()) {System.out.println("Nenhum cliente cadastrato.");}
											else {u.contacts.forEach(c -> System.out.println(c.getName()));}
							            }break;   
							            
										// Acessar cadastro de um cliente
							            case "3": 
							            {	            	
							            	String name;
											String nameClient = "";
											
											System.out.printf("Nome: ");
											name = scan.next();
											
											for(Client client: u.contacts) {
												nameClient = client.getName();	
												
												if(nameClient.equals(name)) {
													System.out.println(client);
												}
											}
							            }break;  
							            
							            // Adicionar veículo
							            case "4": 
							            {   										
											System.out.printf("CPF: ");
											String cpf = scan.next();
											
											String cpfClient = "";
											
											for(Client client: u.contacts) {
												cpfClient = client.getCpf();
												
												if(cpfClient.equals(cpf)) {
											
													Vehicle vehicle = new Vehicle();
													
													System.out.printf("Placa: ");
													vehicle.board = scan.next();
													
													System.out.printf("Modelo: ");
													vehicle.model = scan.next();
													
													System.out.printf("Ano de fabricação (yyyy): ");
													vehicle.yearManufacture = scan.next();
													
													System.out.printf("Preço (00,00): ");
													vehicle.price = scan.next();
													
													client.vehicles.add(vehicle);
													file.save(units);
													
													System.out.println("Veiculo adicionado com sucesso.");
												}
											}
							                
							            }break;
							            
							            // Agendar serviço
							            case "5": 
							            {   
							            	String cpf = "";
											String cpfClient = "";
											
											String board = "";
											String boardVehicle = "";
											
											System.out.printf("CPF: ");
											cpf = scan.next();
											
											for(Client client: u.contacts) {
												cpfClient = client.getCpf();
												
												if(cpfClient.equals(cpf)) {
													
													System.out.printf("Placa: ");
													board = scan.next();
													
													for(Vehicle vehicle: client.vehicles) {
														boardVehicle = vehicle.getBoard();
		
														if(boardVehicle.equals(board)) {
															Service service = new Service();
															
															System.out.printf("Nome do serviço: ");
															service.name = scan.next();
															
															System.out.printf("Data (dd/MM/yyyy): ");
															service.date = scan.next();
															
															System.out.printf("Horario (hh:mm): ");
															service.hour = scan.next();
															
															vehicle.services.add(service);
															file.save(units);
															
															System.out.println("Agendamento adiciondo com sucesso.");
														}
													}
												}
											}
							                
							            }break;
							            
							            // Alterar serviço
							            case "6": 
							            {   
							            	String cpf = "";
											String cpfClient = "";
											
											String board = "";
											String boardVehicle = "";
											
											String serv = "";
											String servVehicle = "";
											
											System.out.printf("CPF:");
											cpf = scan.next();		
											
											for(Client client: u.contacts) {											
												cpfClient = client.getCpf();
												
												if(cpfClient.equals(cpf)) {												
													System.out.printf("Placa: ");
													board = scan.next();
													
													for(Vehicle vehicle: client.vehicles) {													
														boardVehicle = vehicle.getBoard();
														
														if(boardVehicle.equals(board)) {
															
															System.out.printf("Serviço: ");
															serv = scan.next();
															
															for(Service service: vehicle.services) {															
																servVehicle = service.getName();
																
																if(servVehicle.equals(serv)) {
																	
																	vehicle.services.remove(service);
																	
																	System.out.printf("Data (dd/MM/yyyy): ");
																	service.date = scan.next();
																	
																	System.out.printf("Hora (hh:mm): ");
																	service.hour = scan.next();
																	
																	vehicle.services.add(service);
																	file.save(units);
																	
																	System.out.println("Agendamento alterado com sucesso.");
																	
																	Thread.sleep(2000);
																	break;
																}
															}
														}
													}
												}
											}						                
							            }break;
							            
							            // Cancelar serviço
							            case "7": 
							            {   
							            	String cpf = "";
											String cpfClient = "";
											
											String board = "";
											String boardVehicle = "";
											
											String serv = "";
											String servVehicle = "";
											
											System.out.printf("CPF:");
											cpf = scan.next();	
											
											for(Client client : u.contacts) {
												cpfClient = client.getCpf();
												
												if(cpfClient.equals(cpf)) {
													
													System.out.printf("Placa: ");
													board = scan.next();
													
													for(Vehicle vehicle: client.vehicles) {
														boardVehicle = vehicle.getBoard();
														
														if(boardVehicle.equals(board)) {
																
															System.out.printf("Serviço: ");
															serv = scan.next();
															
															for(Service service: vehicle.services) {															
																servVehicle = service.getName();
																
																if(servVehicle.equals(serv)) {
		
																	vehicle.services.remove(service);
																	file.save(units);
																	
																	System.out.println("Serviço removido com sucesso.");
																	
																	Thread.sleep(2000);
																	break;
																}
															}
														}
													}
												}
											}
							                
							            }break;
							            
							            // Relatório de serviços
							            case "8": 
							            {
							            	String cpf = "";
											String cpfClient = "";
											
											String board = "";
											String boardVehicle = "";
											
											System.out.printf("CPF:");
											cpf = scan.next();	
											
											for(Client client: u.contacts) {
												cpfClient = client.getCpf();
												
												if(cpfClient.equals(cpf)) {
													System.out.printf("Placa: ");
													board = scan.next();
													
													for(Vehicle vehicle: client.vehicles) {
														boardVehicle = vehicle.getBoard();
														
														if(boardVehicle.equals(board)) {
															
															if(vehicle.services.size() > 0) {
																for(Service service: vehicle.services) {
																	System.out.println("Serviço de " + service.name + 
																			" marcado para dia " + service.date + 
																			" ás " + service.hour + ".");
																}
															}
															else {
																System.out.println("Nenhum serviço encontrado para este cliente e veiculo.");
															}	
														}
													}
												}
											}
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
