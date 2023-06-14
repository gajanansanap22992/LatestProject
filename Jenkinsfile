pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build application'
            }
        }
        stage('Test Application') {
            steps {
                echo 'Test Application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy application'
            }
        }
    }
    post
    {
        always
        {
            emailext body: 'Hi please find status of your build', subject: 'Maven project build status', to: 'gnsanap22992@gmail.com'
        }
    }
}
