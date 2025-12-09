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
│   │   │   ├── interfaces/            
│   │   │   │   ├── IImprimivel.java   # Interface para exibir detalhes
│   │   │   │   ├── ICadastravel.java  # Interface para controllers
│   │   │   │   └── ITaxavel.java      # Interface para produtos
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
│
├── README.md                          # Documentação do projeto
└── .gitignore                         # Ignora arquivos desnecessários no Git
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

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=110&color=F9F9F4&section=footer&reversal=false"/>



---

## ▶️ Como Baixar e Executar o Projeto

### ✅ Opção 1 – Baixar pelo GitHub (Sem usar terminal)

1. Acesse o repositório:

https://github.com/alissonricarte/Sistema-de-Delivery

2. Clique em **Code**
3. Clique em **Download ZIP**
4. Extraia o arquivo no seu computador
5. Abra a pasta no **VS Code** ou **IntelliJ**
6. Execute a classe `Main.java`

---

### ✅ Opção 2 – Baixar pelo Terminal (Usando Git)

```bash
git clone https://github.com/alissonricarte/Sistema-de-Delivery.git
cd Sistema-de-Delivery

Abra no VS Code:

code .

Depois execute a classe Main.java.

---

## ▶️ Como Executar no IntelliJ IDEA

### ✅ Opção 1 – Abrindo o projeto pelo IntelliJ

1. Abra o **IntelliJ IDEA**
2. Clique em **File > Open**
3. Selecione a pasta do projeto: Sistema-de-Delivery
4. Aguarde o IntelliJ carregar e indexar o projeto
5. No painel lateral, navegue até: src/main/java/app/Main.java
6. Clique com o botão direito sobre o arquivo `Main.java`
7. Clique em **Run 'Main.main()'**

✅ O sistema será iniciado no terminal do próprio IntelliJ.

---

### ✅ Opção 2 – Clonando direto no IntelliJ com Git

1. Abra o **IntelliJ IDEA**
2. Clique em **Get from VCS**
3. Cole este link: https://github.com/alissonricarte/Sistema-de-Delivery.git
4. Clique em **Clone**
5. Aguarde o download
6. Após abrir o projeto, execute o arquivo:
7. Clique com o botão direito → **Run 'Main.main()'**

---



## 👥 Integrantes do Grupo

- Alisson Ricarte – Matrícula: 2023022969 
- Mateus Kaynan – Matrícula: 2023022797  
- Mateus Pinheiro – Matrícula: 2023023130  
- Marcelo Marques – Matrícula: 2024010317
- Sara Vitória – Matrícula: 2023022619 
- Ana Vitória – Matrícula: 2023022758 
- Laura Gonçalves – Matrícula: 2023022621  