package com.tcs.app.controller;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.app.model.Empleado;
import com.tcs.app.service.EmpleadoService;
import com.tcs.app.valores.AccionEnum;

@Controller
@RequestMapping("empleados")
public class EmpleadoController {

	@Autowired
    private EmpleadoService empleadoService;
	
	@RequestMapping("listar")  
    public String listar(Model model, HttpSession session){  
        List<Empleado> list=empleadoService.list();  
        model.addAttribute("listadoEmpleado",list);
        session.setAttribute("listadoEmpleadoSession", list);
        return "empleado/vista";  
    }
	
    @RequestMapping("nuevo")
    public String showform(Model model){  
    	model.addAttribute("empleado", new Empleado());
    	model.addAttribute("accion", AccionEnum.nuevo);
    	return "empleado/detalle"; 
    }
    
    @RequestMapping(value="/editar/{id}")  
    public String edit(@PathVariable long id, Model model){  
    	Empleado empleado = empleadoService.get(id);  
    	model.addAttribute("empleado",empleado);
        model.addAttribute("accion", AccionEnum.editar);
        return "empleado/detalle";  
    }
    
    @RequestMapping(value="guardar",method = RequestMethod.POST)  
    public String save(Empleado empleado){  
    	
    	if(Objects.isNull(empleado.getId())) {
    		empleadoService.create(empleado);
    	} else if(empleado.getId() == 0) {
    		empleadoService.create(empleado);
    	} else {
    		empleadoService.update(empleado);
    	} 
        return "redirect:listar";  
    }
    
    @RequestMapping(value="/eliminar/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id, Model model){  
    	try {
    		empleadoService.delete(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "Registro esta asociado a otro.");
	    } catch (Exception e) {
	    	model.addAttribute("error", "Se ha producido un error genérico.");
		}
    	List<Empleado> list=empleadoService.list();  
        model.addAttribute("listadoEmpleado",list);
        return "empleado/vista";  
    }
	
}
