def call() {
    withSonarQubeEnv('sonarserver') {
        sh '''
            ${SCANNER_HOME}/bin/sonar-scanner \
            -Dsonar.projectName=Youtube \
            -Dsonar.projectKey=Youtube \
            -Dsonar.sources=. \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.exclusions=**/node_modules/**,**/test/** \
            -Dsonar.verbose=true
        '''
    }
}
