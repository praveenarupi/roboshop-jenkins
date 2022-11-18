def call() {
    node() {
        common.CodeCheckout()
        stage('Download Dependencies') {
           sh ''' 
            mvn clean package                     
           '''
        }
        common.SonarCheck()

    }
}
