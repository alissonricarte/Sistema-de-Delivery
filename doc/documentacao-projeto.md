# Documentação do Projeto – Sistema de Delivery

## 1. Descrição Geral do Projeto

O Sistema de Delivery é uma aplicação desenvolvida em Java utilizando os conceitos da Programação Orientada a Objetos (POO). O sistema permite o gerenciamento de usuários, produtos e pedidos de um serviço de delivery, utilizando um menu interativo no terminal.

O objetivo do projeto é aplicar corretamente os quatro pilares da POO: Encapsulamento, Herança, Abstração e Polimorfismo.

---

## 2. Funcionalidades do Sistema

- Cadastro de usuários  
- Listagem de usuários  
- Cadastro de produtos (comida e bebida)  
- Listagem de produtos  
- Cálculo de taxas dos produtos  
- Criação de pedidos  
- Listagem de pedidos  
- Menu interativo no terminal  
- Encerramento seguro do sistema  

---

## 3. Tabela de Entidades e Atributos

| Entidade | Atributos |
|----------|-----------|
| Pessoa (abstrata) | nome, telefone, email |
| Cliente | endereco |
| Entregador | veiculo |
| Produto (abstrata) | nome, preco |
| Comida | tipo |
| Bebida | tamanho |
| Pedido | id, cliente, listaProdutos, valorTotal |

---

## 4. Descrição das Entidades (Classes e Interfaces)

### Pessoa (Classe Abstrata)
Representa um usuário genérico do sistema. Serve como base para Cliente e Entregador.

### Cliente (Classe)
Representa o cliente do sistema que realiza pedidos.

### Entregador (Classe)
Representa o entregador responsável pelas entregas.

### Produto (Classe Abstrata)
Representa um produto genérico do sistema.

### Comida (Classe)
Representa um produto do tipo comida.

### Bebida (Classe)
Representa um produto do tipo bebida.

### Pedido (Classe)
Representa os pedidos realizados pelos clientes.

### ITaxavel (Interface)
Interface responsável por definir o método de cálculo de taxa dos produtos.

### Controllers
Classes responsáveis por gerenciar as regras de negócio, como cadastro, listagem e interações do sistema.

---

## 5. Aplicação dos Pilares da POO

- Encapsulamento: Uso de atributos privados com getters e setters.  
- Herança: Cliente e Entregador herdam de Pessoa; Comida e Bebida herdam de Produto.  
- Abstração: Classes Pessoa e Produto são abstratas.  
- Polimorfismo: Uso de listas com classes abstratas e chamada de métodos sobrescritos.  

---

## 6. Observações Finais

Este projeto foi desenvolvido para fins acadêmicos, com foco na prática dos conceitos de Programação Orientada a Objetos, organização do código e boas práticas de desenvolvimento.
