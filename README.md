# flcommerce — Sistema de E-commerce (Backend)

Sistema de e-commerce backend desenvolvido no curso **Java Spring Professional**, ministrado pelo professor **Nélio Alves**. O projeto implementa toda a camada de domínio, regras de negócio, persistência e endpoints REST de um sistema completo de loja virtual.

---

## 📝 Descrição curta
Backend completo de um sistema de e-commerce, implementado com Java e Spring Boot.

---

## 📘 Descrição completa
O **flcommerce** é um sistema de e-commerce desenvolvido como desafio prático no curso Java Spring Professional. Ele permite o cadastro de usuários (clientes e administradores), gerenciamento de categorias e produtos, navegação em catálogo de produtos, carrinho de compras, registro de pedidos e controle de status de pagamento/entrega.

O projeto explora conceitos importantes do ecossistema Java, incluindo Spring Boot, Spring Security, JPA/Hibernate, testes com H2, uso de PostgreSQL em ambiente de desenvolvimento e organização de camadas.

---

## 🧰 Tecnologias utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Spring Web**
- **Spring Data JPA (Hibernate)**
- **Banco H2** (perfil de teste)
- **PostgreSQL** (desenvolvimento)
- **Maven**
- **Docker** (PostgreSQL + PGAdmin via docker-compose, opcional)

O projeto utiliza `import.sql` dentro de `resources` para inserir dados iniciais.

---

## ▶️ Como rodar o projeto
### Requisitos
- Java 17
- Maven instalado
- PostgreSQL instalado **ou** PostgreSQL via Docker (opcional)

### Passos
1. Configure o banco PostgreSQL com usuário e senha definidos no `application-dev.properties`.
2. Execute o projeto com:
   ```bash
   mvn spring-boot:run
   ```

O projeto possui perfis (H2 para testes e PostgreSQL para desenvolvimento). 
Basta ajustar o `spring.profiles.active` para selecionar.

---

## 📁 Estrutura de pacotes
```
src/main/java/com.felipeleres.flcommerce
 ├── config
 ├── controllers
 ├── dto
 ├── entities
 ├── enums
 ├── projections
 ├── repositories
 ├── services
 └── FlcommerceApplication.java
```

---

## 🚀 Funcionalidades implementadas
Todas as funcionalidades previstas foram implementadas:

### 👤 Usuários
- É possível consultar o usuário logado.
- Usuários podem ser **CLIENTE** ou **ADMIN** (padrão: CLIENTE).

### 🛍️ Produtos e Categorias
- Cadastro completo de produtos e consulta de categorias.
- Produtos possuem: nome, descrição, preço e imagem.
- Catálogo público com filtro por nome do produto.
- Detalhamento completo do produto.

### 🛒 Carrinho de Compras
- Usuário pode consultar carrinho e adicionar produtos.
- Carrinho disponível para usuários não logados.

### 📦 Pedidos
- Registro do instante de criação.
- Controle de status: `AGUARDANDO_PAGAMENTO`, `PAGO`, `ENVIADO`, `ENTREGUE`, `CANCELADO`.
- Clientes visualizam seus próprios pedidos.
- Administradores podem gerenciar todos os pedidos.

---


## 👤 Autor
**Desenvolvido por Felipe Leres da Silva**, no curso **Java Spring Professional**, do professor **Nélio Alves**.

---
