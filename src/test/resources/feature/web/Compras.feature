#language: pt

Funcionalidade: Realizar uma compra
	Como potencial ou atual cliente da loja
	Quero realizar uma compra
	Para ficar no estilo
	
		Contexto: Estar na tela de login
			Dado que esteja na pagina de login
			
@web @comprasWeb
Cenario: Comprar pecas logado
	Dado que esteja logado na pagina inicial
	E adicione compras ao carrinho
	Quando prosseguir com a compra ate o checkout
	Entao a compra e realizada com sucesso via "bank wire"
	
@web @comprasDeslogado
Cenario: Comprar pecas deslogado
	Dado que esteja na home page
	E adicione compras ao carrinho
	Quando prosseguir com a compra ate o checkout
	Entao realizar cadastro para prosseguir com a compra  via "bank wire"
