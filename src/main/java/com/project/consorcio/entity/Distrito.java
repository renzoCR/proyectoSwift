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
@Table(name="tb_distrito")
public class Distrito {
	@Id
	@Column(name="cod_dis")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nom_dis")
	private String nombre;
	
	@OneToMany(mappedBy = "distrito") // ASOCIACION
	private List<Medico> listaDistrito;

}
