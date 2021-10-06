#language: pt
  @web
  Funcionalidade:  Pesquisar produto
    Contexto:
      Dado que esteja na pagina de login
    @realizarPesquisa
    Cenario: Realizar pesquisa de produto
      E que esteja logado na pagina inicial
      Quando eu realizar a pesquisa do produto
      Entao deve ser valido a apresentacao do produto pesquisado
