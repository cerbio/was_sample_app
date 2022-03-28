# Sample app for Websphere server from [IBM javaHelloWorld app](https://github.com/IBM-Cloud/java-helloworld)

This project is a sample of how to develop using Websphere Traditional in RedHat CodeReady Workspace.

## The devfile for Websphere Traditional 9: [devfile_WAS_90.yaml](./CodeReady/devfile_WAS_90.yaml)

The devfile includes two projects:

- The git repository of this same [sampleapp](https://github.com/cerbio/was_sample_app.git): It contains the code for the application and the RH CodeReady Workspaces artifacts to develop, build and debug the application.
- The git repository of the [wasbase](https://github.com/cerbio/codeready.git) project hosting the scripts and configuraton required to setup Websphere environment in RH CodeReady Workspaces.

## Commands

### _Init default profile_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it initializes the Websphere profile.

### _Build_

The _Build_ command (maven component) runs ``` mvn clean package ``` from the root of the sampleapp git repo to build the java classes and package them as a WAR file.

### _Start server_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it starts the default Websphere server.

### _Stop server_

This command is left untouched by the original  [wasbase](https://github.com/cerbio/codeready.git) project: it stops the default Websphere server.

### _Deploy (App & Config)_

This command deploys the WAR file created by the build and configures some specific [properties](./was/was-config.props) for the application.

The deployment is executed by the [python script](./was/install_app.py) specific to this application.

The deployment assigns an application name in Websphere equal to 'Todos'.

### _Update (App-fast deploy)_

This command executes a replacement of the WAR file: it is faster than an actual deployment.

This command is used when there are new code changes in order to propagate them to the Websphere server and thus make them vivisble to the debugger.

## The devfile for Websphere Traditional 85: [devfile_WAS_85.yaml](./CodeReady/devfile_WAS_85.yaml)

This is similar to the Websphere Traditional 9 devfile: the only difference is in some default values required by the underlying [wasbase](https://github.com/cerbio/codeready.git) to handle Websphere 85.

## __How to run it__

Get the devfile more appropriated for your development environment and creates a RH CoderReady Workspace from it.

Execute the following steps:

1. Run the command _Init default profile_ to initialize the Websphere server.
2. Run the _Build_ to start the build of the application WAR.
3. Run the command _Start server_ to start it.
4. Run the command _Deploy (App & Config)_ once the build is complete.
5. Run the _Debug (attach)_ command to initialize a debugging session
6. Update the code and _Build_ to generate a new WAR file.
7. Run the command _Update (App-fast deploy)_ to update the server with latest code.

__Note__ that in order to access the WebSphere console URL it is required to create a route based on the 'was' service specifying 'passthrough' as secure configuration option.

Application URL:
<ROUTE_CONSOLE_OCP>/ibm/console/logon.jsp
