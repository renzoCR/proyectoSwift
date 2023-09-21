package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.services.MedicamentoServices;
import com.project.consorcio.services.TipoMedicamentoServices;

//anotaciòn que indica que la clase es un controlador, por lo tanto
//permite recibir peticiones de los cliente y envia respuesta.
@Controller
//permite crear una direcciòn URL o Ruta para acceder al controlador
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoServices servicioMed;
	
	@Autowired
	private TipoMedicamentoServices servicioTipo;
	
	@RequestMapping("/lista")
	//Model es una interfaz que permite crear atributos que luego seran
	//enviados a la pàgina
	public String index(Model model) {
		//atributos
		model.addAttribute("medicamentos",servicioMed.listarTodos());
		model.addAttribute("tipos",servicioTipo.listarTodos());
		return "medicamento";
	}
	
	//@RequestParam, permite recuperar valores que se encuentran en los
	//controles del formulario(cajas,checkbox,radio,etc)
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						@RequestParam("nombre") String nom,
						 @RequestParam("descripcion") String des,
						 @RequestParam("stock") int stock,
						 @RequestParam("precio") double pre,
						 @RequestParam("fecha") String fec,
						 @RequestParam("tipo") int codTipo,
						 RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Medicamento med=new Medicamento();
			//setear atributos del objeto "med" con los paràmetros
			med.setNombre(nom);
			med.setDescripcion(des);
			med.setStock(stock);
			med.setPrecio(pre);
			med.setFecha(LocalDate.parse(fec));
			//crear un objeto de la entidad TipoMedicamento
			TipoMedicamento tm=new TipoMedicamento();
			//setear atributo "codigo" del objeto "tm" con el paràmetro codTipo 
			tm.setCodigo(codTipo);
			//invocar al mètodo setTipo y enviar el objeto "tm"
			med.setTipo(tm);
			//validar parametro "cod"
			if(cod==0) {
				//REGISTRAR
				//invocar mètodo registrar
				servicioMed.registrar(med);
				//crear atributo de tipo flas
				redirect.addFlashAttribute("MENSAJE", "Medicamento registrado");
			}else {
				//ACTUALIZAR
				//setear atributo codigo
				med.setCodigo(cod);
				servicioMed.actualizar(med);
				redirect.addFlashAttribute("MENSAJE", "Medicamento actualizado");
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:/medicamento/lista";
	}
	//EDITAR 
	// .... /buscar?codigo=2
	//crear Ruta o direccion URL para buscar medicamento segùn codigo
	@RequestMapping("/buscar")
	//convertir en JSON el valor de retorno
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") Integer cod) {
		//leer parametro @requestParamn,lo obtiene de la pagina y lo guarda en COD
		return servicioMed.buscarPorID(cod);
	}
	
	
	
	
}
