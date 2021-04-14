package com.soa.videoclub.controllers;

import com.soa.videoclub.business.IUserBusiness;
import com.soa.videoclub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserBusiness userBusiness;

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public String listarAll(Model model){
        model.addAttribute("titulo","Listado de Usuarios");
        model.addAttribute("usuario",userBusiness.findAll());
        return "listar";

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
