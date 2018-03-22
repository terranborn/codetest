# codetest4testers
================================================================================

CONTENTS:

    1 Worksample - Description
    2 Assignment - Blog REST-service test plan and automatic test example
    3 Installing Blog project
    4 Integration Test
    5 Automated test example

================================================================================

================================================================================
1 Worksample - Description
================================================================================
If you do not already have one or more projects you're proud of and has
opportunity to submit, please perform the following worksample:

The goal of the test is to show how you would normally take on a 
testing tasks.


You decide how "deep" you go when implementing the task to satisfy the criterias.

================================================================================
2 Assignment - Blog REST-service test plan and automatic test example
================================================================================

In provided project You will find implemented RESTful service for serving blog-posts.

A "Post" have the attributes [id:String, title:String, content:String]

The REST service supports the following resources
--------------------------------------------------------------------------------
```
swagger: "2.0"
info:
  description: "This is the definition of the API for code test as Pierce AB"
  version: "1.0.0"
  title: "Simple blog post API"
host: "localhost:8080"
basePath: "/blog-web"
schemes:
- "http"
paths:
  /posts:
    get:
      tags:
      - "post"
      summary: "Get all posts"
      description: "Returns all posts"
      operationId: "getAllPosts"
      produces:
      - "application/xml"
      - "application/json"
      responses:
        200:
          description: "successful operation"
          schema:
            $ref: "#/definitions/Post"
    post:
      tags:
      - "post"
      summary: "Add a new post"
      description: ""
      operationId: "addPost"
      consumes:
      - "application/json"
      - "application/xml"
      produces:
      - "application/xml"
      - "application/json"
      parameters:
      - in: "body"
        name: "body"
        description: "Post object that needs to be added"
        required: true
        schema:
          $ref: "#/definitions/Post"
      responses:
        201: 
          description: "OK of post"
          schema:
            $ref: "#/definitions/Post"
        405:
          description: "Invalid input"
    put:
      tags:
      - "post"
      summary: "Updates a post"
      description: ""
      operationId: "updatePost"
      consumes:
      - "application/json"
      - "application/xml"
      produces:
      - "application/xml"
      - "application/json"
      parameters:
      - in: "body"
        name: "body"
        description: "Post object that needs to be updated"
        required: true
        schema:
          $ref: "#/definitions/Post"
      responses:
        201: 
          description: "OK of post"
          schema:
            $ref: "#/definitions/Post"
        404: 
          description: "Post not found"
        405:
          description: "Invalid input"
  /posts/{postId}:
    get:
      tags:
      - "post"
      summary: "Find post by ID"
      description: "Returns a single post"
      operationId: "getPostById"
      produces:
      - "application/xml"
      - "application/json"
      parameters:
      - name: "postId"
        in: "path"
        description: "ID of post to return"
        required: true
        type: "integer"
        format: "int64"
      responses:
        200:
          description: "successful operation"
          schema:
            $ref: "#/definitions/Post"
        404:
          description: "Post not found"
    delete:
      tags:
      - "post"
      summary: "Deletes a post"
      description: ""
      operationId: "deletePost"
      parameters:
      - name: "postId"
        in: "path"
        description: "Post id to delete"
        required: true
        type: "string"
      responses:
        200:
          description: "successful operation"
        404:
          description: "Post not found"
definitions:
  Post:
    type: "object"
    required:
    - "title"
    - "content"
    properties:
      id:
        type: "string"
        example: "1"
      title:
        type: "string"
        example: "what I did today"
      content:
        type: "string"
        example: "wrote a boring post" 
```
References:
https://jersey.java.net/documentation/latest/client.html
http://raml.org/


================================================================================
3 Installing the Blog Ping project
================================================================================

Please follow the steps below:

1. Download and install Maven 3. You can download it from http://maven.apache.org/download.html.
2. Download Payara, to run embedded: http://www.payara.co.uk/downloads
    Payara Micro is enough to run
3. Run the command: "mvn install" in the root folder of the distributionfolder.
4. Run the blog-web
    > java -jar payara-micro-4.1.152.1.jar --deploy blog-web\target\blog-web.war
5. Go to address: http://localhost:8080/blog-web/hello-pierce. The server should respond with a text that reads: {"message":"Hello Pierce"}.
6. Now basic environment and Blog Ping project is installed correctly.

================================================================================
4 Test plan
================================================================================

Please prepare test plan for such web service
You decide how plan will look like and what tools/presentation to use


================================================================================
5 Automated test example
================================================================================

Please create some automatic tests which resemble one of test plan test cases
You are free to use any tools (bash scripts,python, etc)