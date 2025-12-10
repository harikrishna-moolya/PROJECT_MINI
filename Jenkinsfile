pipeline {
  agent any
  environment {
    MAVEN_OPTS = "-Xms256m -Xmx1024m"
  }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build') {
      steps { sh 'mvn -B -DskipTests clean package' }
    }
    stage('Test') {
      steps { sh 'mvn test' }
    }
  }
  post {
    always { archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true }
  }
}
