package com.algaworks.model;

public class Cliente {
	
	private Integer id;
	private String nome;
	private double valor;
	   
	public Cliente(Integer id, String nome, double valor) {
	    this.id = id;
	    this.nome = nome;
	    this.valor = valor;
	  }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	   
	  // getters e setters omitidos
	 
	}

