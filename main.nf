nextflow.enable.dsl=2

params.acao   = params.acao ?: 'listar'
params.titulo = params.titulo ?: ''
params.uuid   = params.uuid   ?: ''
params.arquivo = params.arquivo ?: ''

// processo para ações que não usam arquivo (listar, buscar, curtir)
process ConsomeAPI_Simples {
    input:
    val acao
    val titulo
    val uuid

    output:
    stdout

    script:
    def cmd = ""

    if (acao == 'listar') {
        cmd = "curl -s http://localhost:8000/getPostagens"
    }
    else if (acao == 'buscar') {
        def encodedTitulo = java.net.URLEncoder.encode(titulo, "UTF-8")
        cmd = "curl -s \"http://localhost:8000/getPostagemPorTitulo?titulo=${encodedTitulo}\""
    }
    else if (acao == 'curtir') {
        cmd = "curl -s -X PUT http://localhost:8000/curtirPostagem/${uuid}"
    }
    else {
        cmd = "echo \"Ação inválida para processo simples\""
    }

    return """
    echo "Executando ação: ${acao}"
    ${cmd}
    """
}

// processo para ações que usam arquivo (criar, alterar)
process ConsomeAPI_ComArquivo {
    input:
    val acao
    path arquivo

    output:
    stdout

    script:
    def cmd = ""

    if (acao == 'criar') {
        cmd = "curl -s -X POST http://localhost:8000/criarPostagem -H \"Content-Type: application/json\" -d @${arquivo.getName()}"
    }
    else if (acao == 'alterar') {
        cmd = "curl -s -X PUT http://localhost:8000/alterarPostagem -H \"Content-Type: application/json\" -d @${arquivo.getName()}"
    }
    else {
        cmd = "echo \"Ação inválida para processo com arquivo\""
    }

    return """
    echo "Executando ação: ${acao}"
    ${cmd}
    """
}

workflow {
    if (params.acao in ['listar', 'buscar', 'curtir']) {
        ConsomeAPI_Simples(params.acao, params.titulo, params.uuid)
        ConsomeAPI_Simples.out.view { println "\n JSON de retorno:\n$it" }
    }
    else if (params.acao in ['criar', 'alterar']) {
        ConsomeAPI_ComArquivo(params.acao, file(params.arquivo))
        ConsomeAPI_ComArquivo.out.view { println "\n JSON de retorno:\n$it" }
    }
    else {
        println "Ação '${params.acao}' não reconhecida."
    }
}
