pipeline {
    agent any 
    environment {
        DIRECTORY_PATH = "/Users/Alexi/Documents/Cyber_Degree/SIT223/Week5"
        TESTING_ENVIRONMENT = "General Testing"
        PRODUCTION_ENVIRONMENT = "Alexis"
    }
    stages {
        stage("Build") {
            steps{
                echo "Fetch the source code from the directory path: $DIRECTORY_PATH"                
                echo "Compile the code and generate any necessary artifacts."
                echo "Code built using a build automation tool called Maven."
            }
                            
        }
        stage("Unit and Integration Tests") {
            steps{
                echo "Unit tests."
                echo "Integration tests."
                echo "pytest was the tool used for this"
                
            }
            post {
                always {
                        to:"alexis.ribeirog@hotmail.com",
                        subject:"Test Status: ${currentBuild.result}",
                        body:"The test stage has completed. Status: ${currentBuild.result}",
                        attachLog:true
                }
            }
        }
        stage("Code Analysis") {
            steps{
                echo "Check the quality of the code"
                echo "SonarQube was the tool used for this"
            }
        }
        stage("Security Scan") {
            steps{
                echo "Perform a security scan on the code using OWASP ZAP."
            }
            post {
                always {
                        to:"alexis.ribeirog@hotmail.com",
                        subject:"Security Scan Status: ${currentBuild.result}",
                        body:"The security scan stage has completed. Status: ${currentBuild.result}",
                        attachLog:true
                }
            }
        }
        stage("Deploy") {
            steps{
                echo "Deploy the application to a staging server (e.g., AWS EC2 instance) using Jenkins."
            }
        }
        stage("Integration Tests on Staging") {
            steps{
                echo "run integration tests on the staging environment to ensure the application functions as expected in a production-like environment"
                sleep 10
            }
        }
        stage("Deploy to Production") {
            steps{
                echo "The product $PRODUCTION_ENVIRONMENT is ready for production"
                echo "deploy the application to a production server (e.g., AWS EC2 instance) using Jenkins."
            }
        }
    }
}
