pipeline {
    agent {
        kubernetes {
            yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: sonar-agent
spec:
  containers:
    - name: sonar-scanner
      image: sonarsource/sonar-scanner-cli:latest
      command: ["/bin/sh", "-c"]
      args: ["cat"]
"""
        }
    }
    stages {
        stage('SonarQube Analysis') {
            steps {
                container('sonar-scanner') {
                    sh """
                    sonar-scanner \
                      -Dsonar.projectKey=javatest \
                      -Dsonar.projectName='javatest' \
                      -Dsonar.host.url=http://192.168.1.14:9000 \
                      -Dsonar.token=sqp_f7eb7ae1a3bdea14c209b9267d286a737ab54e28
                    """
                }
            }
        }
    }
}
