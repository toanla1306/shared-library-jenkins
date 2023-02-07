def call(name){
    nametest123 = sh(script: "echo $name",returnStdout: true).trim()
    return "${nametest123}"
}

def test(name){
    sh "echo $name"
}