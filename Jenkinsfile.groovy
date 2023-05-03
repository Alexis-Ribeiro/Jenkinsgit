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
            }
                            
        }
        stage("Test") {
            steps{
                echo "Unit tests."
                echo "Integration tests."
            }
        }
        stage("Code Quality Check") {
            steps{
                echo "Check the quality of the code"
            }
        }
        stage("Deploy") {
            steps{
                echo "Deploy the application to a $TESTING_ENVIRONMENT"
            }
        }
        stage("Approval") {
            steps{
                echo "This is the Approval stage"
                sleep 10
            }
        }
        stage("Deploy to Production") {
            steps{
                echo "The product $PRODUCTION_ENVIRONMENT is ready for production"
            }
        }
    }
}