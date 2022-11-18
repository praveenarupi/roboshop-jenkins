def call() {
    pipeline {
        agent any

        options {
            ansiColor('xterm')
        }

        stages {

            stage('Download Dependencies') {
            steps {
                sh ''' 
                    npm install                    
                  '''
            }
            }

            common.SonarCheck()

            stage('Make Release - Upload Artifacts') {
                when {
                        expression { env.TAG_NAME ==~ ".*" }
                }
                steps {
                    sh ''' 
                    echo artifacts                    
                  '''
                }
            }
        }
        post {
            always {
                cleanWs()
            }
        }
    }

}