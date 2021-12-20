// CODE_CHANGES = getGitChanges() // create a groovy script that checks the git changes
def gv

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

        stage("init"){
            
            when{
                expression{
                    BRANCH_NAME == 'main'
                    //CODE_CHANGES == TRUE
                }
            }

            steps{
                script{
                    gv = load "script.groovy"
                    sh('echo $gv')
                }
            }
            
        }

        stage("build"){
            
            when{
                expression{
                    BRANCH_NAME == 'main'
                    //CODE_CHANGES == TRUE
                }
            }

            steps{
                script{
                    gv.buildFun()
                }
            }
            
        }
        
        stage("test"){
            
            when{
                expression{
                    params.executeTests
                }
            }

            steps{
                script{
                    gv.testFun()
                }
            }
            
        }
        
        stage("deploy"){
            
            steps{
                script{
                    gv.deployFun()
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
