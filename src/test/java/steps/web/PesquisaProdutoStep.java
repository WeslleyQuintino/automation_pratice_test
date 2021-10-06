package steps.web;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.PesquisaProdutoPage;

public class PesquisaProdutoStep {
    PesquisaProdutoPage pesquisaProdutoPage = new PesquisaProdutoPage();

    @Quando("eu realizar a pesquisa do produto")
    public void eu_realizar_a_pesquisa_do_produto() {
        pesquisaProdutoPage.searchProduct();
    }

    @Entao("deve ser valido a apresentacao do produto pesquisado")
    public void deve_ser_valido_a_apresentacao_do_produto_pesquisado() throws InterruptedException {
        pesquisaProdutoPage.validateSearchedProduct();
        pesquisaProdutoPage.selectProduct();
        pesquisaProdutoPage.validateProductSelected();
    }
}
