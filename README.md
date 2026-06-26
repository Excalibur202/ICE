# Gestão de Instalação de Componentes Eletrónicos

O ICE é um aplicativo desktop Java Swing desenvolvido com o NetBeans para gerenciar clientes, funcionários e tarefas.
Ele fornece uma interface gráfica para realizar operações CRUD com integração de banco de dados usando MySQL/MariaDB.

---

## Overview

O ICE é um sistema de gerenciamento de desktops desenvolvido em Java usando Swing e JDBC.
Ele foi projetado para simular fluxos de trabalho administrativos do mundo real, incluindo gerenciamento de clientes, gerenciamento de funcionários e rastreamento de tarefas, com o suporte de um banco de dados relacional.

O projeto enfatiza:

- Arquitetura modular
- Separação de responsabilidades
- Fluxos de trabalho de interface do usuário orientados a banco de dados
- Design de desktop escalável baseado em Swing

---

## Features

### Gestão de clientes

- Criar, editar e gerenciar registros de clientes
- Operações CRUD baseadas em formulários
- Armazenamento persistente via banco de dados SQL

### Gestão de Funcionários

- Cadastro e atualizações de funcionários
- Módulo de interface de gerenciamento dedicado
- Fluxo de validação de formulário estruturado

### Sistema de gerenciamento de tarefas

- Criação e acompanhamento de tarefas
- Interface de fluxo de trabalho organizada
- Gestão do ciclo de vida das tarefas

### Integração de banco de dados

- Suporte a MySQL/MariaDB
- Camada de conexão JDBC centralizada (DBWorker)
- Estrutura de tratamento de consultas escalável

### Sistema de interface de usuário de desktop

- Aplicação Swing com múltiplas janelas
- Integração com o construtor de NetBeans .form GUI 
- Design de interface orientado a eventos

---

## Tech Stack

- Java (Swing)
- NetBeans IDE
- MySQL / MariaDB
- JDBC (mysql-connector-java 8.0.17)
- LGoodDatePicker
- JDatePicker
- Object-oriented programming (OOP)

---

## Diagrama de Fluxo de Dados
<pre>
User Action
    ↓
Swing UI (JFrame)
    ↓
Core Controller Logic
    ↓
DBWorker (JDBC Layer)
    ↓
MySQL / MariaDB
    ↓
Results returned to UI
</pre>
---

## Libraries

- MySQL Connector 8.0.17
- LGoodDatePicker 11.2.1
- JDatePicker 2.0.3
- NetBeans CopyLibs

---

## Screenshots

O projeto inclui um conjunto de prévias da interface do usuário:

- Menu principal
- Tela de gerenciamento de clientes
- Módulo de funcionários
- Interface de gerenciamento de tarefas
- Configuração de conexão com o banco de dados
- Tela inicial

(As capturas de imagem estão localizadas na pasta screenshots/)

---

## How to Build & Run

Pré-requisitos:

Java JDK 8+

NetBeans IDE (recomendado)

MySQL / MariaDB server

JDBC driver (incluido em /lib)

### Instalação

```
git clone https://github.com/Excalibur202/ICE.git
```
1. Abrir projeto em NetBeans
2. Configurar o banco de dados
3. Verificar que MySQL/MariaDB está em execução
4. Construir e executar projeto
