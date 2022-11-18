def SonarCheck() {
    if (env.BRANCH_NAME == "main") {
        stage('Code Quality') {
            sh ''' 
        sonar-scanner -Dsonar.host.url=http://172.31.76.87:9000 -Dsonar.login=${SONAR_USR} -Dsonar.password=${SONAR_PSW} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true
        '''
        }
    }
}