pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checking out the source code from a version control system (e.g., Git)
               // checkout scm
                echo "Checkout"
            }
        }

        stage('Build') {
            steps {
                    echo "Build"
                // Replace this with your actual build commands
             //   sh 'echo "Building the project..."'
              //  sh './maven build' // Example build command for a Gradle project
            }
        }

        // Add more stages for additional steps like testing, deployment, etc.
    }
}
