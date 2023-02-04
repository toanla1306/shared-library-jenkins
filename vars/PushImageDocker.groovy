def loginDockerwithNexus() {
    withCredentials([usernamePassword(credentialsId:'dockerloginNexus', passwordVariable: 'password', usernameVariable: 'username')]) {
        sh "docker login -u $username -p $password nexus-repository.com:8085"
    }
}

// ISRO - Image Stream Repository OCP
def loginDockerwithISRO() {
    withCredentials([usernamePassword(credentialsId:'dockerloginISRO', passwordVariable: 'password', usernameVariable: 'username')]) {
        sh ("oc login -u $username -p $password https://api.crc.testing:6443")
        sh ("docker login -u $username -p $(oc whoami -t) image-registry-openshift-image-registry.apps-crc.testing")
    }
}

def pushDockertoNexus() {
    
}