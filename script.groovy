def buildFun(){
    echo "Building the application"
    echo "Building version ${NEW_VERSION} ."

    maven('Maven'){
        sh 'mvn install'
    }

    // sh 'mvn install'

    nodejs('NodeJS'){
        sh 'yarn install'
    }

}

def testFun(){
    echo "Testing the application"
}

def deployFun(){
    echo "Deploying the application"
    echo "Deploying with ${params.VERSION} ."
    echo "Deploying with "
    sh ('echo $SERVER_CREDENTIALS')
    // withCredentials{[
    //     usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PSWD')
    // ]}
    // {
    //     //sh 'use $USER $PSWD'
    // }
}

return this
