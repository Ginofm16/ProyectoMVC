package com.tcs.app.controller;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tcs.app.model.Ingresos;
import com.tcs.app.service.EmpleadoService;
import com.tcs.app.service.IngresosService;
import com.tcs.app.valores.AccionEnum;

@Controller
@RequestMapping("ingresos")
public class IngresosController {

	@Autowired
    private EmpleadoService empleadoService;
	
	@Autowired
    private IngresosService ingresosService;
	
	@RequestMapping("listar")  
    public String listar(Model model){  
        List<Ingresos> list=ingresosService.list();  
        model.addAttribute("listadoIngresos",list);
        return "ingresos/vista";  
    }
	
    @RequestMapping("nuevo")
    public String showform(Model model){  
    	model.addAttribute("ingresos", new Ingresos());
    	model.addAttribute("listadoEmpleado", empleadoService.list());
    	model.addAttribute("accion", AccionEnum.nuevo);
    	return "ingresos/detalle"; 
    }
    
    @RequestMapping(value="/editar/{id}")  
    public String edit(@PathVariable long id, Model model){  
    	Ingresos ingresos = ingresosService.get(id);  
    	model.addAttribute("ingresos",ingresos);
    	model.addAttribute("listadoEmpleado", empleadoService.list());
        model.addAttribute("accion", AccionEnum.editar);
        return "ingresos/detalle";  
    }
    
    @RequestMapping(value="guardar",method = RequestMethod.POST)  
    public String save(Ingresos ingresos){  
    	
    	if(Objects.isNull(ingresos.getId())) {
    		ingresosService.create(ingresos);
    	} else if(ingresos.getId() == 0) {
    		ingresosService.create(ingresos);
    	} else {
    		ingresosService.update(ingresos);
    	} 
        return "redirect:listar";  
    }
    
    @RequestMapping(value="/eliminar/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id, Model model){  
    	try {
    		ingresosService.delete(id);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "Registro esta asociado a otro.");
	    } catch (Exception e) {
	    	model.addAttribute("error", "Se ha producido un error genérico.");
		}
    	List<Ingresos> list=ingresosService.list();  
        model.addAttribute("listadoIngresos",list);
        return "ingresos/vista";  
    }
	
}