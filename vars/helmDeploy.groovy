def helmInstall(releaseName, repoName, chartName) {
    sh ("helm install $releaseName $repoName/$chartName")
}

def helmUpgrade(releaseName, repoName, chartName) {
    sh ("helm upgrade $releaseName $repoName/$chartName")
}