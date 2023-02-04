def mavenCleanInstall() {
    sh "mvn clean install"
}

def unitTest() {
    sh "mvn test"
}

def scanSonarqube() {
    sh "mvn sonar:sonar"
}

def mavenPackage() {
    sh "mvn package -P springboot -DskipTests"
}

def pushArtifacttoNexus() {
    sh "mvn deploy -DskipTests"
}

def buildDockerImage() {
    sh "mvn dockerfile:build -Pdocker -DskipTests"
}