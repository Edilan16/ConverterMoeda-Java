# ConverterMoeda-Java

Projeto em Java para converter valores de moedas estrangeiras (USD, EUR, GBP) para **Real (BRL)** via console, buscando a cotação em uma API externa.

## Funcionalidades
- Selecionar a moeda (USD, EUR ou GBP)
- Informar um valor a ser convertido
- Buscar cotação atual via requisição HTTP (`HttpClient`)
- Calcular e exibir o valor convertido em BRL

## Conceitos utilizados
- Entrada de dados com `Scanner`
- Requisições HTTP com `java.net.http.HttpClient`
- Manipulação simples de JSON via busca de substring (sem biblioteca externa)
- Tratamento de exceções (`try/catch`)

## Como executar
1. Abra o projeto em uma IDE Java (ex.: Eclipse/IntelliJ).
2. Execute a classe `main` (arquivo `src/main.java`).
3. No console:
   - escolha a moeda (1=USD, 2=EUR, 3=GBP)
   - digite o valor
4. O programa exibirá o valor convertido para reais.

## Estrutura
- `src/main.java`: programa principal (menu, requisição da cotação e conversão)

## Observações
- O projeto usa uma chave de API dentro do código. Recomenda-se mover a chave para variável de ambiente ou arquivo de configuração para evitar expor credenciais no repositório.