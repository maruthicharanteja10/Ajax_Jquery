# Spring MVC with AJAX

## What is AJAX?
AJAX (**Asynchronous JavaScript and XML**) is a technique for creating fast and interactive web applications using:
- **JavaScript**
- **HTML**
- **CSS**
- **XML or JSON** for data exchange

### Key Features of AJAX:
- Sends asynchronous requests to the server.
- Reduces the need for full-page reloads.
- Provides a smoother user experience.

### Synchronous vs. Asynchronous Calls
#### **Synchronous Call**
- The JavaScript execution is blocked until the server response is received.
- The complete webpage is reloaded when a synchronous request is made.

#### **Asynchronous Call**
- The browser remains responsive while waiting for the server response.
- The JavaScript engine is not blocked, allowing users to perform other actions.
- The complete page is **not** reloaded.

## Handling Responses in Asynchronous AJAX Requests
Responses in AJAX are handled using **callbacks**:
- A callback function is executed when the server sends data back to the client.

---

# What is jQuery?
**jQuery** is a fast, lightweight, and feature-rich JavaScript library that simplifies:
- DOM manipulation
- Event handling
- Animations
- AJAX interactions

### Why Use jQuery?
- Simplifies JavaScript programming.
- Provides easy AJAX integration.
- Ensures cross-browser compatibility.
- Lightweight and faster than raw JavaScript.

### jQuery is Used by:
- **Google**
- **Microsoft**
- **IBM**
- **Netflix**

**Note:** jQuery works the same across all browsers.

---

# Events in JavaScript
An **event** is an action that occurs in the browser, triggering a response in JavaScript.

### Common Events:

| **Mouse Events**  | **Keyboard Events** | **Form Events** | **Document/Window Events** |
|------------------|------------------|-------------|----------------------|
| click           | keypress         | submit      | load                 |
| dblclick        | keydown          | change      | resize               |
| mouseenter      | keyup            | focus       | scroll               |
| mouseleave      |                  | blur        | unload               |

---

# AJAX with jQuery

### jQuery `load()` Method
The **`load()`** method fetches data from the server and injects it into the selected HTML element.

#### **Example:**
```javascript
$("button").click(function(){  
    $("#div1").load("demo_test.txt", function(responseTxt, statusTxt, xhr){  
        if(statusTxt == "success")  
            alert("External content loaded successfully!");  
        if(statusTxt == "error")  
            alert("Error: " + xhr.status + ": " + xhr.statusText);  
    });  
});
```

### AJAX `get()` and `post()` Methods
- **GET** - Requests data from the server.
- **POST** - Sends data to the server for processing.

#### **Example:** AJAX Request with jQuery
```javascript
$(document).ready(function() {   
    $.ajax({   
        type: "GET",  
        url: "remote_url",   
        success: function(result) {  
            // Process the result   
        },  
        error: function() {  
            // Handle error   
        }  
    });  
});
```

---

# Spring MVC with AJAX
## **1. Spring MVC Controller**

The Spring MVC controller handles AJAX requests and returns JSON responses.

#### **Controller Example:**
```java
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
```

## **2. AJAX Call in jQuery**
The frontend can use jQuery to send an AJAX request to fetch data from the server.

#### **AJAX Call Example:**
```javascript
$(document).ready(function() {
    $("#loadEmployees").click(function() {
        $.ajax({
            type: "GET",
            url: "/employee/list",
            success: function(response) {
                let table = "<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th></tr>";
                response.forEach(employee => {
                    table += `<tr><td>${employee.id}</td><td>${employee.name}</td><td>${employee.department}</td></tr>`;
                });
                table += "</table>";
                $("#employeeTable").html(table);
            },
            error: function() {
                alert("Error fetching employee data");
            }
        });
    });
});
```

## **3. HTML Page with AJAX Integration**

```html
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="ajax-script.js"></script>
</head>
<body>
    <h2>Employee List</h2>
    <button id="loadEmployees">Load Employees</button>
    <div id="employeeTable"></div>
</body>
</html>
```

## **4. Response from Spring Boot**

The response is returned in JSON format:
```json
[
    {"id": 1, "name": "John Doe", "department": "IT"},
    {"id": 2, "name": "Jane Smith", "department": "HR"}
]
```

---

# Conclusion
- AJAX helps make web applications dynamic and fast.
- jQuery simplifies AJAX calls.
- Spring MVC can be integrated with AJAX for seamless data fetching.
- JSON format is commonly used for AJAX responses in Spring Boot applications.

This setup ensures a **responsive**, **efficient**, and **interactive** user experience in Spring MVC applications using AJAX.

