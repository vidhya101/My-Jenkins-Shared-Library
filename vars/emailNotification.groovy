def call(String subject, String body, String recipients, String buildUrl, String buildNumber, String buildId, String buildTimestamp, String buildStatus) {
    emailext(
        subject: subject,
        body: """
            <html>
                <body>
                    <h2>${buildStatus}!</h2>
                    <p><strong>Pipeline:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${buildNumber}</p>
                    <p><strong>Build ID:</strong> ${buildId}</p>
                    <p><strong>Build URL:</strong> <a href='${buildUrl}'>${buildUrl}</a></p>
                    <p><strong>Build Timestamp:</strong> ${buildTimestamp}</p>
                    <p>${body}</p>
                </body>
            </html>
        """,
        to: recipients,
        mimeType: 'text/html',
        attachLog: true
    )
}
