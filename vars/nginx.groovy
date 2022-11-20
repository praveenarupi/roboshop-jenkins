def call() {
    env.SONAR_JAVA_PROPERTY = ""
    node() {
        common.CodeCheckout()
        common.SonarCheck()
        if (env.TAG_NAME ==~ ".*") {
            common.UploadArtifact()
            common.makeAMI()
        }
    }
}
