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
		/*
		Articulo articulo1 = Articulo.builder().cantidad(12).denominacion("picadillo swiss").precio(12).build();
		Factura factura1 = Factura.builder().numero(11).fecha("3 de septiembre de 2020").build();
		Categoria conservas = Categoria.builder().denominacion("conservas").build();
		Cliente cliente1 = Cliente.builder().nombre("Pablo").apellido("Muñoz").dni(7777777).build();
		Domicilio domicilio = Domicilio.builder().nombreCalle("San Martin").numero(111).build();
		DetalleFactura detalleFactura = DetalleFactura.builder().articulo(articulo1).cantidad(11).factura(factura1).build();
		factura1.getDetalles().add(detalleFactura);
		conservas.getArticulos().add(articulo1);
		articulo1.getCategorias().add(conservas);
		cliente1.setDomicilio(domicilio);
		domicilio.setCliente(cliente1);
		*/
		
		
		Factura factura1 = Factura.builder().numero(11).fecha("3 de septiembre de 2020").build();
		Domicilio domicilio = Domicilio.builder().nombreCalle("San Martin").numero(111).build();
		Cliente cliente1 = Cliente.builder().nombre("Pablo").apellido("Muñoz").dni(7777777).build();
		Categoria lacteos = Categoria.builder().denominacion("lacteos").build();
		Categoria perecederos = Categoria.builder().denominacion("perecederos").build();
		Categoria limpieza = Categoria.builder().denominacion("limpieza").build();
		Articulo articulo1 = Articulo.builder().cantidad(200).denominacion("Yogurt Ser de sabor frutilla").precio(20).build();
		Articulo articulo2 = Articulo.builder().cantidad(100).denominacion("Arroz Marolio").precio(30).build();
		DetalleFactura detalleFactura = DetalleFactura.builder().articulo(articulo1).cantidad(11).factura(factura1).build();
		DetalleFactura detalleFactura1 = DetalleFactura.builder().articulo(articulo2).cantidad(11).factura(factura1).build();

		
		
		cliente1.setDomicilio(domicilio);
		domicilio.setCliente(cliente1);
		
		factura1.setCliente(cliente1);

		
	
		
		articulo1.getCategorias().add(perecederos);
		articulo1.getCategorias().add(lacteos);
		lacteos.getArticulos().add(articulo1);
		perecederos.getArticulos().add(articulo1);
		
		
		detalleFactura.setArticulo(articulo1);
		detalleFactura.setCantidad(2);
		detalleFactura.setSubtotal(40);
		
		
		articulo1.getDetallesFacturas().add(detalleFactura);
		factura1.getDetalles().add(detalleFactura);
		
		

		detalleFactura1.setSubtotal(80);
		
		
		articulo2.getDetallesFacturas().add(detalleFactura1);
		factura1.getDetalles().add(detalleFactura);
		
		
		factura1.setTotal(120);
		
		
		
		em.persist(detalleFactura);
		em.persist(detalleFactura1);
		em.persist(domicilio);
		em.persist(cliente1);
		em.persist(lacteos);
		em.persist(perecederos);
		em.persist(limpieza);
		em.persist(factura1);
		em.persist(articulo1);
		em.persist(articulo2);
		
		System.out.println(factura1);


		em.flush();
		
		em.getTransaction().commit();
		
	} catch (Exception e) {
		em.getTransaction().rollback();
	}
	
	em.close();
	emf.close();
	
	
	}
}
