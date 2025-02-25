def call() {
    withSonarQubeEnv('sonarserver') {
        sh '''
            export SONAR_SCANNER_OPTS="${JAVA_OPTS}"
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectName=Youtube \
            -Dsonar.projectKey=Youtube \
            -Dsonar.sources=. \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.exclusions=**/node_modules/**,**/test/** \
            -Dsonar.verbose=true
        '''
    }
}
