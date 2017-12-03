### Vue.js and Spring Boot Starter

- Vue-cli , Vue-router , Axios
- Webpack
- Spring Boot , Hibernate
- MySQL

[![jdkversions](https://img.shields.io/badge/Java-1.7%2B-yellow.svg)]()  [![vueversions](https://img.shields.io/badge/vue.js-2.2.x-brightgreen.svg)]()  [![es2015](https://img.shields.io/badge/ECMAScript-6-green.svg)]()

**Preparation**
- Please  install Java 1.7 or even higher version

- install Node.js / NPM

- instaill MySQL

- Clone Repository

**Installation**

- MySQL : create a new database "spring_boot"  

- Run Maven Install 

- Maven will also run npm install and npm run build 
  - pom:

		 	<plugin>
				<groupId>com.github.eirslett</groupId>
				<artifactId>frontend-maven-plugin</artifactId>
				<version>1.6</version>
				<configuration>
					<workingDirectory>src/front</workingDirectory>
				</configuration>
				<executions>
					<execution>
						<id>install node and npm</id>
						<goals>
							<goal>install-node-and-npm</goal>
						</goals>
						<configuration>
							<nodeVersion>v8.4.0</nodeVersion>
							<npmVersion>5.4.2</npmVersion>
						</configuration>
					</execution>

					<execution>
						<id>npm install</id>
						<goals>
							<goal>npm</goal>
						</goals>
						<configuration>
							<arguments>install</arguments>
						</configuration>
					</execution>

					<execution>
						<id>npm run build</id>
						<goals>
							<goal>npm</goal>
						</goals>
						<configuration>
							<arguments>run build</arguments>
						</configuration>
					</execution>

				</executions>
			</plugin>
- After all , you will see :
	- index.html in resource --> templates
	- js and css folder in resource --> static
	- new tables in database "spring_boot"

- Note: 
	- If you do not want automatic generation of database schemas , please check  application.yml and change create to update

			ddl-auto: update

**Usage**
- Just run jar file in target folder

		java -jar SpringBoot_Vue-0.0.1-SNAPSHOT.jar
- Opne http://localhost:8087 and login admin/admin

