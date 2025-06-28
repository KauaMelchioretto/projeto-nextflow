nextflow.enable.dsl=2

process compileAndRunJava {
input:
path javaFile

output:
stdout()

script:
"""
javac -d bin ${javaFile}
java -cp bin ifsc.edu.${javaFile.baseName}
"""
}

workflow {
Channel.fromPath("src/main/java/ifsc/edu/Main.java") | compileAndRunJava | view
}

