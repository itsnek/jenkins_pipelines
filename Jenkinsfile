// CODE_CHANGES = getGitChanges() // create a groovy script that checks the git changes
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
                    BRANCH_NAME == 'main'
                    //CODE_CHANGES == TRUE
                }
            }

            steps{
                echo "Building the application"
                echo "Building version ${NEW_VERSION} ."
                //sh("mvn install")
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
                sh ('use $SERVER_CREDENTIALS')
                // withCredentials{[
                //     usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PSWD')
                // ]}
                // {
                //     //sh 'use $USER $PSWD'
                // }
                withCredentials{[
                    usernamePassword(credentialsId: 'server-credentials', variable: 'USERPASS')
                ]}
                {
                    sh 'use $USERPASS'
                }

            }
            
        }

    }

    post{

        always{
            echo "Hi. I'm Nikos!"
        }

        failure {
            echo "Something went wrong!"
        }

    }

}
