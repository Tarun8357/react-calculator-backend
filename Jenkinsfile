pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M2" and add it to the path.
        maven "M2"
    }

    stages {
        stage('Build') {
            steps {
               withCredentials([usernamePassword(credentialsId: 'accessId-1', usernameVariable: 'Tarun8357', passwordVariable: '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')]) {
                    git branch: 'main', credentialsId: 'accessId-1', url: 'https://github.com/Tarun8357/react-calculator-backend.git'
                }

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true install"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    emailext body: 'Build Installed Successfully', subject: 'Build Mail', to: 'tarun.dhakad@unoveo.com'
		      echo "Build Successfull" 
                }
            }
        }

	 stage ('Deploy') {
     	     steps {
                 script {
                     deploy adapters: [tomcat9(credentialsId: 'tomcat_credential', path: '', url: 'http://localhost:8080/CLEANSPRINGSECURITY')], contextPath: '/pipeline', onFailure: false, war: 'webapp/target/*.war' 
                 }
             }
    }
    }
}