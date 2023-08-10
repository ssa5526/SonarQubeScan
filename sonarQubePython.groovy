@Library('DevOpsLib') _
import com.regeneron.radit.devops.*;
 
pipeline {
  agent any

  environment{
    SCANNER_HOME = tool 'SonarQubeScanner'
  }

  stages {
    stage("Sonar Scan") { 
      steps {
        script {
          withSonarQubeEnv(credentialsID:'SONAR_TOKEN'){
            sh """
              $SCANNER_HOME/bin/sonar-scanner \
              -Dsonar.projectKey=ITESDO_sonarqube-test_AYj-ki90Hy9LwYYxyw5e \
              -Dsonar.sources=. \
              -Dsonar.host.url=https://sonar.regeneron.regn.com \
              -Dsonar.login=$SONAR_TOKEN
            """         
          }
        }
      }
    }
  }
}