pipeline {
    agent any
    environment {
            APPETIZE_API_TOKEN = credentials('appetize_api_token')
            APPETIZE_PUBLIC_KEY = 'epefc2mnhisphbdawvhtdhf5la'
//             APK_PATH = 'epefc2mnhisphbdawvhtdhf5la'
        }
    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/daaffaar/researchAppiumJavaMobile-Nobi.git']]])
           }
        }
//         stage('Upload to Appetize.io') {
//                     steps {
//                         bat "appetize upload --token $APPETIZE_API_TOKEN --path $APK_PATH"
//                     }
//                 }
                stage('Launch Appetize.io Emulator') {
                    steps {
                        bat "appetize launch --token $APPETIZE_API_TOKEN --publicKey $APPETIZE_PUBLIC_KEY"
                    }
                }
        stage('Test') {
            steps {
                bat 'mvn clean test -Dtest=base'
            }
        }

    }
}
