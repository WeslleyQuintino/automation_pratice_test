# Automation Web - Automation Pratice
Projeto de teste  - Projeto na branch MASTER

## IDE Utilizada na criação do desenvolvimento:
IntelliJ - OBS: remoção das pastar .idea e target para execução idependente da IDE utilizada
## Pré-requisitos 
JAVA : Java JDK 1.8

Maven : apache maven 3.8.1(configurado na máquina local)

## Configurações Variáveis de ambiente do usuário
Nome da variável: JAVA_HOME

Java JDK Caminho: C:\Program Files\Java\jdk1.8.0_201 

## Configurações Variáveis de ambiente do sistema(Path)
Editar variável "Path" e adicionar dois novos caminhos : %JAVA_HOME%\bin , 

C:\Users\Public\apache-maven-3.8.1\bin

[Apache Maven 3.8.1 Download] - https://drive.google.com/drive/folders/1BXBe5y6GJVu_ym9S3_AX5qGBP0D-AObg?usp=sharing

OBS: chromedriver/geckodriver devem ser alocados na máquina local na raiz C: .

(OBS2: a dependência bone garcia atualiza a versao do  driver caso esteja desatualizada com o navegador instalado.)

## Executar via RunnerTest
Após importar o projeto de tipo "Maven" e buildar com sucesso , 
abrir o RunnerTest localizado em  "src/test/java/steps.runner/Runner" e clicar com o botão  ir em Run as > JUnit Test 
(OBS: configurar JUNIT para versao 4).

Cenários WEB:  @web(tag global)

## Evidências
Após execução dos testes é criado uma Pasta Evidence no diretório raiz do projeto onde está sendo salvo pela data atual e com nome de cada cenário executado em formato png.
