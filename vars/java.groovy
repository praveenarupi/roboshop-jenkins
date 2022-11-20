def call() {
    env.SONAR_JAVA_PROPERTY = "-Dsonar.java.binaries=./target"
    node() {
        common.CodeCheckout()
        stage('Download Dependencies') {
           sh ''' 
            mvn clean package                     
           '''
        }
        common.SonarCheck()
        if (env.TAG_NAME ==~ ".*") {
            common.UploadArtifact()
            common.makeAMI()
        }

    }
}
