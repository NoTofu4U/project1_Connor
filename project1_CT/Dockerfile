FROM openjdk
#container runs here

COPY . /workspace
#copies everything from project and puts it into a folder called workspace

WORKDIR /workspace
#what folder to work out of

EXPOSE 8080
#what port

ENTRYPOINT [ "java", "-jar", "target/project1_CT-1.0-SNAPSHOT-jer-with-dependencies.jar" ]
#couldn't do the next step Day5 recording CMD line 'docker build . -t reimbursement-api'
# failed to read dockerfile