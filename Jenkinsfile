pipeline {

    agent any
      options {
        // This is required if you want to clean before build
        skipDefaultCheckout(true)
    }

    stages {
       //Stage Serenity BDD Test                 
        stage('AutoTest') {
            steps {
                // Clean before build
                cleanWs()
                 // We need to explicitly checkout from SCM here
                checkout scm
            sh 'docker stop serenity_report_webservices'
            sh 'docker rm serenity_report_webservices'       
		        sh 'docker run --name autoGradle --rm -v /home/ubuntu/PocBcoPopular/jenkins/jenkins_home/workspace/$JOB_BASE_NAME:/home/gradle/project -w /home/gradle/project gradle/chrome gradle clean test aggregate'
            }
	    }
        
        //Stage Snd report to nginx server
          stage('report') {
            steps {
		        sh './pipeline/report/report.sh'
            }
	    }

    }
        post {
        // Clean after build
        always {
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
}