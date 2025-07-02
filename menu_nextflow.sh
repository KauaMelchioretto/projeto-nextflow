#!/bin/bash

clear
echo "=== MENU INTERATIVO - CLIENTE DA API SPRINGBOOT ==="
echo "Escolha uma operação:"
echo "1 - Criar postagem"
echo "2 - Obter todas as postagens"
echo "3 - Buscar por título"
echo "4 - Curtir postagem"
echo "5 - Alterar postagem"
read -p "Digite o número da opção desejada: " opcao

case $opcao in
    1)
        read -p "Informe o caminho do JSON da nova postagem: " input_json
        if [ ! -f "$input_json" ]; then
            echo "❌ Arquivo não encontrado: $input_json"
            exit 1
        fi
        input_json_abs=$(readlink -f "$input_json")
        nextflow run main.nf --acao criar --arquivo "$input_json_abs"
        ;;
    2)
        nextflow run main.nf --acao listar
        ;;
    3)
        read -p "Informe o título da postagem: " titulo
        nextflow run main.nf --acao buscar --titulo "$titulo"
        ;;
    4)
        read -p "Informe o UUID da postagem que deseja curtir: " uuid
        nextflow run main.nf --acao curtir --uuid "$uuid"
        ;;
    5)
        read -p "Informe o caminho do JSON com a postagem alterada: " input_json
        if [ ! -f "$input_json" ]; then
            echo "❌ Arquivo não encontrado: $input_json"
            exit 1
        fi
        input_json_abs=$(readlink -f "$input_json")
        nextflow run main.nf --acao alterar --arquivo "$input_json_abs"
        ;;
    *)
        echo "Opção inválida."
        ;;
esac
