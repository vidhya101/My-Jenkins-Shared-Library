def success() {
    emailext (
        subject: "✅ [SUCCESS] Pipeline: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
        body: """
            <html>
                <body>
                    <h2>Build Successful!</h2>
                    <p><strong>Pipeline:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                    <p><strong>Build ID:</strong> ${env.BUILD_ID}</p>
                    <p><strong>Build URL:</strong> <a href='${env.BUILD_URL}'>${env.BUILD_URL}</a></p>
                    <p><strong>Build Timestamp:</strong> ${env.BUILD_TIMESTAMP}</p>
                    <h3>Stages Summary:</h3>
                    <ul>
                        <li>Unit Tests: Completed</li>
                        <li>Checkstyle Analysis: Completed</li>
                        <li>SonarQube Analysis: Passed</li>
                        <li>Quality Gate: Passed</li>
                        <li>Artifact Upload: Successful</li>
                    </ul>
                    <p>Check console output for detailed information.</p>
                </body>
            </html>
        """,
        to: '$DEFAULT_RECIPIENTS',
        mimeType: 'text/html',
        attachLog: true
    )
}

def failure() {
    emailext (
        subject: "❌ [FAILED] Pipeline: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
        body: """
            <html>
                <body>
                    <h2 style="color: red;">Build Failed!</h2>
                    <p><strong>Pipeline:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                    <p><strong>Build ID:</strong> ${env.BUILD_ID}</p>
                    <p><strong>Build URL:</strong> <a href='${env.BUILD_URL}'>${env.BUILD_URL}</a></p>
                    <p><strong>Build Timestamp:</strong> ${env.BUILD_TIMESTAMP}</p>
                    <p><strong>Failed Stage:</strong> ${currentBuild.result}</p>
                    <p>Check console output attached for error details.</p>
                    <h3>Last Successful Build:</h3>
                    <p><strong>Build Number:</strong> ${currentBuild.previousSuccessfulBuild?.number ?: 'None'}</p>
                </body>
            </html>
        """,
        to: '$DEFAULT_RECIPIENTS',
        mimeType: 'text/html',
        attachLog: true
    )
}
