@Library('DevOpsLib') _
import com.regeneron.radit.devops.*;
 
pipeline {
  agent any

  environment{
    SONAR_TOKEN = 'sqp_ddbc9851ac781d0f066bb968691e2a5fdb5da338'
    SCANNER_HOME = tool 'SonarQubeScanner'
  }

  stages {
    stage("Sonar Scan") { 
      steps {
        script {
          withSonarQubeEnv(){
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