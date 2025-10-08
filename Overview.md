## What is System?
+ Group of components linked together
+ Orgainze
+ Interconnect
+ Interdepend
+ Integration
+ __Boundary__ and __Interface__

![Image](https://www.tutorialspoint.com/system_analysis_and_design/images/system_elements.jpg)

### ############################################################################# ###
## System analysis 
__Analysis specifies what the system should do.__  

__Process__:  
+ collecting and interpreting use-case/behavior  
+ identify problem  
+ decomposition into its components  

__Activity__:
+ Requirement Gathering  
+ Requirement Analysis: USE-CASE DIAGRAM
+ Process Modelling: SEQUENCE DRAGRAM
+ Data Modelling: entity, ERD

## System design 
__How to accomplish the objective of the system__
+ defining components or modules to satisfy the specific requirements  

__Activirty__:
+ Architectural Design
+ Component Design
+ Interface Design
+ Data Design
+ Detailed Design

### ############################################################################# ###
## Communication  
__Protocol__:
+ Transport Layer Protocols
+ Internet Layer Protocols
+ Application Layer Protocols  

__Security Protocol__:
+ SSL/TLS
+ IPsec
+ SSH

## Capacity Estimation

## Web Server  
__Functionality__
+ Handling HTTP requests and responses.
+ Storing and serving static content (HTML, CSS, JavaScript).
+ Resource Management (load balancing...)
+ Security (SSL/TLS, authen/author...)

__Examples of Web Servers__
+ Apache Tomcat
+ Apache Http
+ Nginx
+ Microsoft IIS

## Proxies 
__A proxy server (deployment)__ acts as an intermediary between a client and a destination server.
+ Forward proxies
+ Reverse proxies− Positioned in front of web servers to handle requests on their behalf.

__Role__
+ Caching (Performance)
+ Filtering (Security)
+ Content Delivery 

## Clustering
__Node -> { Node1, Node2, Node3,...}__

## Load balancing
__Distributes incoming traffic across multiple servers__
__Tool__:
+ Nginx− A popular open-source reverse proxy and load balancer.
+ HAProxy
+ AWS Elastic Load Balancing (ELB)
+ Azure Load Balancer
+ Traefik