node {
  stage('SCM') {
    checkout scm
  }
  stages {
        stage('SonarQube Analysis') {
            steps {
                container('sonar-scanner') {
                    sh """
                    mvn clean verify sonar:sonar \
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

