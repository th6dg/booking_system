# Sytem Design

## Overview
__Focuses on the solution domain, how to implement?__

## Output
+ __Infrastructure__
+ __Data schema__
+ __Program Structure__

## 4+1 View (multi-perspective architecture)
+ __Logical view__: Flow data, flow feature in user view.<br>
Ex: Hệ thống e-commerce có các module User, Order, Payment, Product.<br>
-> Sequence Diagram, Class Diagram
+ __Development view__: Structure code, module<br>
Ex: Code được chia thành module: frontend, backend, services, library.<br>
-> package diagram, component diagram
+ __Process View__: luồng xử lý khi chạy<br>
Ex: Request đi từ load balancer → API gateway → Controller -> Service → Database<br>
-> Deployment diagram.
+ __Physical Service__: triển khai trên hạ tầng phần cứng.<br>
Ex: Hệ thống triển khai trên Kubernetes cluster, 3 node app, 2 node database, 1 node cache.<br>
-> Deployment diagram.

## C4 model (top-down view of structure)
### Context Diagram: Bird-eye view, flow context, for non-tech (Level 0)
<img src="https://www.baeldung.com/wp-content/uploads/sites/4/2024/07/context_diagram.png" width="600" alt="left">

### Container Diagram: For deployment (Level 1, API is Backend application)
<img src="https://www.baeldung.com/wp-content/uploads/sites/4/2024/07/container_diagram.png" width="600">

### Component Diagram: For dev, coder - which component inside container (Level 2, API is Controller)
<img src="https://www.baeldung.com/wp-content/uploads/sites/4/2024/07/component_diagram.png" width="600">

### Code Diagram: For dev, coder - which details in component (class and method) (Level 3)
<img src="https://media2.dev.to/dynamic/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2F0na019rcggkbklm9az95.png" width="600">


<pre>
    _______________     _____________     ______________
    |   Use Case  |     |    DFD    |     |  Sequence  |
    |   Diagram   |     |  Diagram  |     |  Diagram   |
    |_____________|     |___________|     |____________|

    _______________     ______________    ______________     
    |   Class     |     | Deployment |    |  Database  |
    |   Diagram   |     |   Diagram  |    |  Design    |
    |_____________|     |____________|    |____________|

    ____________________________                               ______________________
    |   Association (USE-A)    |                               |        CRUD        |
    |                          |                _______________|____________________|________________
    |   Aggregation (HAS-A)    |                |                                                   |    
    |   Composition            |                |               BUSINESS LOGIC                      |
    |                          |                |               SECURITY                            |
    |   Inheitance  (IS-A)     |                |               PERFORMANCE                         |
    |   Dependency             |                |               SCALABILITY                         |
    |__________________________|                |               .....                               |
                                                |___________________________________________________|
</pre>