def call() {
    env.SONAR_JAVA_PROPERTY = ""
    node() {
        common.CodeCheckout()
        common.SonarCheck()
    }
}
