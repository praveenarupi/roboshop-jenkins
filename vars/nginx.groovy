def call() {
    node() {
        common.CodeCheckout()
        common.SonarCheck()
    }
}
