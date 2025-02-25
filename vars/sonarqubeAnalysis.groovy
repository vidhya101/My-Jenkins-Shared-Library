def call() {
    withSonarQubeEnv('sonarserver') {
        sh ''' 
        export SONAR_SCANNER_OPTS="${JAVA_OPTS}"
        $SCANNER_HOME/bin/sonar-scanner \
        -Dsonar.projectName=Youtube \
        -Dsonar.projectKey=Youtube \
        -Dsonar.projectVersion=1.0 \
        -Dsonar.sources=src/
        '''
    }
}
