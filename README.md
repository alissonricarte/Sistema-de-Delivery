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
Sistema-de-Delivery/                    # PROJETO PRINCIPAL
│
├── src/                                # CÓDIGO FONTE DO PROJETO
│   └── main/
│       └── java/
│           ├── app/                    # CAMADA DE APLICAÇÃO/EXECUÇÃO
│           │   ├── Main.java           # CLASSE PRINCIPAL DE INÍCIO DO SISTEMA
│           │   └── MenuPrincipal.java  # CONTROLE DO MENU INTERATIVO
│           │
│           ├── controllers/            # CAMADA DE CONTROLE/REGRA DE NEGÓCIO
│           │   ├── PedidoController.java    # GERENCIA OPERAÇÕES DE PEDIDOS
│           │   ├── ProdutoController.java   # GERENCIA OPERAÇÕES DE PRODUTOS
│           │   └── UsuarioController.java   # GERENCIA OPERAÇÕES DE USUÁRIOS
│           │
│           ├── enums/                  # ENUMERAÇÕES DO SISTEMA
│           │   └── StatusPedido.java   # DEFINE OS ESTADOS DE UM PEDIDO
│           │
│           ├── models/                 # CAMADA DE MODELOS/ENTIDADES
│           │   ├── abstratos/          # CLASSES ABSTRATAS BASE
│           │   │   ├── Pessoa.java     # CLASSE ABSTRATA PARA PESSOAS (Cliente/Entregador)
│           │   │   └── Produto.java    # CLASSE ABSTRATA PARA PRODUTOS (Comida/Bebida)
│           │   │
│           │   ├── interfaces/         # CONTRATOS/INTERFACES DO SISTEMA
│           │   │   ├── Cadastravel.java  # INTERFACE PARA ENTIDADES CADASTRÁVEIS
│           │   │   └── Taxavel.java      # INTERFACE PARA ENTIDADES TAXÁVEIS
│           │   │
│           │   ├── produtos/           # MODELOS CONCRETOS DE PRODUTOS
│           │   │   ├── Comida.java     # REPRESENTA PRODUTOS DO TIPO COMIDA
│           │   │   └── Bebida.java     # REPRESENTA PRODUTOS DO TIPO BEBIDA
│           │   │
│           │   ├── usuarios/           # MODELOS CONCRETOS DE USUÁRIOS
│           │   │   ├── Cliente.java    # REPRESENTA UM CLIENTE DO SISTEMA
│           │   │   ├── Entregador.java # REPRESENTA UM ENTREGADOR DO SISTEMA
│           │   │   └── ItemPedido.java # REPRESENTA UM ITEM EM UM PEDIDO
│           │   │
│           │   └── Pedido.java         # MODELO PRINCIPAL DE PEDIDO
│           │
│           └── utils/                  # UTILITÁRIOS E FERRAMENTAS AUXILIARES
│               ├── InputHelper.java    # AUXILIA NA LEITURA DE ENTRADA DO USUÁRIO
│               └── Validacao.java      # VALIDAÇÕES E REGRAS DE FORMATAÇÃO
│
├── doc/                                # DOCUMENTAÇÃO DO PROJETO (MESMO NÍVEL DE src/)
│   └── documentacao.md                 # DOCUMENTAÇÃO TÉCNICA E MANUAL
│
├── README.md                           # DOCUMENTAÇÃO INICIAL DO PROJETO
├── .gitignore                          # ARQUIVOS IGNORADOS PELO GIT
├── LICENSE                             # LICENÇA DO PROJETO
└── Sistema-de-Delivery.iml             # CONFIGURAÇÃO DO PROJETO (IntelliJ IDEA)
```
**📖 Para documentação completa:** [Clique aqui](./doc/documentacao-projeto.md)

## ▶️ Como Executar o Projeto
✔️ Via Terminal (Linux/Windows)
```
cd src/main/java
javac app/Main.java
java app.Main
```
✔️ Via IntelliJ IDEA

```
- Abra o IntelliJ

- File → Open

- Selecione a pasta do projeto

- Aguarde importar

- No painel lateral, abra app/Main.java

- Clique no botão Run ▶️
```

✔️ Via VSCode

```
Instale as extensões:

- Extension Pack for Java

- Abra o projeto

- Entre em src/main/java/app/Main.java

- Clique em Run

```
<h2 id="colab" align="center" style="font-weight: bold; font-size: 2rem">Colaboradores</h2>
  <div align="center">
    <table>
      <tr>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/144806270?v=4" width="100px;" alt="alisson"/><br>
            <sub>
              <a href="https://github.com/alissonricarte"><b>Alisson Ricarte</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/101362462?v=4" width="100px;" alt="mateusK"/><br>
            <sub>
              <a href="https://github.com/mateuskaynan"><b>Mateus Kaynan</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/156232385?v=4" width="100px;" alt="mateus"/><br>
            <sub>
              <a href="https://github.com/mateussspinheiro"><b>Mateus Pinheiro</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/185148834?v=4" width="100px;" alt="marcelo"/><br>
            <sub>
              <a href="https://github.com/MarceloHmarques"><b>Marcelo Marques</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/166541231?v=4" width="100px;" alt="sara"/><br>
            <sub>
              <a href="https://github.com/saraVitoria0"><b>Sara Vitoria</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/162624679?v=4" width="100px;" alt="daniel"/><br>
            <sub>
              <a href="https://github.com/anavitoriaq"><b>Ana Vitória</b></a>
            </sub>
          </a>
        </td>
        <td align="center">
          <a href="#">
            <img src="https://avatars.githubusercontent.com/u/143735022?v" width="100px;" alt="laura"/><br>
            <sub>
              <a href="https://github.com/lauragoncalvesf"><b>Laura Gonçalves</b></a>
            </sub>
          </a>
        </td>
    </table>
   <span style="font-weight: bold;">Equipe Sistema de Delivery - Obrigado por utilizar nosso sistema!</span>
  </div>
</div>

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=110&color=2D2D2D&section=footer&reversal=false"/>
