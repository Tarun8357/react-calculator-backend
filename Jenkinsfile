pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Provide Git credentials
                withCredentials([usernamePassword(credentialsId: 'git-credentials', usernameVariable: 'Tarun8357', passwordVariable: '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')]) {
                    git branch: 'main', credentialsId: 'accessId-1', url: 'https://github.com/Tarun8357/react-calculator-backend.git'
                }
                
                // Run Maven on a Windows agent
                bat "mvn -v"
            }

            post {
                success {
                    // Send email notification on build success
                    emailext body: 'Build Successful', subject: 'Information Of Build', to: 'tarun.dhakad@unoveo.com'
                }
            }
        }
    }
}