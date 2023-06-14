pipeline {
    agent any

    tools {
        
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                
                git 'https://github.com/gajanansanap22992/LatestProject.git'

                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
                always
                {
                     emailext body: 'Hi please find status of your build', subject: 'Maven project build status', to: 'gnsanap22992@gmail.com'
                }
            }
        }
    }
}
