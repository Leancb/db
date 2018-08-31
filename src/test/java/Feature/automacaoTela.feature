# language: pt
Funcionalidade:
  Eu, enquanto candidato a uma vaga de automação
  Preciso automatizar um cenário de testes
  Para ser avaliado se estou qualificado a vaga

  Esquema do Cenário: realizar uma compra com sucesso
      Dado que acessei o site para o teste
      Quando Escolha um produto qualquer na loja
      E Adicione o produto escolhido ao carrinho
      E Prossiga para o checkout
      E Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo <email>
      E Realize o cadastro do cliente preenchendo todos os campos obrigatórios dos formulários
      E preencher campo nome <nome>
      E preencher campo sobrenome <sobrenome>
      E preencher campo senha <senha>
      E clicar em dia/mes/ano e selecionar opções
      E preencher campo company <company>
      E preencher campo addreess <address>
      E preencher campo adrress2 <address2>
      E preencher campo city <cidade>
      E clicar no estado
      E preencher campo cep <cep>
      E clicar no pais
      E preencher anotações
      E preencher campo phone <telefone>
      E preencher o celular <celular>
      E preencher referência
      E clicar em registrar
      E Valide se o endereço está correto e prossiga.
      E Aceite os termos de serviço e prossiga.
      E Valide o valor total da compra
      E Selecione um método de pagamento e prossiga
    Entao Confirme a compra e valide se foi finalizada com sucesso

    Exemplos:
      | email                 | nome   | sobrenome   | senha | company | address | address2 |cidade        | cep   | telefone   | celular  |
      | tst@abc.cm.ar         | teste  |  sobre      | senha | teste   |    R1   |    R2    | Porto Alegre | 00000 |  993304544 | 998989988|