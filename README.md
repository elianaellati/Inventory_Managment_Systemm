Inventory Managment System
#
An organization can manage inventory-related duties more effectively by using an inventory management system, which is a complete software solution. The system's powerful features and user-friendly interface enable users to effectively track, monitor, and control a range of inventory management issues, such as:
-Order Management.
-Customer Management.
-Supplier Management.
-product(Item) Management.
## Below are the main resources represented in the project:
#1-Supplier: Represents the suppliers who provide items to the inventory system.
#2-Item: Represents the items available in the inventory system, provided by suppliers.
#3-Order: Represents the orders made by customers for purchasing items.
#4-Customer: Represents the customers who place orders for items.

The ER Daigram :
![image](https://github.com/elianaellati/Inventory_Managment_Systemm/assets/132192886/6c1fe8fe-d262-4f7d-863f-e6f259fe4c32)

Description:
This project aims to develop an Inventory Management System that allows tracking suppliers, items, orders, and customers within the system.
-Customer: Stores information about customers, including their ID, name, phone number,email,and orders. Each customer may have multiple orders.
-Order: Represents a purchase order made by a customer. Contains details such as order ID, date, customer ID, total price,status of the order,and list of items the customer want to purchase.
-Item: Represents individual products in the inventory. Contains attributes such as item ID, name, quantity available, price,supplier Id which supply this item and list of orders. Each item may be associated with one or more orders.
-Supplier: Stores information about suppliers who provide items to the inventory. Contains details such as supplier ID, name, address, and the list of the item the supplier supply. Each supplier may supply 
 multiple items.
From the previous description we can conduct the relations between the four resource as following:
-The customer can order muliple orders and one order will be specified for one customer so the relation is (One To Many).
-The order contains several items and many items could appear in several orders , so we conduct the relation as the following (Many To Many).
-The Supplier can supply several items and the supplied item will be conduct to one supplier.(One To Many).

Run Application :
To run the application, first ensure it's built successfully using Maven or Gradle. Once built, execute the application JAR file using the java -jar command followed by the JAR file's path.Look for any startup errors or messages in the console logs. Access the application via a web browser or API client such as Postman at http://localhost:8080 by default. Interact with the application based on its functionality, such as sending HTTP requests to exposed endpoints for a REST API.

The design and documentation for each resource:
Customer Resource:
[Customer.docx](https://github.com/elianaellati/Inventory_Managment_Systemm/files/14893196/Customer.docx)
Order Resource:
[Order.docx](https://github.com/elianaellati/Inventory_Managment_Systemm/files/14893226/Order.docx)
Item Resource:
[Item.docx](https://github.com/elianaellati/Inventory_Managment_Systemm/files/14893234/Item.docx)
Supplier Resource
[Supplier.docx](https://github.com/elianaellati/Inventory_Managment_Systemm/files/14893238/Supplier.docx)

OpenAPI Specififcation:
https://app.swaggerhub.com/apis/ELIANAELLATI2002_1/Inventory_Management/1.0.0#/



 
