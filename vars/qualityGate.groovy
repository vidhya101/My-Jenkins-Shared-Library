def call(credentialsId) {
    def qualityGate = waitForQualityGate abortPipeline: false, credentialsId: credentialsId
    if (qualityGate.status != 'OK') {
        error "❌ Quality Gate failed: ${qualityGate.status}"
    } else {
        echo "✅ Quality Gate passed!"
    }
}
