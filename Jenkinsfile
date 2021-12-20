pipeline {

    agent any 

    stages {

        stage("build"){
            
            // when{
            //     expression{
            //         CODE_CHANGES == TRUE
            //     }
            // }

            steps{
                echo "Building the application"
            }
            
        }
        
        stage("test"){
            
            when{
                expression{
                    BRANCH_NAME == 'dev'
                }
            }

            steps{
                echo "Testing the application"
            }
            
        }
        
        stage("deploy"){
            
            steps{
                echo "Deploying the application"
            }
            
        }

    }

    post{

        always{
            echo "Hi. I'm Nikos!"
        }

        failure {
            exho "Something went wrong!"
        }

    }

}
