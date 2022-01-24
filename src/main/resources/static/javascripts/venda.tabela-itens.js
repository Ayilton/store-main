Brewer.TabelaItens = (function() {

	function TabelaItens(autocomplete) {
		this.autocomplete = autocomplete;
		this.tabelaCervejasContainer = $('.js-tabela-cervejas-container');
		this.uuid = $('#uuid').val();
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}

	TabelaItens.prototype.iniciar = function() {
		this.autocomplete.on('item-selecionado', onItemSelecionado.bind(this));

		bindQuantidade.call(this);
		bindTabelaItem.call(this);
	}

	TabelaItens.prototype.valorTotal = function() {

		var valor = $('.js-tabela-item').find('#valorTotalInput').val();
		console.log('o valor no retuns '+valor);
		return  valor;
		//return this.tabelaCervejasContainer.data('valor');
		//return this.tabelaCervejasContainer.target('valor').id;
	}

	function onItemSelecionado(evento, item) {
		var resposta = $.ajax({
			url: 'item',
			method: 'POST',
			data: {
				codigoCerveja: item.codigo,
				uuid: this.uuid
			}
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function onItemAtualizadoNoServidor(html) {
		this.tabelaCervejasContainer.html(html);
		$('.js-tabela-cerveja-quantidade-item').on('change',onQuantidadeItemAlterado.bind(this));
		$('.js-tabela-item').on('dblclick',onDoubleClick);

		bindQuantidade.call(this);
		var valorInput = $('#valorTotalInput').val();
		var tabelaItem = bindTabelaItem.call(this);
		this.emitter.trigger('tabela-itens-atualizada', valorInput);
		//this.emitter.trigger('tabela-itens-atualizada', valorTotal);
	}

	function onQuantidadeItemAlterado(evento) {
		var input = $(evento.target);
		var quantidade = input.val();




		console.log("nova quantidade"+evento.target.id);

		if (quantidade <= 0) {
			input.val(1);
			quantidade = 1;
		}

		var codigoCerveja =$(evento.target).data('codigo-cerveja');
		console.log("Codigo da cerveja123"+codigoCerveja);
		var resposta = $.ajax({
			url: 'item/'+ evento.target.id,
			method: 'PUT',
			data: {
				quantidade: quantidade,
				uuid: this.uuid
			}
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function onDoubleClick(element) {
		console.log("Target id oooo88"+this.id);
		var tabelaItem = $('.js-tabela-item');
		console.log( $('.js-tabela-item'));
		if(this)
			$(this).toggleClass('solicitando-exclusao');
	}

	function onExclusaoItemClick(evento) {
		var codigoCerveja = $(evento.target).data('codigo-cerveja');
		var resposta = $.ajax({
			url: 'item/' + this.uuid + '/' + evento.target.id,
			method: 'DELETE'
		});

		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}

	function bindQuantidade() {
		var quantidadeItemInput = $('.js-tabela-cerveja-quantidade-item');
		quantidadeItemInput.on('change', onQuantidadeItemAlterado.bind(this));
		//quantidadeItemInput.maskNumber({ integer: true, thousands: '' });
	}

	function bindTabelaItem() {
		var tabelaItem = $('.js-tabela-item');
		tabelaItem.on('dblclick', onDoubleClick);
		$('.js-exclusao-item-btn').on('click', onExclusaoItemClick.bind(this));
		return tabelaItem;
	}

	return TabelaItens;

}());


/**Brewer.TabelaItens =(function(){

	function TabelaItens(autocomplete) {
		this.autocomplete=autocomplete;
		this.tabelaCervejasContainer=$('.js-tabela-cervejas-container');


	}

TabelaItens.prototype.iniciar= function () {
		this.autocomplete.on('item-selecionado',onItemSelecionado.bind(this));
		this.tabelaCervejasContainer = $('.js-tabela-cervejas-container');

}

function onItemSelecionado(evento,item) {
		console.log('Item recebido do autocomplete',item);

		var resposta = $.ajax({

			url:'item',
			method:'POST',
			data:{
				codigoCerveja:item.codigo
			}

		});

		resposta.done(function (html) {


			this.tabelaCervejasContainer.html(html);

console.log('retorno',data);
		}.bind(this));

}

return TabelaItens;
}());

 $(function () {
	var autocomplete = new Brewer.Autocomplete();
	autocomplete.iniciar();

	var tabelaItens = new Brewer.TabelaItens(autocomplete);
	tabelaItens.iniciar();

})*/