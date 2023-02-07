def call() {
    artifactId = sh(script: "head -10 ${env.WORKSPACE}/pom.xml | grep '<$artifactId>' | tail -1 | cut -d '>' -f2 | cut -d '<' -f1",returnStdout: true).trim()
    groupId = sh(script: "head -10 ${env.WORKSPACE}/pom.xml | grep '<$groupId>' | tail -1 | cut -d '>' -f2 | cut -d '<' -f1",returnStdout: true).trim()
    version = sh(script: "head -10 ${env.WORKSPACE}/pom.xml | grep '<$version>' | tail -1 | cut -d '>' -f2 | cut -d '<' -f1",returnStdout: true).trim()
    return "${groupId}/${artifactId}-${version}"
}