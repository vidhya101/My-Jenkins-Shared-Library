def call(Map config = [:]) {
    def COLOR_MAP = [
        'SUCCESS': 'good', 
        'FAILURE': 'danger',
    ]
    
    slackSend(
        channel: config.channel ?: '#devops-ci',
        color: COLOR_MAP[currentBuild.currentResult],
        message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}"
    )
}
