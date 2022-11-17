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

            stage('Code Quality') {
                steps {
                    sh ''' 
                    echo Code                    
                  '''
                }
            }

            stage('Make Release - Upload Artifacts') {
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