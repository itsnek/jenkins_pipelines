def buildFun(){
    echo "Building the application"
    echo "Building version ${NEW_VERSION} ."

    // maven('maven-3.8.4'){
    //     sh 'mvn install'
    // }

    sh 'mvn --help'
    sh 'node --version'
    sh 'npm root -g'
    sh 'npm install -g yarn'
    // sh 'yarn install'

    nodejs('NodeJS'){
        sh 'lib//node_modules/npm/bin/npm install -g yarn'

        // withEnv(['PATH+NODE=/bitnami/jenkins/home/tools/jenkins.plugins.nodejs.tools.NodeJSInstallation/NodeJS']) {
        //     sh 'npm install -g yarn'
        //     sh 'yarn --help'
        // }

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
