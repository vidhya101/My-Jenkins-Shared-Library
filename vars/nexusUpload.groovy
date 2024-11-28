def call(Map config) {
    nexusArtifactUploader(
        nexusVersion: config.nexusVersion ?: 'nexus3',
        protocol: config.protocol ?: 'http',
        nexusUrl: config.nexusUrl ?: '192.168.56.21:8081',
        groupId: config.groupId ?: 'QA',
        version: config.version ?: "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}",
        repository: config.repository ?: 'central-repo',
        credentialsId: config.credentialsId ?: 'nexuslogin',
        artifacts: config.artifacts ?: []
    )
}
