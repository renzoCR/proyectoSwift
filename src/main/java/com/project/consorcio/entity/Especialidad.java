package com.project.consorcio.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_especialidad")
public class Especialidad {
	@Id
	@Column(name = "cod_espe")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_espe")
	private String nombre;
	
	@OneToMany(mappedBy = "especialidad") // ASOCIACION
	private List<Medico> listaEspecialidad;

	
}