pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/daaffaar/researchAppiumJavaMobile-Nobi.git']]])
           }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test -Dtest=base'
            }
        }
    }
}