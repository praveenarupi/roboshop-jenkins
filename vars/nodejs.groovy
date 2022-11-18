def call() {
    node() {

            stage('Download Dependencies') {
                sh ''' 
                    npm install                    
                  '''
            }

            common.SonarCheck()

//            stage('Make Release - Upload Artifacts') {
//                when {
//                        expression { env.TAG_NAME ==~ ".*" }
//                }
//                steps {
//                    sh '''
//                    echo artifacts
//                  '''
//                }
//            }
        }
        post {
            always {
                cleanWs()
            }
        }
}
