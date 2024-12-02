# Busca Automática de CEP em Java

Este mini projeto em Java foi desenvolvido para sistemas desktop (Windows) e tem como objetivo buscar automaticamente o CEP através de um Web Service. Ele pode ser integrado em aplicações comerciais para otimizar o preenchimento de cadastros de clientes, fornecedores e outros dados relevantes.

## Funcionalidades
- Busca automática de CEP a partir de endereços fornecidos.
- Integração com um Web Service para recuperação de dados.
- Interface amigável para facilitar o uso em cadastros.
- Salvamento de logs e dados de buscas realizadas no banco de dados.

## Tecnologias Utilizadas
- Java
- Swing (ou JavaFX para a interface gráfica)
- Bibliotecas para requisições HTTP (ex: HttpURLConnection ou Apache HttpClient)
- Banco de dados relacional (MySQL)

## Como Usar
1. Clone este repositório.
2. Compile o projeto.
3. Configure o banco de dados conforme as instruções abaixo.
4. Execute a aplicação e utilize a funcionalidade de busca de CEP.

## Configuração do Banco de Dados
1. **Certifique-se de que o MySQL está instalado e em execução no ambiente.**

2. **Crie um banco de dados para o projeto:**

   ```sql
   CREATE SCHEMA correios;
3. **Configure a tabela necessária para armazenar logs das buscas realizadas:
  
  ```sql
  CREATE TABLE logs_busca_cep (
      id INT AUTO_INCREMENT PRIMARY KEY,
      endereco VARCHAR(255) NOT NULL,
      cep VARCHAR(10) NOT NULL,
      data_busca TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

4. **Adicione o driver MySQL Connector/J ao classpath do projeto.
5. Configure as credenciais de acesso ao banco de dados no código (dao.java):
  String url = "jdbc:mysql://localhost:3306/busca_cep";
  String username = "seu_usuario";
  String password = "sua_senha";
  Connection connection = DriverManager.getConnection(url, username, password);

## Contribuições
Contribuições são bem-vindas!
