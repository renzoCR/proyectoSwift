package com.project.consorcio.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {
	@Id
	@Column(name = "cod_med")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "nom_med")
	private String nombre;
	
	@Column(name = "ape_med")
	private String apellido;
	
	@Column(name = "fec_nac_med")
	private LocalDate fechaNacimiento;
	
	@Column(name = "sexo_med")
	private String sexo;
	
	@Column(name = "est_civ_med")
	private String estadoCivil;
	
	@Column(name = "dni_med")
	private String dni;
	
	@Column(name = "sue_med")
	private double sueldo;
	
	@ManyToOne
	@JoinColumn(name = "cod_dis")
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "cod_sede")
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(name = "cod_espe")
	private Especialidad especialidad;
	
}
