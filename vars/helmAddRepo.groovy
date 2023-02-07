def call(name_repository, link_repository) {
    withCredentials([usernamePassword(credentialsId:'nexusCredentials', passwordVariable: 'password', usernameVariable: 'username')]) {
        sh ("helm repo add $name_repository $link_repository --username $username --password $password")
    }
}