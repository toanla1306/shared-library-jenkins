def call(Map config = [:]) {
    stage('helloworld') {
        timeout (time: 30, unit: 'MINUTES'){
            loadLinuxScript(name: 'hello-world.sh')
            sh "./hello-world.sh ${config.name} ${config.dayOfWeek}"
        }
    }
}