package com.yitech.store.session;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import com.yitech.store.model.Cerveja;
import com.yitech.store.model.ItemVenda;

public  class TabelaItensVenda {

	private String uuid;
	private List<ItemVenda> itens = new ArrayList<>();

	public TabelaItensVenda(String uuid) {
		this.uuid = uuid;
	}

	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}

	public void adicionarItem(Cerveja cerveja, Integer quantidade) {
		Optional<ItemVenda> itemVendaOptional = buscarItemPorCerveja(cerveja);

		ItemVenda itemVenda = null;
		boolean findProduct = false;

		if (itens.isEmpty()){

			System.out.println("No empty");
			itemVenda = new ItemVenda();
			itemVenda.setCerveja(cerveja);
			itemVenda.setQuantidade(0);
			itemVenda.setValorUnitario(cerveja.getValor());
			itens.add(0, itemVenda);
			System.out.println(itens.size());
			System.out.println(itemVendaOptional.isPresent());

		}
		Cerveja cervejaEncontrada= null;
		for(int i=0;i<=itens.size()-1;i++){

			if(itens.get(i).getCerveja().getCodigo().equals(cerveja.getCodigo())){

				findProduct=true;
				cervejaEncontrada = itens.get(i).getCerveja();


			}}

		System.out.println(findProduct);
		if(findProduct==true){


			for(int i=0;i<=itens.size()-1;i++){

				if(itens.get(i).getCerveja().getCodigo()==cervejaEncontrada.getCodigo()){

					itens.get(i).setQuantidade(itens.get(i).getQuantidade() + quantidade);

				}
			}



			findProduct=false;
		} else {

			System.out.println("No else");
			itemVenda = new ItemVenda();
			itemVenda.setCerveja(cerveja);
			itemVenda.setQuantidade(quantidade);
			itemVenda.setValorUnitario(cerveja.getValor());
			itens.add(0, itemVenda);
			System.out.println(itens.size());
			System.out.println(itemVendaOptional.isPresent());
		}



		/*if (itemVendaOptional.isPresent()) {
			System.out.println("Item existe");
			itemVenda = itemVendaOptional.get();
			itemVenda.setQuantidade(itemVenda.getQuantidade() + quantidade);
		} else {

			System.out.println("Somente a adicionar");
			itemVenda = new ItemVenda();
			itemVenda.setCerveja(cerveja);
			itemVenda.setQuantidade(quantidade);
			itemVenda.setValorUnitario(cerveja.getValor());
			itens.add(0, itemVenda);
			System.out.println(itens.size());
			System.out.println(itemVendaOptional.isPresent());
		}*/
	}

	public void alterarQuantidadeItens(Cerveja cerveja, Integer quantidade) {
		//ItemVenda itemVenda = buscarItemPorCerveja(cerveja).get();
		for(int i=0;i<=itens.size()-1;i++){

			if(itens.get(i).getCerveja().getCodigo().equals(cerveja.getCodigo())){


				itens.get(i).setQuantidade(quantidade);

			}};



	}

	public void excluirItem(Cerveja cerveja) {
		int indice = IntStream.range(0, itens.size())
				.filter(i -> itens.get(i).getCerveja().equals(cerveja))
				.findAny().getAsInt();
		itens.remove(indice);
	}

	public int total() {
		return itens.size();
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	private Optional<ItemVenda> buscarItemPorCerveja(Cerveja cerveja) {


		return itens.stream()
				.filter(i -> i.getCerveja().equals(cerveja))
				.findAny();
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaItensVenda other = (TabelaItensVenda) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

}
