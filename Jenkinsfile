pipeline {
		agent any 
    stages {
        stage('Git Pull') {
            steps {
				git url: 'https://github.com/fahedworks-24x7/Calculator_Mini_Project.git',
				branch: 'main'
            }
        }
        stage('Maven Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker build image') {
            steps {
                sh 'docker build -t fahed6739/calculator .'
            }
        }
        stage('Publish Docker Images') {
       steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push fahed6739/calculator:latest'
        }
            }
        }
        
        stage('Ansible Deploy') {
             steps {
                  ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'p2.yml' ,sudoUser: null
             }
        }
    }
    
    post {
        always {
            sh 'docker logout'
        }
    }
}
