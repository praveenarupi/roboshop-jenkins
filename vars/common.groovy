def SonarCheck() {
    if (env.BRANCH_NAME == "main") {
        stage('Code Quality') {
            withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'SONAR_PSW', usernameVariable: 'SONAR_USR')]) {
                sh ''' 
        sonar-scanner -Dsonar.host.url=http://172.31.76.87:9000 -Dsonar.login=${SONAR_USR} -Dsonar.password=${SONAR_PSW} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_JAVA_PROPERTY}
        '''
        }
      }
    }
}

def CodeCheckout() {
    stage('Checkout Code') {
        sh 'rm -rf *'
        git branch: 'main', url: "https://github.com/praveenarupi/${env.COMPONENT}"
    }
}