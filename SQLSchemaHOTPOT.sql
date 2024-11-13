CREATE DATABASE FoodDeliveryDB;

USE FoodDeliveryDB;


-- Users Table - Stores basic user login and role information
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Role ENUM('Customer', 'Admin', 'Restaurant') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    IsActive BOOLEAN DEFAULT TRUE
);

-- Addresses Table - Stores basic address information for users
CREATE TABLE Addresses (
    AddressID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    AddressLine VARCHAR(100) NOT NULL,
    City VARCHAR(50) NOT NULL,
    State VARCHAR(50) NOT NULL,
    PostalCode VARCHAR(10) NOT NULL,
    IsDefault BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Restaurants Table - Stores basic restaurant information
CREATE TABLE Restaurants (
    RestaurantID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT, -- Linked to Users table to manage restaurants by user
    Name VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15) NOT NULL,
    City VARCHAR(50) NOT NULL,
    IsActive BOOLEAN DEFAULT TRUE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Categories Table - Stores menu categories
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL
);

-- MenuItems Table - Stores restaurant menu items with basic details
CREATE TABLE MenuItems (
    MenuItemID INT PRIMARY KEY AUTO_INCREMENT,
    RestaurantID INT,
    CategoryID INT,
    Name VARCHAR(100) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    IsAvailable BOOLEAN DEFAULT TRUE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Cart Table - Stores user's shopping cart
CREATE TABLE Cart (
    CartID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- CartItems Table - Stores items in user's cart
CREATE TABLE CartItems (
    CartItemID INT PRIMARY KEY AUTO_INCREMENT,
    CartID INT,
    MenuItemID INT,
    Quantity INT NOT NULL,
    FOREIGN KEY (CartID) REFERENCES Cart(CartID),
    FOREIGN KEY (MenuItemID) REFERENCES MenuItems(MenuItemID)
);

-- Orders Table - Stores order information with essential fields
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    RestaurantID INT,
    AddressID INT,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    OrderStatus ENUM('Pending', 'Confirmed', 'Delivered', 'Cancelled') NOT NULL,
    PaymentStatus ENUM('Pending', 'Completed') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID),
    FOREIGN KEY (AddressID) REFERENCES Addresses(AddressID)
);

-- OrderItems Table - Stores items in an order
CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    MenuItemID INT,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (MenuItemID) REFERENCES MenuItems(MenuItemID)
);

-- OrderTracking Table - Stores order status updates
CREATE TABLE OrderTracking (
    TrackingID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    Status ENUM('Pending', 'Confirmed', 'Delivered', 'Cancelled') NOT NULL,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);
