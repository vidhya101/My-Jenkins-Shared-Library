def call() {
    withSonarQubeEnv('sonarserver') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Youtube -Dsonar.projectKey=Youtube '''
    }
}
