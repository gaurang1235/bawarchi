pipeline {
	agent any
	environment{
	    PATH = "/opt/homebrew/bin:/usr/local/bin/docker:$PATH"
	}

    stages {
        stage('Git Pull') {
            steps {
				git url: 'https://github.com/gaurang1235/bawarchi.git',
				branch: 'main'
                sh 'cd /bawarchiFoodCourt'
            }
        }
        stage('Maven Build Backend_FoodCourt') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image Backend_FoodCourt') {
            steps {
                sh 'docker build -t iiitbgaurang/bawarchi_food_court:latest .'
            }
        }
        stage('Publish Docker Image Backend_FoodCourt') {
            steps {
                sh 'docker push iiitbgaurang/bawarchi_food_court:latest'
            }
        }
        stage('Clean Docker Image Backend_FoodCourt') {
            steps {
                sh 'docker rmi -f iiitbgaurang/bawarchi_food_court:latest'
                sh 'cd ..'
                sh 'cd bawarchiRestaurant'
            }
        }
        stage('Maven Build Backend_Restaurant') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image Backend_Restaurant') {
            steps {
                sh 'docker build -t iiitbgaurang/bawarchi_restaurant:latest .'
            }
        }
        stage('Publish Docker Image Backend_Restaurant') {
            steps {
                sh 'docker push iiitbgaurang/bawarchi_restaurant:latest'
            }
        }
        stage('Clean Docker Image Backend_Restaurant') {
            steps {
                sh 'docker rmi -f iiitbgaurang/bawarchi_restaurant:latest'
                sh 'cd ..'
                sh 'cd bawarchiFrontEndWeb'
            }
        }
        stage('Build Docker Image FrontEnd_Web') {
            steps {
                sh 'docker build -t iiitbgaurang/bawarchi_frontend_web:latest .'
            }
        }
        stage('Publish Docker Image FrontEnd_Web') {
            steps {
                sh 'docker push iiitbgaurang/bawarchi_frontend_web:latest'
            }
        }
        stage('Clean Docker Image FrontEnd_Web') {
            steps {
                sh 'docker rmi -f iiitbgaurang/bawarchi_frontend_web:latest'
                sh 'cd ..'
            }
        }

        



    }
}