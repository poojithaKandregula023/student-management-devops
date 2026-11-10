pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn -B clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t student-management:latest .'
            }
        }
    }
}
