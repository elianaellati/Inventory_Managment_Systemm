[ELIANAELLATI2002_1-Inventory_Management-1.0.0-swagger (1).json](https://github.com/elianaellati/Inventory_Managment/files/14892759/ELIANAELLATI2002_1-Inventory_Management-1.0.0-swagger.1.json)The ER Daigram :





Project Description
This project aims to develop an Inventory Management System that allows tracking suppliers, items, orders, and customers within the system.
Below are the main resources represented in the project:
1-Supplier: Represents the suppliers who provide items to the inventory system.
2-Item: Represents the items available in the inventory system, provided by suppliers.
3-Order: Represents the orders made by customers for purchasing items.
4-Customer: Represents the customers who place orders for items.

![erd](https://github.com/elianaellati/Inventory_Managment/assets/132192886/b3a0fceb-d091-4c46-80c7-5de3a9acbf48)

[Untitled document (8).docx](https://github.com/elianaellati/Inventory_Managment/files/14885801/Untitled.document.8.docx)


[Uploading ELIANAELLATI2002_1-Inventory_{
  "openapi" : "3.1.0",
  "info" : {
    "version" : "1.0.0",
    "title" : "Inventory_Management_System",
    "description" : "Its an API which allows customers to order several items",
    "contact" : {
      "name" : "Eliana Ellati"
    }
  },
  "tags" : [ {
    "name" : "Customers",
    "description" : "Everything about your Customers"
  }, {
    "name" : "Orders",
    "description" : "Access to Customer orders"
  }, {
    "name" : "Items",
    "description" : "description about the Items"
  }, {
    "name" : "Suppliers",
    "description" : "Information about the suppliers we have"
  } ],
  "paths" : {
    "/customers" : {
      "get" : {
        "tags" : [ "Customers" ],
        "summary" : "Retrieve all customers",
        "operationId" : "retrieveCustomers",
        "responses" : {
          "200" : {
            "description" : "A list of customers"
          },
          "404" : {
            "description" : "No Customers Found",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Customer"
                  }
                }
              }
            }
          }
        }
      },
      "post" : {
        "tags" : [ "Customers" ],
        "summary" : "Save a new customer",
        "operationId" : "addCustomer",
        "requestBody" : {
          "description" : "Create a new Customer",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Customer"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "created Successfully"
          },
          "405" : {
            "description" : "Invalid Input"
          }
        }
      }
    },
    "/customers/{Id}" : {
      "get" : {
        "tags" : [ "Customers" ],
        "summary" : "Retrieve a specific customer by Id",
        "operationId" : "retrieveCustomerById",
        "parameters" : [ {
          "in" : "path",
          "name" : "Id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the customer to retrieve"
        } ],
        "responses" : {
          "200" : {
            "description" : "SuccessfullyRetrieved",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/Customer"
                }
              }
            }
          },
          "404" : {
            "description" : "Cannot Found"
          }
        }
      },
      "delete" : {
        "tags" : [ "Customers" ],
        "summary" : "Delete a customer",
        "operationId" : "deleteCustomer",
        "parameters" : [ {
          "in" : "path",
          "name" : "Id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the customer to delete"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Deleted"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "put" : {
        "tags" : [ "Customers" ],
        "summary" : "Update a customer",
        "operationId" : "updateCustomer",
        "parameters" : [ {
          "in" : "path",
          "name" : "Id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the customer to be updated"
        } ],
        "requestBody" : {
          "description" : "Update an existent customer",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Customer"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "200" : {
            "description" : "Successfully updated"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      }
    },
    "/customers/{id}/orders" : {
      "post" : {
        "tags" : [ "Customers" ],
        "summary" : "Add orders for a specific customer",
        "operationId" : "addOrdersForCustomer",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "ID of the customer for whom orders are to be added",
          "example" : 1,
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64"
          }
        } ],
        "requestBody" : {
          "required" : true,
          "content" : {
            "application/json" : {
              "schema" : {
                "type" : "array",
                "items" : {
                  "$ref" : "#/components/schemas/Order"
                }
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Orders added successfully for the specified customer"
          },
          "400" : {
            "description" : "Bad request. Check request body for errors."
          },
          "404" : {
            "description" : "Customer not found. Unable to add orders."
          }
        }
      },
      "get" : {
        "tags" : [ "Customers" ],
        "summary" : "Retrieve orders for a specific customer",
        "operationId" : "retrieveOrdersForACustomer",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "ID of the customer whose orders are to be retrieved",
          "required" : true,
          "example" : 1,
          "schema" : {
            "type" : "integer",
            "format" : "int64"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "A list of orders for the specified customer",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Order"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Customer not found or no orders found for the customer"
          }
        }
      }
    },
    "/orders" : {
      "get" : {
        "tags" : [ "Orders" ],
        "summary" : "Retrieve all orders",
        "operationId" : "retrieveOrders",
        "responses" : {
          "200" : {
            "description" : "A list of Orders",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Order"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "No orders"
          }
        }
      }
    },
    "/orders/{id}" : {
      "post" : {
        "tags" : [ "Orders" ],
        "summary" : "Add items for a specific order",
        "operationId" : "addItemsForOrder",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "ID of the order for whom the items are to be added",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          }
        } ],
        "requestBody" : {
          "required" : true,
          "content" : {
            "application/json" : {
              "schema" : {
                "items" : {
                  "type" : "array",
                  "items" : null
                },
                "description" : "List of items associated with the order"
              },
              "example" : {
                "id" : 1,
                "quantity" : 3,
                "itemName" : "Snikers"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Items added successfully for the specified order"
          },
          "400" : {
            "description" : "Bad request. Check request body for errors."
          },
          "404" : {
            "description" : "order not found. Unable to add items."
          }
        }
      },
      "get" : {
        "tags" : [ "Orders" ],
        "summary" : "retrieve an order for specific id",
        "operationId" : "retrieveOrderById",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the order to be retrieved"
        } ],
        "responses" : {
          "200" : {
            "description" : "An object of order for specified id",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Order"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "delete" : {
        "tags" : [ "Orders" ],
        "summary" : "Delete an order",
        "operationId" : "deleteOrder",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the customer to delete"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Deleted"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "put" : {
        "tags" : [ "Orders" ],
        "summary" : "Update an order",
        "operationId" : "updateAnOrder",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the order to be updated"
        } ],
        "requestBody" : {
          "description" : "Update an existent order",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Order"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "200" : {
            "description" : "Successfully updated"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      }
    },
    "/orders/{id}/items" : {
      "get" : {
        "tags" : [ "Orders" ],
        "summary" : "retrieve an items for specific order",
        "operationId" : "retrieveItemsBySpecificOrder",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the order to be retrieved"
        } ],
        "responses" : {
          "200" : {
            "description" : "List of items for specified order",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "properties" : {
                      "id" : {
                        "type" : "integer",
                        "format" : "int64",
                        "example" : 1,
                        "description" : "ID of the item to be added"
                      },
                      "quantity" : {
                        "type" : "integer",
                        "example" : 3,
                        "description" : "Quantity of the item to be added"
                      },
                      "itemName" : {
                        "type" : "string",
                        "example" : "Snickers",
                        "description" : "Name of the item to be added"
                      }
                    }
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      }
    },
    "/orders/status/{status}" : {
      "get" : {
        "tags" : [ "Orders" ],
        "summary" : "Finds order by specific status",
        "operationId" : "retrieveOrdersBySpecificStatus",
        "parameters" : [ {
          "name" : "status",
          "in" : "path",
          "description" : "Status values that need to be considered for filter",
          "example" : "pending",
          "required" : true,
          "schema" : {
            "type" : "string",
            "default" : "available",
            "enum" : [ "pending", "approved", "delivered" ]
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "successful operation",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Order"
                  }
                }
              }
            }
          },
          "400" : {
            "description" : "Invalid status value"
          }
        }
      }
    },
    "/orders/date/{Date}" : {
      "get" : {
        "tags" : [ "Orders" ],
        "summary" : "Finds order by specific date",
        "operationId" : "retrieveOrdersBySpecificDate",
        "parameters" : [ {
          "name" : "Date",
          "in" : "path",
          "description" : "Dates values that need to be considered for filter",
          "required" : true,
          "schema" : {
            "type" : "string",
            "format" : "date"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "successful operation",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Order"
                  }
                }
              }
            }
          },
          "400" : {
            "description" : "Invalid status value"
          }
        }
      }
    },
    "/items" : {
      "get" : {
        "tags" : [ "Items" ],
        "summary" : "Retrieve all items",
        "operationId" : "retrieveItems",
        "responses" : {
          "200" : {
            "description" : "A list of items",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Items"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "No items"
          }
        }
      },
      "post" : {
        "tags" : [ "Items" ],
        "summary" : "Save new Items",
        "operationId" : "addItem",
        "requestBody" : {
          "description" : "Create a new Item",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Items"
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "created Successfully"
          },
          "405" : {
            "description" : "Invalid Input"
          }
        }
      }
    },
    "/items/{id}" : {
      "get" : {
        "tags" : [ "Items" ],
        "summary" : "Retrieve a specific item by Id",
        "operationId" : "retrieveItemById",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the Item to retrieve"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Retrieved",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Items"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "delete" : {
        "tags" : [ "Items" ],
        "summary" : "Delete an item",
        "operationId" : "deleteAnItem",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the Item to delete"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Deleted"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "put" : {
        "tags" : [ "Items" ],
        "summary" : "Update an item",
        "operationId" : "updateItem",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the Item to be updated"
        } ],
        "requestBody" : {
          "description" : "Update an existent item",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Items"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "200" : {
            "description" : "Successfully updated"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      }
    },
    "/items/{id}/orders" : {
      "get" : {
        "tags" : [ "Items" ],
        "summary" : "Retrieve orders for a specific item",
        "operationId" : "retrieveOrdersForItem",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "ID of the item",
          "example" : 1,
          "required" : true,
          "schema" : {
            "type" : "integer"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "A list of orders containing the specified item",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "properties" : {
                      "id" : {
                        "type" : "integer",
                        "format" : "int64",
                        "example" : 1,
                        "description" : "ID of the order"
                      },
                      "OrderDate" : {
                        "type" : "string",
                        "format" : "date-time",
                        "description" : "Date of the order"
                      },
                      "status" : {
                        "type" : "string",
                        "example" : "pending",
                        "description" : "status of the order"
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    },
    "/suppliers" : {
      "get" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Retrieve all suppliers",
        "operationId" : "retrieveAllSuppliers",
        "responses" : {
          "200" : {
            "description" : "A list of suppliers",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Suppliers"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Not Found"
          }
        }
      },
      "post" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Save new supplier",
        "operationId" : "addNewSupplier",
        "requestBody" : {
          "description" : "Create a new supplier",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Suppliers"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "created Successfully"
          },
          "405" : {
            "description" : "Invalid Input"
          }
        }
      }
    },
    "/supplier/{id}" : {
      "get" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Retrieve a specific supplier by Id",
        "operationId" : "retrieveSupplierById",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the supplier to retrieve"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Retrieved",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Suppliers"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "delete" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Delete an supplier",
        "operationId" : "deleteAnSupplier",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the Supplier to delete"
        } ],
        "responses" : {
          "200" : {
            "description" : "Successfully Deleted"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      },
      "put" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Update an supplier",
        "operationId" : "updateSupplier",
        "parameters" : [ {
          "in" : "path",
          "name" : "id",
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1
          },
          "description" : "ID of the supplier to be updated"
        } ],
        "requestBody" : {
          "description" : "Update an existent supplier",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/Suppliers"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "200" : {
            "description" : "Successfully updated"
          },
          "404" : {
            "description" : "Cannot Found"
          },
          "400" : {
            "description" : "Invalid  value"
          }
        }
      }
    },
    "/supplier/{id}/items" : {
      "get" : {
        "tags" : [ "Suppliers" ],
        "summary" : "Retrieve items associated with a specific supplier",
        "operationId" : "retrieveItemsBySpecificId",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "ID of the supplier",
          "example" : 1,
          "required" : true,
          "schema" : {
            "type" : "integer",
            "format" : "int64"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "A list of items associated with the specified supplier",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/Items"
                  }
                }
              }
            }
          },
          "404" : {
            "description" : "Supplier not found or no items associated with the supplier"
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "Customer" : {
        "type" : "object",
        "properties" : {
          "id" : {
            "type" : "integer",
            "example" : 1,
            "format" : "int64",
            "description" : "Unique identifier for the customer"
          },
          "name" : {
            "type" : "string",
            "example" : "eliana ellati",
            "description" : "Name of the customer"
          },
          "email" : {
            "type" : "string",
            "example" : "elianaellati@gmail.com",
            "format" : "email",
            "description" : "Email address of the customer"
          },
          "phone_number" : {
            "type" : "string",
            "example" : "0568722660",
            "description" : "phone number of the customer"
          },
          "orders" : {
            "type" : "array",
            "items" : {
              "$ref" : "#/components/schemas/Order"
            },
            "description" : "List of orders associated with the customer"
          }
        },
        "required" : [ "name", "email", "phone_number" ]
      },
      "Order" : {
        "type" : "object",
        "properties" : {
          "id" : {
            "type" : "integer",
            "example" : 1,
            "format" : "int64",
            "description" : "Unique identifier for the order"
          },
          "customerId" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1,
            "description" : "The ID for the Customer"
          },
          "OrderDate" : {
            "type" : "string",
            "format" : "date-time",
            "description" : "Date of the order"
          },
          "status" : {
            "type" : "string",
            "description" : "Order Status",
            "example" : "pending",
            "enum" : [ "pending", "approved", "delivered", "canceled" ]
          },
          "totalPrice" : {
            "type" : "number",
            "format" : "double",
            "example" : 18
          },
          "items" : {
            "type" : "array",
            "items" : {
              "description" : "List of items associated with the order",
              "example" : {
                "id" : 1,
                "quantity" : 3,
                "itemName" : "Snikers"
              }
            }
          }
        },
        "required" : [ "OrderDate", "status" ]
      },
      "Items" : {
        "type" : "object",
        "properties" : {
          "id" : {
            "type" : "integer",
            "example" : 1,
            "format" : "int64",
            "description" : "Unique identifier for the item"
          },
          "itemName" : {
            "type" : "string",
            "description" : "The Name of the item",
            "example" : "Snikers"
          },
          "quantity" : {
            "type" : "number",
            "format" : "double",
            "example" : 10,
            "description" : "Quantity of the item"
          },
          "price" : {
            "type" : "number",
            "format" : "double",
            "example" : 6,
            "description" : "price of the item"
          },
          "supplierId" : {
            "type" : "integer",
            "format" : "int64",
            "example" : 1,
            "description" : "The ID for the supplier"
          },
          "ordersContainTheItem" : {
            "type" : "array",
            "items" : {
              "$ref" : "#/components/schemas/Order"
            },
            "description" : "List of orders containg specified item",
            "example" : [ ]
          }
        },
        "required" : [ "itemName", "quantity", "price", "supplierId" ]
      },
      "Suppliers" : {
        "type" : "object",
        "properties" : {
          "id" : {
            "type" : "integer",
            "example" : 1,
            "format" : "int64",
            "description" : "Unique identifier for the supplier"
          },
          "name" : {
            "type" : "string",
            "description" : "The Name of the supplier",
            "example" : "Yousef Khalil"
          },
          "address" : {
            "type" : "string",
            "description" : "The address of the supplier",
            "example" : "Al-Masyoun,Al Bazar"
          },
          "phone_number" : {
            "type" : "string",
            "description" : "The Number of the supplier",
            "example" : "0599722660"
          },
          "itemsToSupply" : {
            "type" : "array",
            "items" : {
              "$ref" : "#/components/schemas/Items"
            },
            "description" : "List of orders associated with the customer"
          }
        },
        "required" : [ "name", "address", "phone_number" ]
      }
    }
  }
}Management-1.0.0-swagger (1).json…]()











