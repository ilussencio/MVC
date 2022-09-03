package com.ilussencio.exercicio04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilussencio.exercicio04.model.Produto;

@Controller
public class Controle {
	@RequestMapping("/verproduto")
	public String exibirProduto(Model modelo) {
		Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(50000.00);
		modelo.addAttribute("prod", produto);
		return "exibeproduto";
	}
}
