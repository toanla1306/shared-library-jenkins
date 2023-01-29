def call1(name){
    echo "Hey ${name}, how are you?"
}
def call2(Map config=[:]){
    echo "Hello ${config.name}. Today is ${config.dayOfWeek}."
}