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
                environment {
                    SONAR=credentials('SONAR')
                }
                when {
                    anyOf {
                        expression { env.BRANCH_NAME == "main" }
                        expression { env.TAG_NAME ==~ ".*" }
                    }
                }
                steps {
                    sh ''' 
                    sonar-scanner -Dsonar.host.url=http://172.31.76.87:9000 -Dsonar.login=${SONAR_USR} -D sonar.password=${SONAR_PSW} -Dsonar.projectKey=${env.COMPONENT}                    
                  '''
                }
            }

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