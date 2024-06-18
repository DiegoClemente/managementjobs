<h1>🛠️ Job Management Application</h1>
<p>Welcome to the Job Management Application! This web application is built using Spring Boot and integrates several technologies to manage job listings and credentials effectively.</p>

<h2>📚 Table of Contents</h2>
<ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#technologies">Technologies</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#testing">Testing</a></li>
        <li><a href="#documentation">Documentation</a></li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
</ul>

<h2 id="features">✨ Features</h2>
<ul>
        <li>🔐 Secure authentication with JWT</li>
        <li>📂 Job listings management</li>
        <li>👤 User credential management</li>
        <li>📊 Integration with PostgreSQL database</li>
        <li>🧰 In-memory H2 database for development</li>
</ul>

<h2 id="technologies">🚀 Technologies</h2>
<ul>
        <li>Spring Boot</li>
        <li>PostgreSQL</li>
        <li>JWT (JSON Web Tokens)</li>
        <li>Lombok</li>
        <li>Maven</li>
        <li>Junit</li>
        <li>H2 Database</li>
        <li>JaCoCo</li>
        <li>SonarQube</li>
</ul>

<h2 id="installation">⚙️ Installation</h2>
<p>To get a local copy up and running follow these simple steps:</p>
<ol>
        <li>Clone the repo:
            <pre><code>git clone https://github.com/DiegoClemente/managementjobs.git</code></pre>
        </li>
        <li>Navigate to the project directory:
            <pre><code>cd managementjobs</code></pre>
        </li>
        <li>Build the project with Maven:
            <pre><code>mvn clean install</code></pre>
        </li>
        <li>Run the application:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
</ol>

<h2 id="usage">💻 Usage</h2>
<p>Once the application is running, you can access it at <code>http://localhost:8080</code>. Use the following endpoints to manage jobs and credentials:</p>
<ul>
        <li>POST: <code>http://localhost:8080/company/job/</code> - Manage job listings</li>
        <li>POST: <code>http://localhost:8080/candidate/auth</code> - Manage user credentials</li>
</ul>

<h2 id="testing">🧪 Testing</h2>
<p>This project uses JUnit for unit tests and JaCoCo for code coverage. To run tests and view the coverage report:</p>
<pre><code>mvn test</code></pre>
<li>
        Start SonarQube Docker container:
        <pre><code>docker run -d --name sonarqube -p 9000:9000 sonarqube</code></pre>
</li>
<li>Run SonarQube analysis:
        <pre><code>mvn clean verify sonar:sonar -Dsonar.projectKey=managementjobs -Dsonar.projectName='managementjobs' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=your_token_generate_on_installation</code></pre>
</li>

<h2 id="documentation">📜 Documentation</h2>
<p>This project have a documentation using Swagger UI:</p>

<li>
        Can be access throw the link:
        <pre><code>https://managementjobs.onrender.com/swagger-ui/index.html#/</code></pre>
</li>

<h2 id="contributing">🤝 Contributing</h2>
<p>Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are <strong>greatly appreciated</strong>.</p>
<ol>
        <li>Fork the Project</li>
        <li>Create your Feature Branch (<code>git checkout -b feature/AmazingFeature</code>)</li>
        <li>Commit your Changes (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
        <li>Push to the Branch (<code>git push origin feature/AmazingFeature</code>)</li>
        <li>Open a Pull Request</li>
</ol>

<h2 id="license">📜 License</h2>
<p>Distributed under the MIT License. See <a href="LICENSE">LICENSE</a> for more information.</p>

<footer>
        <p>💻 Made with ❤️ by Diego Clemente</p>
</footer>


