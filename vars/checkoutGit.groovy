def call(String repoUrl, String branch) {
    echo "Checking out Git repository: ${repoUrl}, branch: ${branch}"
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[url: repoUrl]]
    ])
}
