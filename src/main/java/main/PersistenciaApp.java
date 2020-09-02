package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenciaApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
	
	try {	
		em.getTransaction().begin();
		
		Factura factura1 = new Factura();
		factura1.setNumero(12);
		factura1.setFecha("01/09/2020");
		
		Domicilio dom = new Domicilio("San Martin",111);
		Cliente cliente = new Cliente("Pablo","Muñoz",12346634);
		cliente.setDomicilio(dom);
		dom.setCliente(cliente);
		
		factura1.setCliente(cliente);
		
		Categoria perecederos = new Categoria("perecederos");
		Categoria lacteos = new Categoria("lacteos");
		Categoria limpieza = new Categoria("limpieza");
		
		Articulo articulo1 = new Articulo(200,"Yogurt Ser de sabor frutilla",20);
		Articulo articulo2 = new Articulo(300,"Detergente Magistal",70);
		
		articulo1.getCategorias().add(perecederos);
		articulo1.getCategorias().add(lacteos);
		lacteos.getArticulos().add(articulo1);
		perecederos.getArticulos().add(articulo1);
		
		articulo2.getCategorias().add(limpieza);
		limpieza.getArticulos().add(articulo2);
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setArticulo(articulo1);
		det1.setCantidad(2);
		det1.setSubtotal(40);
		
		
		articulo1.getDetallesFacturas().add(det1);
		factura1.getDetalles().add(det1);
		det1.setFactura(factura1);
		
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setArticulo(articulo2);
		det2.setCantidad(1);
		det2.setSubtotal(80);
		
		
		articulo2.getDetallesFacturas().add(det2);
		factura1.getDetalles().add(det2);
		det2.setFactura(factura1);
		
		
		factura1.setTotal(120);
		
		
		
		
		em.persist(factura1);
		
		em.flush();
		
		em.getTransaction().commit();
		
	} catch (Exception e) {
		em.getTransaction().rollback();
	}
	
	em.close();
	emf.close();
	
	
	}
}
