### Aplicação simples de API Rest de Postagens ###
- Objetivo principal de rodar em Pipeline Nextflow
- Feito com Springboot Java
- Banco de dados MySQL
- Implementação de Flyway para execução de migrations

OBS: Necessário instalar o Nextflow para atender o requisito principal do projeto.
Para a instalação do Nextflow na raiz do projeto é mais aconselhado utilizar o WSL Linux para o Windows pois utilizar o próprio Windows para a instalação do Nextflow se torna mais complicado

### RODAR A APLICAÇÃO E TESTAR COM O NEXTFLOW ###
1 - Abrir o Ubuntu (Terminal)

-- SE NÃO TIVER O MYSQL INSTALADO NO UBUNTU --
- Abrir o Ubuntu e executar: 
	1 - sudo apt update
	2 - sudo apt install mysql-server

-- INICIAR O MYSQL --
2 - Sudo service mysql start 

-- CASO NÃO TIVER CRIADO O DB (projexto_nextflow) --
3 - Abre o mysql: sudo mysql
4 - CREATE DATABASE projeto_nextflow;
	CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'senha';
	GRANT ALL PRIVILEGES ON projeto.* TO 'usuario'@'localhost';
	FLUSH PRIVILEGES;
	EXIT;

-- RODAR A APLICAÇÃO NO UBUNTU --
1 - Abrir o terminal Ubuntu
2 - Dar um CD no '/mnt/c/Users/...(caminho) do projeto'
3 - Ao estar na raiz '//projeto-nextflow\projeto-nextflow' 
	Digite: java -jar target/projeto-nextflow-1.0-SNAPSHOT.jar -> Isso vai rodar a aplicação .Jar Spring
	
--- TESTAR O NEXTFLOW ---
1 - Abrir o Ubuntu (terminal)
2 - Dar um CD no caminho do projeto (igual da linha 30)
3 - Digite: './menu_nextflow.sh' => Isso executara um Shell script em formato de command para seleção de ações
4 - Digite a ação que deseja

OBS: Se for a ação '1 - Criar postagem' ou '2 - Alterar postagem' será solicitado um path, sempre digite no formato "input/nomeDoArquivo.json" que deve conter o JSON a ser enviado para a API, para mais dúvidas, consulte os arquivos existentes no diretório /input
	
