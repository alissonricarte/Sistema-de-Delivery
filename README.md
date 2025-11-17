# 🚚 Sistema de Delivery – Projeto de POO

Este repositório contém o **Sistema de Delivery**, desenvolvido em Java com o objetivo de aplicar os quatro pilares da Programação Orientada a Objetos: **Encapsulamento, Herança, Abstração e Polimorfismo**.

O sistema roda no terminal e permite cadastrar usuários, produtos, pedidos e visualizar informações por meio de menus interativos.

---

## 🎯 Objetivo do Projeto

Criar um sistema simples, modular e orientado a objetos que permita:

- Gerenciar clientes e entregadores
- Gerenciar produtos (comidas e bebidas)
- Criar pedidos
- Listar todos os produtos e pedidos
- Utilizar polimorfismo para exibir informações
- Operar tudo via menu no terminal

---

## 🧠 Conceitos de POO Aplicados

### ✔️ Encapsulamento
- Todos os atributos são `private`
- Acesso somente por **getters** e **setters**
- Setters com validações (ex: preço não pode ser negativo)

### ✔️ Herança
- Superclasse abstrata **Pessoa**
  - Filhas: `Cliente`, `Entregador`
- Superclasse abstrata **Produto**
  - Filhas: `Comida`, `Bebida`

### ✔️ Abstração
- Classes mães possuem métodos abstratos que as filhas são obrigadas a implementar.

### ✔️ Polimorfismo
- Uma única lista armazena produtos:
---
### 🛠️ Tecnologias Utilizadas:
<div>
    <img alt="Java" width="90" height="26" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
    <img alt="Git" width="70" height="26" src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/>
    <img alt="GitHub" width="90" height="26" src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"/>
    <img alt="IntelliJ" width="120" height="26" src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white"/>
</div>

---
## 📁 Arquitetura do Sistema
```
Sistema-de-Delivery/                      # Pasta raiz do projeto
│
├── src/                               # Código-fonte principal
│   ├── main/                          # Arquivos principais da aplicação
│   │   ├── java/                      # Código Java do projeto
│   │   │   ├── app/                   # Ponto de entrada do sistema
│   │   │   │   └── Main.java          # Classe principal com menu
│   │   │   │
│   │   │   ├── controllers/           # Controladores (regras de negócio)
│   │   │   │   ├── PedidoController.java     # Gerencia pedidos
│   │   │   │   ├── ProdutoController.java    # Gerencia produtos
│   │   │   │   └── UsuarioController.java    # Gerencia usuários (clientes/entregadores)
│   │   │   │
│   │   │   ├── models/                # Classes que representam os objetos do sistema
│   │   │   │   ├── abstratos/         # Superclasses abstratas
│   │   │   │   │   ├── Pessoa.java    # Classe mãe para usuários
│   │   │   │   │   └── Produto.java   # Classe mãe para produtos
│   │   │   │   │
│   │   │   │   ├── usuarios/          # Classes filhas de Pessoa
│   │   │   │   │   ├── Cliente.java   # Cliente do delivery
│   │   │   │   │   └── Entregador.java# Entregador do delivery
│   │   │   │   │
│   │   │   │   ├── produtos/          # Classes filhas de Produto
│   │   │   │   │   ├── Comida.java    # Representa comidas
│   │   │   │   │   └── Bebida.java    # Representa bebidas
│   │   │   │   │
│   │   │   │   └── Pedido.java        # Representa um pedido completo
│   │   │   │
│   │   │   ├── utils/                 # Funções auxiliares
│   │   │   │   └── InputHelper.java   # Validação e leitura de dados
│   │   │
│   │   └── resources/                 # Arquivos externos (ex: .txt) caso usados
│   │
│   └── test/                          # Testes unitários (opcional)
│
├── README.md                          # Documentação do projeto
└── .gitignore                         # Ignora arquivos desnecessários no Git
```
