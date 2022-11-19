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
         common.UploadArtifact()
    }
}
