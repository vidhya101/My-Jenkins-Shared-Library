def call(String sonarserver, String scannerHome) {
    withSonarQubeEnv(sonarserver) {
        sh """
            export SONAR_SCANNER_OPTS="${JAVA_OPTS}"
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=Youtube \
            -Dsonar.projectName=Youtube \
            -Dsonar.projectVersion=1.0 \
            -Dsonar.sources=src/
        """
    }
}
