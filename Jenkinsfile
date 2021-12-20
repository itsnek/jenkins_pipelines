pipeline {

    agent any 

    environment{
        NEW_VERSION = '1.1.1'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    tools{
        maven 'Maven'
    }

    parameters{
        //string(name: 'VERSION', defaultValue: '', description: 'my first version of Jenkinsfile to deploy')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'my first version of Jenkinsfile to deploy')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'my first version of Jenkinsfile to deploy')
    }

    stages {

        stage("build"){
            
            when{
                expression{
                    CODE_CHANGES == TRUE
                }
            }

            steps{
                echo "Building the application"
                echo "Building version ${NEW_VERSION} ."
                sh "mvn install"
            }
            
        }
        
        stage("test"){
            
            when{
                expression{
                    //BRANCH_NAME == 'dev'
                    params.executeTests
                }
            }

            steps{
                echo "Testing the application"
            }
            
        }
        
        stage("deploy"){
            
            steps{
                echo "Deploying the application"
                echo "Deploying with ${params.VERSION} ."
                echo "Deploying with "
                sh "${SERVER_CREDENTIALS}"
                with credentials{[
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PSWD)
                ]}{
                    sh "shell commands ${USER} ${PSWD}"
                }

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
