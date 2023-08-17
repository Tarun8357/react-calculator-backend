pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/Tarun8357/react-calculator-backend.git', branch: 'main'
                // Change file permisson
                sh "chmod +x -R ./jenkins"
                // Run shell script
                sh "./jenkins/script/scripted_pipeline_ex_2.sh"
            }
        }
    }
}