pipeline {
    agent { label 'docker-agent' }

    environment {
        JAVA_HOME = "/opt/jdks/jdk-25"
    }

    stages {
        stage('Checkout') { 
            steps {
                sh 'echo checkout'
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/bertodar/DevopsDemo']]
                )
            }
        }

        stage('Build') { 
            steps {
                sh 'echo build'

                dir('backend') {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew test'
                }

                recordCoverage(tools: [[parser: 'JACOCO', pattern: '**/jacocoTestReport.xml']])
                junit stdioRetention: '', testResults: '**/test-results/test/*.xml'

                nodejs('NodeJS') {
                    dir('frontend') {
                        sh 'npm install'
                        sh 'npm run lint:html'
                    }
                }

                withCredentials([string(credentialsId: 'Sonarqube-Backend', variable: 'TOKEN')]) {
                    dir('backend') {
                        sh './gradlew sonar -Dsonar.projectKey=DevOpsDemo-Backend -Dsonar.projectName=\'DevOpsDemo-Backend\' -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=$TOKEN'
                    }
                }

                withCredentials([string(credentialsId: 'Sonarqube-Frontend', variable: 'TOKEN')]) {
                    nodejs('NodeJS') {
                        dir('frontend') {
                            sh 'npx sonar-scanner -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=DevOpsDemo-Frontend -Dsonar.projectName=\'DevOpsDemo-Frontend\' -Dsonar.login=$TOKEN'
                        }
                    }
                }
            }
        }

        stage('Docker') {
            steps {
                sh '''
                    export DOCKER_HOST=tcp://host.docker.internal:2375
                    docker build -t bertodar/devopsdemo .
                '''
            }
        }
    }
}

