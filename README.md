# Sample app for Websphere server from [IBM javaHelloWorld app](https://github.com/IBM-Cloud/java-helloworld)

This project is a sample of how to develop using Websphere Traditional in RedHat CodeReady Workspace.

## Definition of the workspace for Websphere 9: [devfile_WAS_90.yaml](./CodeReady/devfile_WAS_90.yaml)

The devfile includes two projects:

- The git repository of this same [sampleapp](https://github.com/cerbio/was_sample_app.git): It contains the code for the application and the RH CodeReady Workspaces artifacts to develop, build and debug the application.
- The git repository of the [wasbase](https://github.com/cerbio/codeready.git) project hosting the scripts and configuraton required to setup Websphere environment in RH CodeReady Workspaces.

## Commands

### _Init default profile_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it initializes the Websphere profile.

### _Build_

The _Build_ command (maven component) runs 'mvn clean package' fron the root of the sampleapp git repo to build the java classes and package them as a WAR file.

### _Start server_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it starts the default Websphere server.

### _Stop server_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it stops the default Websphere server.

### _Deploy (App & Config)_

This command deploys the WAR file created by the build and cofnigures some specific [properties](./was/was-config.props) for the application.

The deployment is executed by the application specific [python script](./was/install_app.py).

The deployment assigns an application name in Websphere equal to 'Todos'.

### _Update (App-fast deploy)_

This command executes a replacement of the WAR file: it is faster than an actual deployment.

This command is used when there are new code changes in order to propagate them to the Websphere server and thus make them vivisble to the debugger.
