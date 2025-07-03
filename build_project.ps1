$projectPath = Get-Location

try {
    mvn --version | Out-Null
} catch {
    Write-Error "Maven is not found in the system's PATH. Please ensure Maven is installed and configured correctly.Follow the Maven download link: https://maven.apache.org/download.cgi (just download, unzip in c:\apache-maven-<version> then configure your PATH enviroment variable with your \bin maven path)"
    Exit 1
}

Set-Location -Path $projectPath

Write-Host "Compiling Spring Boot project at: $projectPath"
try {
    mvn clean package
    Write-Host "Spring Boot project compiled successfully."
} catch {
   Write-Error "Error during project compilation. Check the Maven output for details."
   Exit 1
}