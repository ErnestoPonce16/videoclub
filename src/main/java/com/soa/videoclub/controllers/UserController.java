package com.soa.videoclub.controllers;

import com.soa.videoclub.business.IUserBusiness;
import com.soa.videoclub.business.exception.BusinessException;
import com.soa.videoclub.business.exception.NotFoundException;
import com.soa.videoclub.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = Constantes.URL_USER)
public class UserController {

    @Autowired
    private IUserBusiness userBusiness;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> listAll() {
		try {
			return new ResponseEntity<List<User>>(userBusiness.findAll(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @RequestMapping(value="/form")
    public String crear(Map<String,Object> model){
        User user = new User();
        model.put("usuario",user);
        model.put("titulo","Formulario de Usuario");
        return "form";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(User user){
        userBusiness.save(user);
        return "redirect:listar";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") int id, Map<String,Object> model){
        User user = null;
        if(id>0){
            user = userBusiness.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("usuario",user);
        model.put("titulo", "Editar usuario");
        return "form";
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        if(id>0){
            userBusiness.delete(id);
        }
        return "redirect:/listar";
    }
}
