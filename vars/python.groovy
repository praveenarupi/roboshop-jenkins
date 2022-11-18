def call() {
    pipeline {
        agent any

        options {
            ansiColor('xterm')
        }

        stages {
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