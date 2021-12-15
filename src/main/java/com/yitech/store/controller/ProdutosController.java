package com.yitech.store.controller;

import org.springframework.stereotype.Controller;


@Controller

public class ProdutosController {
	/**@Autowired
	private Categoria categoria;
	
	@Autowired
	private CadastroProdutoService cadastroProdutoService;
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public ModelAndView nova(Produto produto) {
		ModelAndView mv = new ModelAndView("produto/CadastroProduto");
		
		return mv;
	}
	
	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return nova(produto);
		}
		cadastroProdutoService.salvar(produto);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/produtos/novo");

	}
	
	@GetMapping
	public ModelAndView pesquisar(ProdutoFilter produtoFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		
		
		PageWrapper<Produto> paginaWrapper = new PageWrapper<>(produtos.filtrar(produtoFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

*/
}
