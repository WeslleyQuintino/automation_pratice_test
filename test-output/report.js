$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/web/Cadastro.feature");
formatter.feature({
  "name": "Cadastro",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@web"
    }
  ]
});
formatter.background({
  "name": "Estar na tela de login",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que esteja na pagina de login",
  "keyword": "Dado "
});
formatter.match({
  "location": "steps.web.LoginWebStep.que_esteja_na_pagina_de_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Realizar Cadastro com sucesso",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@web"
    },
    {
      "name": "@cadastroWeb"
    }
  ]
});
formatter.step({
  "name": "que eu esteja na pagina de cadastro",
  "keyword": "Dado "
});
formatter.match({
  "location": "steps.web.CadastroStep.queEuEstejaNaPaginaDeCadastro()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "realizo meu cadastro com os dados corretos",
  "keyword": "Quando "
});
formatter.match({
  "location": "steps.web.CadastroStep.realizoMeuCadastroComOsDadosCorretos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o cadastro e realizado com sucesso",
  "keyword": "Entao "
});
formatter.match({
  "location": "steps.web.CadastroStep.oCadastroERealizadoComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "realizo login com a conta criada",
  "keyword": "E "
});
formatter.match({
  "location": "steps.web.CadastroStep.realizoLoginComAContaCriada()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[MY ACCOUNT]\u003e but was:\u003c[AUTHENTICATION]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat pages.LoginPage.validateSucessfullyLogin(LoginPage.java:75)\r\n\tat steps.web.CadastroStep.realizoLoginComAContaCriada(CadastroStep.java:34)\r\n\tat ✽.realizo login com a conta criada(file:///C:/compasso-web-automation/src/test/resources/feature/web/Cadastro.feature:13)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/feature/web/Compras.feature");
formatter.feature({
  "name": "Realizar uma compra",
  "description": "\tComo potencial ou atual cliente da loja\n\tQuero realizar uma compra\n\tPara ficar no estilo",
  "keyword": "Funcionalidade"
});
formatter.background({
  "name": "Estar na tela de login",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que esteja na pagina de login",
  "keyword": "Dado "
});
formatter.match({
  "location": "steps.web.LoginWebStep.que_esteja_na_pagina_de_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Comprar pecas logado",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@web"
    },
    {
      "name": "@comprasWeb"
    }
  ]
});
formatter.step({
  "name": "que esteja logado na pagina inicial",
  "keyword": "Dado "
});
formatter.match({
  "location": "steps.web.ComprasStep.que_esteja_logado_na_pagina_inicial()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "adicione compras ao carrinho",
  "keyword": "E "
});
formatter.match({
  "location": "steps.web.ComprasStep.adicione_ao_carrinho()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: (//a[contains(text(), \u0027Faded Short\u0027)])[1]\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-29AJPT4\u0027, ip: \u0027192.168.15.99\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 93.0, javascriptEnabled: true, moz:accessibilityChecks: false, moz:buildID: 20210927210923, moz:geckodriverVersion: 0.30.0, moz:headless: false, moz:processID: 21120, moz:profile: C:\\Users\\wesll\\AppData\\Loca..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10.0, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: edfd5ba6-74a4-4c96-9b57-a354d817154d\n*** Element info: {Using\u003dxpath, value\u003d(//a[contains(text(), \u0027Faded Short\u0027)])[1]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat pages.HomePage.buyShopping(HomePage.java:83)\r\n\tat steps.web.ComprasStep.adicione_ao_carrinho(ComprasStep.java:34)\r\n\tat ✽.adicione compras ao carrinho(file:///C:/compasso-web-automation/src/test/resources/feature/web/Compras.feature:14)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "prosseguir com a compra ate o checkout",
  "keyword": "Quando "
});
formatter.match({
  "location": "steps.web.ComprasStep.prosseguir_com_a_compra_ate_o_checkout()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a compra e realizada com sucesso via \"bank wire\"",
  "keyword": "Entao "
});
formatter.match({
  "location": "steps.web.ComprasStep.a_compra_e_realizada_com_sucesso(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Estar na tela de login",
  "description": "",
  "keyword": "Contexto"
});
