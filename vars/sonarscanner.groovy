def call(Map config = [:]) {
    def scannerHome = tool 'sonar6.2'
    def javaOpts = '-XX:+EnableDynamicAgentLoading --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.io=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED'
    
    withSonarQubeEnv('sonarserver') {
        sh """
            export SONAR_SCANNER_OPTS="${javaOpts}"
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${config.projectKey ?: 'default-project'} \
            -Dsonar.projectName=${config.projectName ?: 'default-project-name'} \
            -Dsonar.projectVersion=${config.projectVersion ?: '1.0'} \
            -Dsonar.sources=${config.sources ?: 'src/'} \
            -Dsonar.java.binaries=${config.binaries ?: 'target/test-classes/'} \
            -Dsonar.junit.reportsPath=${config.junitReports ?: 'target/surefire-reports/'} \
            -Dsonar.jacoco.reportsPath=${config.jacocoReports ?: 'target/jacoco.exec'} \
            -Dsonar.java.checkstyle.reportPaths=${config.checkstyleReports ?: 'target/checkstyle-result.xml'}
        """
    }
}
