package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entidades.Cliente;
import entidades.Domicilio;

public class PersistenciaApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
	
	try {	
		em.getTransaction().begin();
		
		Cliente cliente = new Cliente("Juan","Perez",24577980);
		Domicilio domicilio = new Domicilio("San Martin",67);
		cliente.setDomicilio(domicilio);
		domicilio.setCliente(cliente);
		em.persist(cliente);
		
		//Domicilio dom = new Domicilio("Potrerillos",22,cliente);
		
		
		
		
		
		Cliente cli = em.find(Cliente.class, 1L);
		Domicilio domi = em.find(Domicilio.class, 1L);
		
		
	
		
		System.out.println("Cliente de domicilio: "+cli.getDomicilio().getNombreCalle()+" "+cli.getDomicilio().getNumero());
		System.out.println("Domicilio de Cliente: "+domi.getCliente().getApellido()+" "+domi.getCliente().getNombre());
		
		em.flush();
		
		em.getTransaction().commit();
		
	} catch (Exception e) {
		em.getTransaction().rollback();
	}
	
	em.close();
	emf.close();
	
	
	}
}
