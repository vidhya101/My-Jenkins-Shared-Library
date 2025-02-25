def call() {
    timeout(time: 1, unit: 'HOURS') {
        script {
            def qualityGate = waitForQualityGate()
            echo "Quality Gate Status: ${qualityGate.status}"
            if (qualityGate.status != 'OK') {
                error "Pipeline failed due to Quality Gate status: ${qualityGate.status}"
            }
        }
    }
}
