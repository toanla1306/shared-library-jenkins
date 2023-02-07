def call(link_repository, directory_helm_chart, name_chart) {
    withCredentials([usernamePassword(credentialsId:'nexusCredentials', passwordVariable: 'password', usernameVariable: 'username')]){
        sh ("cd $directory_helm_chart")
        sh ("helm package $name_chart")
        sh ("git pull origin master")
        sh ("unset http_proxy")
        sh ("unset https_proxy")
        sh ("curl -u $username:$password $link_repository --upload-file $name_chart-$version_chart.tgz")
    }
}