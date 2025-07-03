### Aplicação simples de API Rest de Postagens ###
- Objetivo principal de rodar em Pipeline Nextflow
- Feito com Springboot Java
- Banco de dados MySQL
- Implementação de Flyway para execução de migrations
- Aplicação e banco de dados sobem via Docker compose

OBS: Necessário instalar o Nextflow para atender o requisito principal do projeto.
Para a instalação do Nextflow na raiz do projeto é mais aconselhado utilizar o WSL Linux para o Windows pois utilizar o próprio Windows para a instalação do Nextflow se torna mais complicado
Instalar o docker para rodar a aplicação e o banco mais facilmente caso não o tenha

### RODAR A APLICAÇÃO ###
1 - Abrir um terminal CMD ou Powershell
2 - Dar CD no diretório na raiz onde o projeto se localiza (onde o arquivo 'docker-compose.yaml' está)
3 - Digitar o comando 'docker-compose up --build'
4 - Aguardar o container subir (caso dê algum problema, tente re-executar, caso persista valide os logs de erro)

OBS: Caso queira buildar o projeto, basta abrir um powershell, dar CD no diretório raiz do projeto e executar o comando '.\build_project.ps1'
É necessário que tenha o Maven instalado em sua máquina, caso não tenha, o terminal irá informar os passos a serem seguidos.

### EXECUTAR NEXTFLOW PARA CONSUMIR A APLICAÇÃO ###
1 - Abrir o Ubuntu (Terminal)
2 - Abrir o diretório do projeto localizado no windows digitando "cd mnt" depois "cd c" e então prosseguir até o caminho raiz do projeto (onde os arquivos 'main.nf' e 'menu_nextflow.sh' estão)
3 - Após estar no diretório, digite "./menu_nextflow.sh" -> Isso executara um Shell script em formato de command para seleção de ações de consumo da Aplicação através do nextflow

OBS: Se for a ação '1 - Criar postagem' ou '2 - Alterar postagem' será solicitado um path, sempre digite no formato "input/nomeDoArquivo.json" que deve conter o JSON a ser enviado para a API, para mais dúvidas, consulte os arquivos existentes no diretório /input
Para alterações: Sempre ajuste o 'uuid' do registro a ser alterado no arquivo JSON utilizado para alteração.
	
