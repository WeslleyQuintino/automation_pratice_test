#language: pt
@web
Funcionalidade: Cadastro

		Contexto: Estar na tela de login
			Dado que esteja na pagina de login
		
@cadastroWeb
Cenario: Realizar Cadastro com sucesso
	Dado que eu esteja na pagina de cadastro
	Quando realizo meu cadastro com os dados corretos
	Entao o cadastro e realizado com sucesso
	E realizo login com a conta criada

		