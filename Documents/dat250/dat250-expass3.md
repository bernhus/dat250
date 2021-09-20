## DAT250: Software Technology Experiment Assignment 3


#### Installation of MongoDB

* The correct validation of the installation package:
![screenshot](img/img3.1.png)




Experiment 1
  ---
* Screenshots:
    * Insert documents:
    ![screenshot](img/img3.2.png)
    
    * Query documents
    ![screenshot](img/img3.3.png)
    
    * Update documents:
    ![screenshot](img/img3.4.png)
    
    * Remove documents:
    ![screenshot](img/img3.5.png)
    
    * Bulk write operations:
    ![screenshot](img/img3.6.png)
    (tiny problem with pasting the code into the cmd so opened the mongosh scipt for the bulk write operations.)
    
    

Experiment 2    
  ---
  Shows a new map_reduce table where the customer identity is mapped onto the date som you are able to se the customers making an order on a given date.
    
    var mapFunction = function () {
        emit(this.ord_date, this.cust_id); 
    };
    
    var reduceFunction = function (keyDate, valueCustId) { 
        return Array(valueCustId); 
    };
  
  ![screenshot](img/img3.7.png)
  


#### Pending Isssues
No pending issues.