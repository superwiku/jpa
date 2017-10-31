package com.wikutech.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.wikutech.jpa.entity.Pegawai;

public class Main {
EntityManagerFactory emf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main utama = new Main();
		utama.initEntityManagerFactory();
		utama.savePegawai();
		
		utama.closeEntityManagerFactory();

	}
	
	private void initEntityManagerFactory(){
		this.emf=Persistence.createEntityManagerFactory("jpa1");
	}
	
	private void closeEntityManagerFactory(){
		this.emf.close();
	}
	
	private void savePegawai(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Pegawai pegawai = new Pegawai();
		Pegawai pegawai2 = new Pegawai();
		pegawai.setNama("Wiku Hermawan");
		pegawai.setAlamat("Juwana");
		pegawai.setTglLahir("28 Mei 1976");
		pegawai2.setNama("Srikandi Putrawiku");
		pegawai2.setAlamat("Bandng");
		pegawai2.setTglLahir("18 November 2008");
		em.persist(pegawai);
		em.persist(pegawai2);
		tx.commit();
		em.close();
		
	}

}
