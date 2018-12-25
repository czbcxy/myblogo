FROM java:8
VOLUME /tmp
ADD fsblog.jar blogo.jar
RUN bash -c 'touch /blogo.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/blogo.jar"]