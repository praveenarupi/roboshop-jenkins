def call() {
    env.SONAR_JAVA_PROPERTY = ""
    node() {
        common.CodeCheckout()
        stage('Download Dependencies') {
          sh ''' 
            npm install                    
           '''
        }

         common.SonarCheck()
        if (env.TAG_NAME ==~ ".*") {
//            common.UploadArtifact()
//            common.makeAMI()
            common.dockerImage()
        }
    }
}
