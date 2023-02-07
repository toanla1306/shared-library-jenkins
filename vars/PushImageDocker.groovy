def call(link_repository) {
    repository = sh (
        script: "echo $link_repository | grep 'nexus' | wc -l",
        returnStdout: true
    ).trim()

    if(if "${repository}" == "1" ) {
        withCredentials([usernamePassword(credentialsId:'nexusCredentials', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh "docker login -u $username -p $password nexus-repository.com:9005"
        }
    }esle{
        withCredentials([usernamePassword(credentialsId:'ocpCredentials', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh ("oc login -u $username -p $password https://api.crc.testing:6443")
            sh ("docker login -u $username -p $(oc whoami -t) image-registry-openshift-image-registry.apps-crc.testing")
        }
    }
    
    tagImageDocker = setTagDockerImage()
    sh ("docker push $link_repository/${tagImageDocker}")