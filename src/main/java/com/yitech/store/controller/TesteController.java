package com.yitech.store.controller;

import com.yitech.store.model.Cerveja;
import com.yitech.store.model.Origem;
import com.yitech.store.model.Sabor;
import com.yitech.store.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/testes")

public class TesteController {



    @Autowired
    private Cervejas cervejas;

    @RequestMapping("/nova")
    public ModelAndView nova(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());

        mv.addObject("origens", Origem.values());
        return mv;
    }



    @RequestMapping("/teste")
    public String teste(){


System.out.println("--Entrou--");

        return "teste/Test";
    }


    @RequestMapping(value = { "/nova", "{\\d+}" }, method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {


        return new ModelAndView("redirect:/cervejas/nova");
    }


}
